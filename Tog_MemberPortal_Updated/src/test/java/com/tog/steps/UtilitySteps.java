package com.tog.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.tog.framework.APIResources;
import com.tog.framework.Wrapper;
import com.tog.framework.utils.UuidUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UtilitySteps extends BaseSteps {

	public UtilitySteps(Wrapper wrapper) {
		super(wrapper);
	}

	@Given("ResourceAPI provided with headers")
	public void resourceAPI_provided_with_headers() throws IOException, InterruptedException {
		setRequestWithHeaders();

	}
	
	@Given("SearchAPI provided with headers")
	public void searchAPI_provided_with_headers() throws IOException {
		setRequestWithHeadersSearch();
	}
	

	@Given("ResourceAPI provided with headers and queryparameters with {string} and {string}")
	public void resourceapi_provided_with_headers_and_queryparameters_with_and(String key, String value)
			throws IOException {
		setRequestWithHeaders();
		queryParam(key, value);
	}

	@Given("Provide multiple parameters with {string} and {string}")
	public void provide_multiple_parameters_with_and(String key, String value) {
		queryParam(key, value);
	}
	
	@Given("Provide date parameters with {string} and {string}")
	public void provide_date_parameters_with_and(String key, String value) throws Exception {
		queryParam(key, toDate(value));
	}
	

	@Then("Verify provided {string} is present in responsebody with {string}")
	public void verify_provided_is_present_in_responsebody(String key, String multipleTags)
			throws Exception, IOException {
		int size = getJsonSize();
		System.out.println(size);
		for (int i = 0; i < size; i++) {// Loop should br created here
			String valueFromResponseBody = getJsonResponse(key + "[" + i + "]");
			assertTrue(isMultipleTagsPresent(valueFromResponseBody, multipleTags));
		}
		String[] tags = multipleTags.split(",");
		for (int j = 0; j < tags.length; j++) {
			boolean matched = false;
			for (int i = 0; i < size; i++) {// Loop should br created here
				String valueFromResponseBody = getJsonResponse(key + "[" + i + "]");
				if (isSingleTagPresent(valueFromResponseBody, multipleTags)) {
					matched = true;
					break;
				}
			}
			assertTrue(matched);
		}

	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) throws Exception {
		APIResources resourceAPI = APIResources.valueOf(resource);
		sendRequest(RequestType.valueOf(method), resourceAPI.getResource());
	}
	@Then("Verify {string} is null")
	public void verify_is_null(String key) {
		assertEquals(getJsonResponseSize(key),0);

	}
	@Then("Verify {string} is not null")
	public void verify_is_not_null(String key) {
		assertNotSame(getJsonResponseSize(key), 0);
		
	}
	
	@Then("Verify the API call got a status code {int}")
	public void verify_the_API_call_got_a_status_code(int statusCode) throws IOException, ClassNotFoundException {
		verifyResponseStatusValue(statusCode);
	}

	@Then("Verify {string} in the response is {string}")
	public void verify_in_the_response_is(String key, String uuid) throws ClassNotFoundException, IOException {
		String value = getJsonResponse(key);
		assertTrue(UuidUtils.isValid(value));

	}

}
