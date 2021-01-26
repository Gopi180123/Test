package com.tog.pojo;

import java.util.List;
import java.util.UUID;

public class AddMeetingRoom {
	private String type;
	private String name;
	private UUID pmsId;
	private UUID pmsBuildingId;
	private String country;
	private int capacity;
	private String cmsId;
	private String cmsBuildingId;
	private String resourceId;
	private String resourceBuildingId;
	private List<String> tags;

	public String getCmsBuildingId() {
		return cmsBuildingId;
	}

	public void setCmsBuildingId(String cmsBuildingId) {
		this.cmsBuildingId = cmsBuildingId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceBuildingId() {
		return resourceBuildingId;
	}

	public void setResourceBuildingId(String resourceBuildingId) {
		this.resourceBuildingId = resourceBuildingId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public UUID getPmsId() {
		return pmsId;
	}

	public void setPmsId(UUID uuid) {
		this.pmsId = uuid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCmsId() {
		return cmsId;
	}

	public void setCmsId(String uuid) {
		this.cmsId = uuid;
	}

	public UUID getPmsBuildingId() {
		return pmsBuildingId;
	}

	public void setPmsBuildingId(UUID buildingId) {
		this.pmsBuildingId = buildingId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
