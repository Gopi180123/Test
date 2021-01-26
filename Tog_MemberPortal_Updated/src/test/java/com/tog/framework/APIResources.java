package com.tog.framework;

public enum APIResources {
	
	buildingsAPI("/buildings/"),
	resourcesAPI("/spaces/"),
	searchAPI("/search/spaces/");
	

private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
