package com.tog.steps;

import com.tog.framework.APIResources;
import com.tog.framework.TestData;
import com.tog.framework.Wrapper;

import io.cucumber.java.en.When;;

public class ResourcesSteps extends BaseSteps {

	public String id;

	public ResourcesSteps(Wrapper wrapper) {
		super(wrapper);
	}

	@When("User calls {string} with {string} request and {string} payload")
	public void user_calls_with_request_and_payload(String resource, String method, String payload) throws Exception {
		APIResources resourceAPI = APIResources.valueOf(resource);
		TestData data = new TestData();
		sendRequest(RequestType.valueOf(method), resourceAPI.getResource(), data.payload(payload));
	}

	@When("User calls {string} with {string} request and {string} with {string}")
	public void user_calls_with_request_and_with(String resource, String method, String payload, String key) {
		TestData data = new TestData();
		id = getResponseKeyValues(key);
		APIResources resourceAPI = APIResources.valueOf(resource);
		sendRequest(RequestType.valueOf(method), resourceAPI.getResource() + id, data.payload(payload));
		
	}

	

}
