package com.tog.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.tog.framework.utils.StringUtils;
import com.tog.framework.utils.UuidUtils;
import com.tog.pojo.AddBuilding;
import com.tog.pojo.AddMeetingRoom;

public class TestData {

	private static final String addMeetingRoom = "addMeetingRoom";
	private static final String addBuilding = "addBuilding";
	private static final String updateBuilding = "updateBuilding";
	private static final String updateMeetingRoom = "updateMeetingRoom";

	public Object payload(String pojo) {
		switch (pojo) {
		case addMeetingRoom:
			return addMeetingRoom();
		case addBuilding:
			return addBuilding();
		case updateBuilding:
			return addBuilding();
		case updateMeetingRoom:
			return addMeetingRoom();
		default:
			return null;
		}
	}

	public AddBuilding addBuilding() {

		AddBuilding addBuilding = new AddBuilding();
		addBuilding.setName(StringUtils.randomString());// Sceanrio
		addBuilding.setCountry("United Kingdom");
		addBuilding.setCity("London");
		addBuilding.setPmsId(UuidUtils.randomUUID());// json data
		return addBuilding;

	}

	public AddBuilding addBuildingMapping(String name, String Country, String city, UUID pmsid) {

		AddBuilding addBuilding = new AddBuilding();
		addBuilding.setName(name);// Sceanrio
		addBuilding.setCountry(Country);
		addBuilding.setCity(city);
		addBuilding.setPmsId(pmsid);// json data
		return addBuilding;

	}

	public AddBuilding updateBuildingMapping(String[] tags1, String[] alternatetags, String cmsId, String resourceId) {
		AddBuilding updateBuilding = new AddBuilding();
		updateBuilding.setCmsId(cmsId);
		updateBuilding.setResourceId(resourceId);
		List<String> tags = new ArrayList<String>();
		List<String> alterantiveBuildings = new ArrayList<String>();
		tags.addAll(Arrays.asList(tags1)); // --- new
		alterantiveBuildings.addAll(Arrays.asList(alternatetags));
		updateBuilding.setAlternateAreas(alterantiveBuildings);
		updateBuilding.setLocations(tags);
		return updateBuilding;
	}

	public AddBuilding updateBuildingMappingWithoutalternatetags(String[] tags1, String cmsId, String resourceId) {
		AddBuilding updateBuilding = new AddBuilding();
		updateBuilding.setCmsId(cmsId);
		updateBuilding.setResourceId(resourceId);
		List<String> tags = new ArrayList<String>();
		tags.addAll(Arrays.asList(tags1)); // --- new
		updateBuilding.setLocations(tags);
		return updateBuilding;
	}

	public AddMeetingRoom addMeetingRoom() {

		AddMeetingRoom addMeetingRoom = new AddMeetingRoom();
		addMeetingRoom.setType("meeting_room");
		addMeetingRoom.setName(StringUtils.randomString());
		addMeetingRoom.setPmsId(UuidUtils.randomUUID());
		addMeetingRoom.setPmsBuildingId(UuidUtils.randomUUID());
		addMeetingRoom.setCapacity(6);
		return addMeetingRoom;
	}
	public AddMeetingRoom addMeetingRoomMapping(String type,String name, UUID pmsid,UUID pmsbuildingid,int capacity) {
		
		AddMeetingRoom addMeetingRoom = new AddMeetingRoom();
		addMeetingRoom.setType(type);
		addMeetingRoom.setName(name);
		addMeetingRoom.setPmsId(pmsid);
		addMeetingRoom.setPmsBuildingId(pmsbuildingid);
		addMeetingRoom.setCapacity(capacity);
		return addMeetingRoom;
	}

	public AddMeetingRoom updateMeetingRoomMapping(String cmsid,String cmsbuildingid,String resourceid,String resourcebuildingid,int capacity) {
		AddMeetingRoom updateMeetingRoom = new AddMeetingRoom();
		updateMeetingRoom.setCmsId(cmsid);
		updateMeetingRoom.setCmsBuildingId(cmsbuildingid);
		updateMeetingRoom.setResourceBuildingId(resourcebuildingid);
		updateMeetingRoom.setResourceId(resourceid);
		updateMeetingRoom.setCapacity(capacity);
		return updateMeetingRoom;
	}

	public AddMeetingRoom updateMeetingRoomtry(String id) {
		AddMeetingRoom updateMeetingRoom = new AddMeetingRoom();
		updateMeetingRoom.setResourceBuildingId(id);
		updateMeetingRoom.setCapacity(8);
		List<String> tags = new ArrayList<String>();
		tags.add("london");
		tags.add("london-east");
		tags.add("london-west-Bank");
		updateMeetingRoom.setTags(tags);
		return updateMeetingRoom;
	}

}
