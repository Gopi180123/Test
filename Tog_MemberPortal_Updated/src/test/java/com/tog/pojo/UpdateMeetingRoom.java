package com.tog.pojo;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class UpdateMeetingRoom {
	@JsonInclude(Include.NON_NULL)
	private UUID cmsId;
	private UUID cmsBuildingId;
	private UUID resourceId;
	private String resourceBuildingId;
	private List<String> tags;
	
	
	public UUID getCmsId() {
		return cmsId;
	}
	public void setCmsId(UUID cmsId) {
		this.cmsId = cmsId;
	}
	public UUID getCmsBuildingId() {
		return cmsBuildingId;
	}
	public void setCmsBuildingId(UUID cmsBuildingId) {
		this.cmsBuildingId = cmsBuildingId;
	}
	public UUID getResourceId() {
		return resourceId;
	}
	public void setResourceId(UUID resourceId) {
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
}
