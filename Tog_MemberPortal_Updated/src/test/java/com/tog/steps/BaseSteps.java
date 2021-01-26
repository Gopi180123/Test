package com.tog.steps;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tog.framework.ReadConfig;
import com.tog.framework.Wrapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseSteps {

	public enum RequestType {
		GET, POST, DELETE, PUT;
	}

	private static ReadConfig readConfig = new ReadConfig();
	private static RequestSpecification predefinedRequestSpecification;

	private Wrapper wrapper;
	private JSONArray jsonObject;
	JSONParser jsonParser = new JSONParser();

	public BaseSteps(Wrapper wrapper) {
		this.wrapper = wrapper;
	}

	protected RequestSpecification setRequestWithHeaders() throws IOException {
		RequestSpecification rs = RestAssured.given();
		rs.spec(getPredefinedReqSpec());
		wrapper.request = rs;
		return rs;
	}
	
	protected RequestSpecification setRequestWithHeadersSearch() throws IOException {
		RequestSpecification rs =  RestAssured.given();
		rs.spec(getPredefinedReqSpec());
		wrapper.request=rs;
		return rs;
	}

	protected RequestSpecification queryParam(String parameterName, String parameterValues) {
		return wrapper.request.queryParam(parameterName, parameterValues);
	}
	protected RequestSpecification queryParam(String parameterName, Date parameterValues) {
		return wrapper.request.queryParam(parameterName, parameterValues);
	}

	protected void verifyResponseStatusValue(int expectedCode) {
		assertEquals(wrapper.response.getStatusCode(), expectedCode);
	}

	protected String toDate(String date) throws Exception {
		System.out.println(date);
	   	return date;
		
	}
	
	protected String getResponseKeyValues(String key) {
		String resp = wrapper.response.then().extract().asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

	protected String getBuildingsArea() throws Exception, IOException, ParseException {
		jsonObject = (JSONArray) jsonParser
				.parse(new FileReader("C:\\Pop\\JulyTog\\Tog_MemberPortal_Updated\\cmsid.json"));
		return jsonObject.toJSONString();
	}

	protected String getMeetingRooms() throws Exception, IOException, ParseException {
		jsonObject = (JSONArray) jsonParser
				.parse(new FileReader("C:\\Pop\\JulyTog\\Tog_MemberPortal_Updated\\ProdMR_stage2.json"));
		return jsonObject.toJSONString();
	}

	protected int getJsonSize() {
		return wrapper.response.jsonPath().getList("$").size();
	}

	protected int getJsonSize(JsonPath js) {
		return js.getList("$").size();
	}

	protected String getJsonResponse(String key) {
		return new JsonPath(wrapper.response.then().extract().asString()).get(key).toString();
	}
	protected int getJsonResponseSize(String key) {
		//return new JsonPath(wrapper.response.get
		String resp = wrapper.response.then().extract().asString();
		JsonPath js = new JsonPath(resp);
		return js.getInt(key + ".size()");
	}
	

	private static RequestSpecification getPredefinedReqSpec() throws IOException {

		if (predefinedRequestSpecification == null) {
			new File("logging.txt").delete();
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
			predefinedRequestSpecification = new RequestSpecBuilder().setBaseUri(readConfig.getBasrUrl())
					.addHeader("x-functions-key", readConfig.getFunctionKey())
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return predefinedRequestSpecification;
		}
		return predefinedRequestSpecification;
	}

	private JSONObject createJSONPayload(Object pojo) {
		return new JSONObject(pojo);
	}

	protected Response sendRequest(RequestType requestType, String url) {
		return sendRequest(requestType, url, null);
	}

	protected Response sendRequest(RequestType requestType, String url, Object pojo) {
		Response response = null;

		// Add the Json to the body of the request
		if (null != pojo) {
			String payload = createJSONPayload(pojo).toString();
			wrapper.request.body(payload);
		}

		// need to add a switch based on request type
		switch (requestType) {
		case GET:
			response = wrapper.request.get(url);
			break;
		case POST:
			response = wrapper.request.post(url);
			break;
		case DELETE:
			response = wrapper.request.delete(url);
			break;
		case PUT:
			response = wrapper.request.put(url);
			break;
		}
		wrapper.response = response;
		return response;
	}

	protected boolean isMultipleTagsPresent(String valueFromResponseBody, String multipleTags) {

		String[] valuesFromResponseBody = valueFromResponseBody.replace("[", "").replace("]", "").split(",");
		String[] valuesOfTags = multipleTags.split(",");
		for (int i = 0; i < valuesOfTags.length; i++) {
			for (int j = 0; j < valuesFromResponseBody.length; j++) {
				if (valuesFromResponseBody[j].trim().equals(valuesOfTags[i].trim())) {
					return true;
				}
			}
		}
		return false;
	}

	protected boolean isSingleTagPresent(String valueFromResponseBody, String singleTag) {

		String[] valuesFromResponseBody = valueFromResponseBody.replace("[", "").replace("]", "").split(",");
		for (int i = 0; i < valuesFromResponseBody.length; i++) {
			if (valuesFromResponseBody[i].trim().equals(singleTag)) {
				return true;
			}
		}
		return false;
	}
}
