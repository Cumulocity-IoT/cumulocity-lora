import { Component } from "@angular/core";
import { IManagedObject, InventoryService } from "@c8y/client";
import { ECharts, EChartsOption } from 'echarts';
import { LnsService } from "../service/LnsService";
import { Location } from "@angular/common";

@Component({
    selector: "loramonitoring",
    templateUrl: "./monitor.component.html"
})
export class MonitorComponent {
    needCleanUp = false;
    displayWrongLinks = true;
    nodes: Partial<IManagedObject>[] = [];
    nodeIds: string[] = [];
    chartInstance: ECharts;
    links: {source: string, target: string, lineStyle?: any}[] = [];
    chartOption: EChartsOption = {
        title: {
            text: "LoRa Monitoring\n(click connectors to display devices and gateways)"
        },
        legend: [
            {
                data: ["Connector Type", "Connector", "Gateway", "Device"]
            }
        ],
        series: [
            {
                type: "graph",
                layout: "force",
                draggable: true,
                symbol: "roundRect",
                symbolSize: 10,
                edgeSymbol: ['circle', 'arrow'],
                edgeSymbolSize: [4, 10],
                nodes: this.nodes,
                links: this.links,
                categories: [{name: "Connector Type"}, {name: "Connector"}, {name: "Gateway"}, {name: "Device"}],
                roam: true,
                label: {
                  show: true,
                  position: 'right',
                  formatter: '{b}',
                  rich: {
                    title: {
                        color: '#eee',
                        align: 'center'
                      },
                      head: {
                        backgroundColor: '#333',
                        width: '100%',
                        align: 'right',
                        height: 25,
                        borderRadius: [4, 4, 0, 0]
                      },
                      row: {
                        height: 30,
                      },
                      available: {
                        fontSize: "2em",
                        color: "#0f0"
                      },
                      unavailable: {
                        fontSize: "2em",
                        color: "#f00"
                      },
                      notmonitored: {
                        fontSize: "2em",
                        color: "#eee"
                      }
                  }
                },
                scaleLimit: {
                  min: 0.4,
                  max: 2
                },
                lineStyle: {
                  color: 'source',
                },
                force: {
                    repulsion: 100,
                }
            }
        ]
    };

    constructor(private lnsService: LnsService, private inventory: InventoryService, public location: Location) {
    }

    getAvailabilityStyle(mor: IManagedObject): string {
        let result: string = "notmonitored";
        if (mor.c8y_Availability) {
            result = mor.c8y_Availability.status === "AVAILABLE" ? "available" : "unavailable";
        }
        return result;
    }

    async setup() {
        this.chartInstance.setOption(this.chartOption);
        this.nodes.length = 0;
        this.links.length = 0;
        await this.lnsService.loadProxies();
        await this.lnsService.loadInstances();
        this.nodes.push(...this.lnsService.lnsProxies);
        this.chartInstance.setOption({series: [{
            roam: true,
            nodes: this.nodes,
            links: this.links,
        }]});
        this.nodes.push(...this.lnsService.lnsInstances);
        this.chartInstance.setOption({series: [{
            roam: true,
            nodes: this.nodes,
            links: this.links,
        }]});
        this.nodes.forEach(n => {
            if (n.type === "LNS Connector") {
                n.category = 1;
                n.symbol = "diamond";
            } else {
                n.category = 0;
                n.symbol = "triangle";
            }
        })
        this.links.push(...this.buildLinks());
        this.chartInstance.setOption({series: [{
            roam: true,
            nodes: this.nodes,
            links: this.links,
        }]});
        console.log(this.chartOption);
    }

    buildLinks(): {source: string, target: string}[] {
        let result: {source: string, target: string}[] = [];

        this.lnsService.lnsProxies.forEach(p => {
            p.childDevices.references.forEach(c => {
                result.push({source: p.id, target: c.managedObject.id})
            })
        })

        return result;
    }

    async onChartInit(e: ECharts) {
        this.chartInstance = e;
        this.chartInstance.on("click", params => {
            if (params.dataType === "node") {
                console.log(params.data);
                if (params.data["type"] === "LNS Connector" && !params.data["unfold"]) {
                    this.loadDevicesForConnector(params.data["id"]);
                    this.loadGatewaysForConnector(params.data["id"]);
                    params.data["unfold"] = true;
                }
                if (params.data["lora_ns_device_LoRaDevice"] || params.data["lora_ns_gateway_LoRaGateway"]) {
                    this.location.replaceState("/device/" + params.data["id"]);
                }
            }
        })
        console.log('on chart init:', e);
        this.setup();
    }
    
    async getDevices(filter?: any): Promise<IManagedObject[]> {
        let result: IManagedObject[] = [];
        let baseFilter = {pageSize: 100, withTotalPages: true, withParents: true};
        let query: any = {__or: {__has: "lora_ns_device_LoRaDevice", type: "c8y_LoRaDevice"}};
        if (filter) {
            query = {__and: {...query, ...filter}};
        }
        let response = await this.inventory.listQueryDevices(query, baseFilter);
        result.push(...response.data);
        if (response.paging.totalPages > 1) {
            while (response.paging.currentPage < response.paging.totalPages) {
                response = await response.paging.next(filter);
                result.push(...response.data);
            }
        }
        return result;
    }

    async loadDevicesForConnector(connector: string) {
        let devices = await this.getDevices({lnsConnectorId: connector});
        devices.forEach(async d => {
            d.category = "Device";
            this.links.push({source: d.lnsConnectorId, target: d.id});
            d.deviceParents.references.forEach(p => {
                if (p.managedObject.id != d.lnsConnectorId && this.displayWrongLinks) {
                    this.links.push({source: p.managedObject.id, target: d.id, lineStyle: {color: "red", width: 5}});
                    this.needCleanUp = true;
                }
            });
            d.symbol = "circle";
            d.label = {
                show: true,
                position: "right",
                formatter: "{title|{b}}{" + this.getAvailabilityStyle(d) + "|•}{head|}\n{row|EUI: " + (await this.lnsService.getDevEUI(d)) + "}",
                backgroundColor: '#eee',
                borderColor: '#777',
                borderWidth: 1,
                borderRadius: 4,
          }
            this.nodes.push(d);
            this.chartInstance.setOption({series: [{
                roam: true,
                nodes: this.nodes,
                links: this.links,
            }]});
        })
        console.log(devices);
    }

    async loadGatewaysForConnector(connector: string) {
        let gateways = await this.getGateways({lnsConnectorId: connector});
        console.log(gateways);
        gateways.forEach(async g => {
            g.category = "Gateway";
            g.symbol = "roundRect";
            g.label = {
                show: true,
                position: "right",
                formatter: "{title|{b}}{" + this.getAvailabilityStyle(g) + "|•}{head|}\n{row|EUI: " + (await this.lnsService.getGWId(g)) + "}",
                backgroundColor: '#eee',
                borderColor: '#777',
                borderWidth: 1,
                borderRadius: 4,
          }
            this.nodes.push(g);
            this.links.push({source: g.lnsConnectorId, target: g.id});
            this.chartInstance.setOption({series: [{
                roam: true,
                nodes: this.nodes,
                links: this.links,
            }]});
        });

    }
    
    async getGateways(filter?: any): Promise<IManagedObject[]> {
        let result: IManagedObject[] = [];
        let baseFilter = {pageSize: 100, withTotalPages: true};
        let query: any = {__has: "lora_ns_gateway_LoRaGateway"};
        if (filter) {
            query = {__and: {...query, ...filter}};
        }
        let response = await this.inventory.listQueryDevices(query, baseFilter);
        result.push(...response.data);
        if (response.paging.totalPages > 1) {
            while (response.paging.currentPage < response.paging.totalPages) {
                response = await response.paging.next(filter);
                result.push(...response.data);
            }
        }
        return result;
    }

    async cleanUp() {
        let devices = await this.getDevices();
        devices.forEach(d => {
            d.category = "Device";
            d.deviceParents.references.forEach(async p => {
                if (p.managedObject.id != d.lnsConnectorId) {
                    // remove this bad connection
                    await this.inventory.childDevicesRemove(d.id, p.managedObject.id);
                    //this.inventory.
                }
            })
        })
        await this.setup();
    }
}