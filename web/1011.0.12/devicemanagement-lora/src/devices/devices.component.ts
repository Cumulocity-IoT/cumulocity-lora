import { _ } from '@c8y/ngx-components';
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { InventoryService, IManagedObject, IOperation, IdentityService, OperationService, IEvent, EventService } from '@c8y/client';
import { ActivatedRoute } from '@angular/router';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { FormGroup } from '@angular/forms';
import { FormlyFormOptions, FormlyFieldConfig } from '@ngx-formly/core';
import { DeviceOperation } from '../../src/onboarding/codecs/DeviceOperation';
import { DeviceOperationElement, ParamType } from '../../src/onboarding/codecs/DeviceOperationElement';
import { CodecService } from '../../src/service/CodecService';
import { LnsService } from '../../src/service/LnsService';

@Component({
    selector: 'devices',
    templateUrl: './devices.component.html'
})
export class DevicesComponent implements OnInit {
    async ngOnInit(): Promise<void> {

    }
    commands: {};
    device: IManagedObject;
    selectedLnsConnectorId: string;
    model: string;
    codec: string;
    useGatewayPosition: boolean = true;
    previewCommand: { success: boolean, message: string, response: any };
    devEui: string;
    @ViewChild('errorModal', { static: false })
    errorModal: TemplateRef<any>;
    errorModalRef: BsModalRef;
    models: Map<string, string>;
    unprocessedPayloads: IEvent[];
    commandChoice: string;
    deviceProvisioningAdditionalProperties = {};
    properties: [{
        name: string;
        label: string;
        required: boolean;
        type: string;
        url: string;
        values: Map<string, string>;
    }?];

    form = new FormGroup({});
    parameterValues: any = {};
    options: FormlyFormOptions = {};
    fields: FormlyFieldConfig[][] = new Array<FormlyFieldConfig[]>();

    constructor(public route: ActivatedRoute, public lnsService: LnsService, public codecService: CodecService, private inventory: InventoryService, private identity: IdentityService, private operationService: OperationService, private modalService: BsModalService, private eventService: EventService) {
        console.log(route.snapshot.parent.data.contextData.id);
        // _ annotation to mark this string as translatable string.
        this.init();
    }

    async init() {
        await this.getCodecAndModel();
    }

    async getCodecAndModel() {
        let deviceId: string = this.route.snapshot.parent.data.contextData.id;
        const { data, res, paging } = await this.inventory.detail(deviceId);
        this.device = data;
        this.selectedLnsConnectorId = this.device.lnsConnectorId;
        if (this.device.codec) {
            this.codec = this.device.codec;
            await this.loadModels(this.device.codec);
        }
        if (this.device.useGatewayPosition === undefined) {
            this.useGatewayPosition = true;
        } else {
            this.useGatewayPosition = this.device.useGatewayPosition;
        }
        if (this.device.c8y_Hardware) {
            this.model = this.device.c8y_Hardware.model;
            await this.loadCommands();
        }
    }

    async loadCommands() {
        let deviceId: string = this.route.snapshot.parent.data.contextData.id;
        this.getUnprocessPayloads();
        this.commands = await this.codecService.getOperations(this.device.codec, this.model);
        console.log(this.commands);
        this.fields = new Array<FormlyFieldConfig[]>();
        Object.keys(this.commands).forEach(command => {
            this.fields[command] = this.getFields(this.commands[command]);
        });
        (await this.identity.list(deviceId)).data.forEach(extId => {
            if (extId.type === 'LoRa devEUI') {
                this.devEui = extId.externalId;
            }
        });
    }

    getFieldFromElement(element: DeviceOperationElement): FormlyFieldConfig {
        let field: FormlyFieldConfig = {key: element.id, templateOptions: {label: element.name}};

        switch(element.type) {
            case ParamType.STRING:
                field.type = 'input';
                field.templateOptions.type = 'text';
                field.templateOptions.required = true;
                break;
            case ParamType.INTEGER:
            case ParamType.FLOAT:
                field.type = 'input';
                field.templateOptions.type = 'number';
                field.templateOptions.required = true;
                break;
            case ParamType.BOOL:
                field.type = 'checkbox';
                break;
            case ParamType.DATE:
                field.type = 'input';
                field.templateOptions.type = 'date';
                break;
            case ParamType.ENUM:
                field.type = 'radio';
                field.templateOptions.options = element.value.map(e => {return {label: e, value: e}});
                break;
            case ParamType.GROUP:
                if (element.dependsOnParam) {
                    field.hideExpression = () => {return this.parameterValues[element.dependsOnParamId] != element.dependsOnParamValue};
                }
                if (element.repeatable) {
                    field.type = 'repeat';
                    field.templateOptions.addText = 'Add ' + element.name;
                    field.templateOptions.removeText = 'Remove ' + element.name;
                    field.templateOptions.minOccur = element.minOccur;
                    field.templateOptions.maxOccur = element.maxOccur;
                    field.fieldArray = {templateOptions: {label: element.name}, wrappers: ['panel'], fieldGroup: element.elements.map(e => this.getFieldFromElement(e))};
                    if (element.minOccur > 0) {
                        field.defaultValue = [];
                        for(var i=0;i<element.minOccur;i++) {
                            field.defaultValue.push({});
                        }
                    }
                } else {
                    field.wrappers = ['panel'];
                    field.fieldGroup = element.elements.map(e => this.getFieldFromElement(e));
                }
                break;
        }

        return field;
    }

    getFields(command: DeviceOperation): FormlyFieldConfig[] {
        return command && command.elements ? command.elements.map(e => this.getFieldFromElement(e)) : [];
    }

    async preview(command, parameters) {
        console.log(parameters);
        let params = parameters ? JSON.stringify(parameters) : "{}";
        let toEncode = {
            devEui: this.devEui,
            operation: '{"' + command + '":' + params + '}',
            model: this.device.c8y_Hardware !== undefined ? this.device.c8y_Hardware.model || 'a' : 'a'
        }
        console.log(toEncode);
        this.previewCommand = await this.codecService.encode(this.device.codec, toEncode);
        console.dir(this.previewCommand);
        if (!this.previewCommand.success) {
            this.errorModalRef = this.modalService.show(this.errorModal);
        }
    }

    async send(command, parameters) {
        let params = parameters ? JSON.stringify(parameters) : "{}";
        let operation: IOperation = {
            deviceId: this.device.id,
            c8y_Command: {
                text: '{"' + command + '":' + params + '}'
            },
            description: "Execute command " + command
        }
        this.operationService.create(operation);
    }

    async loadModels(codec) {
        console.log("Loading models for codec " + codec);
        this.models = await this.codecService.getModels(codec);
        if (!this.models[this.model]) {
            this.model = undefined;
        }
        console.log(this.models);
        console.log(this.model);
    }

    updateDeviceCodec() {
        let device: Partial<IManagedObject> = {
            id: this.device.id,
            codec: this.codec,
            useGatewayPosition: this.useGatewayPosition,
            c8y_Hardware: { model: this.model }
        }

        this.inventory.update(device);
        this.device.codec = this.codec;
        this.device.c8y_Hardware = {model: this.model};
        this.loadCommands();
    }

    getUnprocessPayloads() {
        this.unprocessedPayloads = new Array<IEvent>();
        this.eventService.list({ source: this.device.id, type: "LoRaPayload", pageSize: 1000 }).then(data => {
            data.data.forEach(event => {
                if (!event.processed) {
                    this.unprocessedPayloads.push(event);
                }
            })
        })
    }

    async processPayloads() {
        this.unprocessedPayloads.forEach(async event => {
            let toDecode = {
                deveui: this.devEui,
                model: this.model,
                fPort: event.port,
                payload: event.payload,
                updateTime: new Date(event.time).getTime()
            }
            console.log(toDecode);
            let decodeResult = await this.codecService.decode(this.device.codec, toDecode);
            if (decodeResult.success) {
                event.processed = true;
                event.creationTime = null;
                event.time = null;
                event.type = null;
                event.source = null;
                await this.eventService.update(event);
            }
        });
        this.getUnprocessPayloads();
    }

    async loadProperties(instance: string) {
        let props = await this.lnsService.getDeviceProvisioningAdditionalProperties(instance);
        this.properties = props.properties;
        this.deviceProvisioningAdditionalProperties = props.values;
        console.dir(this.properties);
        console.dir(this.deviceProvisioningAdditionalProperties);
    }

    async updateConnector() {
        try {
            await this.lnsService.deprovisionDevice(this.device);
        } catch(e) {
            console.log(e);
        }
        try {
            let response = await this.lnsService.provisionDevice({appEUI: this.device.appEUI, appKey: this.device.appKey, devEUI: this.devEui, codec: this.device.codec, model: this.device.c8y_Hardware.model, name: this.device.name, type: this.device.type}, this.selectedLnsConnectorId, this.deviceProvisioningAdditionalProperties);
            console.log(response);
        } catch(e) {
            console.log(e);
        }
        this.device.lnsConnectorId = this.selectedLnsConnectorId;
    }
}
