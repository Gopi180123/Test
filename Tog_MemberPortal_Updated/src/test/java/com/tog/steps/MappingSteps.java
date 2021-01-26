package com.tog.steps;

import java.io.IOException;
import java.util.UUID;

import com.tog.framework.APIResources;
import com.tog.framework.TestData;
import com.tog.framework.Wrapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

public class MappingSteps extends BaseSteps {

	public MappingSteps(Wrapper wrapper) {
		super(wrapper);
	}

	public String id;

	@When("User calls {string} with {string} request and addbuilding payload")
	public void user_calls_with_request_and_addbuilding_payload(String resource, String method) throws Exception {
		APIResources resourceAPI = APIResources.valueOf(resource);
		TestData data = new TestData();
		JsonPath js = new JsonPath(getBuildingsArea());
		int size = getJsonSize(js);
		for (int i = 0; i < size; i++) {
			String name = js.get("name" + "[" + i + "]").toString();
			String country = js.get("country" + "[" + i + "]").toString();
			String city = js.get("city" + "[" + i + "]").toString();
			String pmsid = js.get("pmsId" + "[" + i + "]").toString();
			UUID pmsId = UUID.fromString(pmsid);
			String cmsId;
			String resourceId;
			if ((js.get("cmsId" + "[" + i + "]") == null)) {
				cmsId = js.get("name" + "[" + i + "]").toString();
			} else {
				cmsId = js.get("cmsId" + "[" + i + "]").toString();
			}
			if ((js.get("resourceId" + "[" + i + "]") == null)) {
				resourceId = js.get("name" + "[" + i + "]").toString();
				resourceId = "Resourceid " + resourceId;
			} else {
				resourceId = js.get("resourceId" + "[" + i + "]").toString();
			}
			String tags = js.get("locations" + "[" + i + "]").toString();
			String[] tagslist = tags.replace("[", "").replace("]", "").split(",");
			sendRequest(RequestType.valueOf(method), resourceAPI.getResource(),
					data.addBuildingMapping(name, country, city, pmsId));
			id = getResponseKeyValues("pmsId");
			if ((js.get("alternateAreas" + "[" + i + "]")) != null) {
				String alternatetags = js.get("alternateAreas" + "[" + i + "]").toString();
				String[] alternatetagslist = alternatetags.replace("[", "").replace("]", "").split(",");
				sendRequest(RequestType.valueOf("PUT"), resourceAPI.getResource() + id,
						data.updateBuildingMapping(tagslist, alternatetagslist, cmsId, resourceId));
			} else {
				sendRequest(RequestType.valueOf("PUT"), resourceAPI.getResource() + id,
						data.updateBuildingMappingWithoutalternatetags(tagslist, cmsId, resourceId));
			}
		}

	}

	@When("User calls {string} with {string} request and updatemeetingroom payload")
	public void user_calls_with_request_and_updatemeetingroom_with_payload(String resource, String method)
			throws Exception {
		APIResources resourceAPI = APIResources.valueOf(resource);
		TestData data = new TestData();
		JsonPath js = new JsonPath(getMeetingRooms());
		int size = getJsonSize(js);
		for (int i = 0; i < size; i++) {
			String name = js.get("name" + "[" + i + "]").toString();
			String type = js.get("type" + "[" + i + "]").toString();
			String pmsid = js.get("pmsId" + "[" + i + "]").toString();
			String pmsBuilding = js.get("pmsBuildingId" + "[" + i + "]").toString();
			UUID pmsId = UUID.fromString(pmsid);
			UUID pmsBuildingId = UUID.fromString(pmsBuilding);
			String cmsId = js.get("cmsId" + "[" + i + "]").toString();
			String cmsBuildingId = js.get("cmsBuildingId" + "[" + i + "]").toString();
			String resourceId = js.get("resourceId" + "[" + i + "]").toString();
			String resourceBuildingId = js.get("resourceBuildingId" + "[" + i + "]").toString();
			int capacity;
			if ((js.get("capacity" + "[" + i + "]") == null)) {
				capacity = 1;
			} else {
				String capacitystring = js.get("capacity" + "[" + i + "]").toString();
				capacity = Integer.parseInt(capacitystring);
			}
			sendRequest(RequestType.valueOf(method), resourceAPI.getResource(),
					data.addMeetingRoomMapping(type, name, pmsId, pmsBuildingId, capacity));
			id = getResponseKeyValues("pmsId");
			sendRequest(RequestType.valueOf("PUT"), resourceAPI.getResource() + id,
					data.updateMeetingRoomMapping(cmsId, cmsBuildingId, resourceId, resourceBuildingId, capacity));
		}
	}

	@Then("Verify the {string} in the response with {string} with {string}")
	public void verify_the_in_the_response_with(String key, String resource, String method)
			throws IOException, ClassNotFoundException {
		id = getResponseKeyValues(key);
		APIResources resourceAPI = APIResources.valueOf(resource);
		sendRequest(RequestType.valueOf(method), resourceAPI.getResource() + id);
	}

}
