package com.tog.pojo;

import java.util.List;
import java.util.UUID;

public class AddBuilding {
	private String name;
	private String city;
	private String country;
	private UUID carieId;
	private UUID pmsId;
	private String cmsId;
	private String resourceId;
	private List<String> locations;
	private List<String> alternateAreas;

	public String getCmsId() {
		return cmsId;
	}

	public void setCmsId(String cmsId) {
		this.cmsId = cmsId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public UUID getPmsId() {
		return pmsId;
	}

	public void setPmsId(UUID pmsId) {
		this.pmsId = pmsId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getCarieId() {
		return carieId;
	}

	public void setCarieId(UUID uuid) {
		this.carieId = uuid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getAlternateAreas() {
		return alternateAreas;
	}

	public void setAlternateAreas(List<String> alternateAreas) {
		this.alternateAreas = alternateAreas;
	}

}
