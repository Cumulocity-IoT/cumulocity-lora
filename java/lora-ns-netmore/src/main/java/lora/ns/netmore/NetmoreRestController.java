package lora.ns.netmore;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lora.common.IdNameEntry;
import lora.ns.connector.LNSConnectorService;

/**
 * REST controller for Netmore-specific operations
 */
@RestController
public class NetmoreRestController {

    @Autowired
    private LNSConnectorService lnsConnectorManager;



    /**
     * Get device groups available in the Blink LNS
     * 
     * @param lnsConnectorId Connector ID
     * @return List of device groups
     */
    @GetMapping(value = "/{lnsConnectorId}/deviceGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IdNameEntry>> getDeviceGroups(@PathVariable String lnsConnectorId) {
        var connector = lnsConnectorManager.getConnector(lnsConnectorId);
        NetmoreConnector netmoreConnector = (NetmoreConnector) connector;
        return new ResponseEntity<>(netmoreConnector.getDeviceGroups().stream()
                .map(dp -> new IdNameEntry(dp.getDeviceGroupId(), dp.getName()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }
    
    /**
     * Get gateway groups available in the Blink LNS
     * 
     * @param lnsConnectorId Connector ID
     * @return List of gateway groups
     */
    @GetMapping(value = "/{lnsConnectorId}/gatewayGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IdNameEntry>> getGatewayGroups(@PathVariable String lnsConnectorId) {
        var connector = lnsConnectorManager.getConnector(lnsConnectorId);
        NetmoreConnector netmoreConnector = (NetmoreConnector) connector;
        return new ResponseEntity<>(netmoreConnector.getGatewayGroups().stream()
                .map(gg -> new IdNameEntry(gg.getGatewayGroupId(), gg.getName()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }
    
    /**
     * Get gateway types available in the Blink LNS
     * 
     * @param lnsConnectorId Connector ID
     * @return List of gateway types
     */
    @GetMapping(value = "/{lnsConnectorId}/gatewayTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IdNameEntry>> getGatewayTypes(@PathVariable String lnsConnectorId) {
        var connector = lnsConnectorManager.getConnector(lnsConnectorId);
        NetmoreConnector netmoreConnector = (NetmoreConnector) connector;
        return new ResponseEntity<>(netmoreConnector.getGatewayTypes().stream()
                .map(gt -> new IdNameEntry(gt.getGatewayTypeId(), gt.getName()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
