package lora;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lora.common.IdNameEntry;
import lora.ns.connector.LNSConnector;
import lora.ns.connector.LNSConnectorManager;
import lora.ns.objenious.ObjeniousConnector;
import lora.ns.objenious.rest.Group;

@RestController
public class ObjeniousRestController {
    @Autowired
	private LNSConnectorManager lnsConnectorManager;

    @GetMapping(value = "/{lnsConnectorId}/deviceProfiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdNameEntry> getDeviceProfiles(@PathVariable String lnsConnectorId) {
        List<IdNameEntry> result = new ArrayList<>();
		Optional<LNSConnector> connector = lnsConnectorManager.getConnector(lnsConnectorId);
		if (connector.isPresent()) {
            ObjeniousConnector objeniousConnector = (ObjeniousConnector)connector.get();
            result = objeniousConnector.getDeviceProfiles().stream().map(dp -> new IdNameEntry(dp.getId().toString(), dp.getName())).collect(Collectors.toList());
		}
        return result;
    }

    /***
     * Should be used when updating the connector to get the list of available device groups.
     * @param lnsConnectorId
     * @param properties
     * @return
     */
	@PostMapping(value = "/{lnsConnectorId}/groups", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Group> getGroups(@PathVariable String lnsConnectorId, @RequestBody Properties properties) {
		Optional<LNSConnector> connector = lnsConnectorManager.getConnector(lnsConnectorId);
		if (connector.isPresent()) {
            properties = connector.get().mergeProperties(properties);
		}
		return new ObjeniousConnector(properties).getGroups();
	}

    /***
     * Retrieves the list of avaible device groups in Objenious tenant when creating a new Objenious connector.
     * @param properties
     * @return
     */
	@PostMapping(value = "/groups", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Group> getGroups(@RequestBody Properties properties) {
		return new ObjeniousConnector(properties).getGroups();
	}
}
