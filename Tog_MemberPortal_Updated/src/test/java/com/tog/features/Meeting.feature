 Feature: Validating Meetingroom API's' 
@Addmeetingrooms
Scenario: Verify Meetingroom is added succesfully by AddMeetingrooms API 
	Given ResourceAPI provided with headers 
	When User calls "resourcesAPI" with "POST" request and "addMeetingRoom" payload
	Then Verify the API call got a status code 200 
	And Verify the "pmsId" in the response with "resourcesAPI" with "GET" 

@Addmeetingroomsfail	
Scenario: Verify Meetingroom is added succesfully by AddMeetingrooms API 
	Given ResourceAPI provided with headers 
	When User calls "resourcesAPI" with "POST" request and "addMeetingRoom" payload
	Then Verify the API call got a status code 200 
	When User calls "resourcesAPI" with "POST" request and "same" payload
	Then Verify the API call got a status code 409

@UpdateMeetingroom
Scenario: Verify resource is updated succesfully by updateSpace API 
	Given ResourceAPI provided with headers 
	When User calls "resourcesAPI" with "POST" request and "addMeetingRoom" payload
	Then Verify the API call got a status code 200
	When User calls "resourcesAPI" with "PUT" request and "updateMeetingRoom" with "pmsId"
	And Verify the "pmsId" in the response with "resourcesAPI" with "GET" 
	Then Verify the API call got a status code 200
	And Verify "cmsId" in the response is "UUID"
	And Verify "resourceBuildingId" in the response is "UUID"
@Deletemeetingroom
Scenario: Verify Delete of  building by Spaces API 
	Given ResourceAPI provided with headers
	When User calls "resourcesAPI" with "POST" request and "addMeetingRoom" payload
	Then Verify the API call got a status code 200
	And Verify the "pmsId" in the response with "buildingsAPI" with "DELETE" 
	Then Verify the API call got a status code 405

@Getmeetingrooms
Scenario: Verify Get of spacesS API 
	Given ResourceAPI provided with headers 
	When User calls "resourcesAPI" with "GET" request and "No" payload
	Then Verify the API call got a status code 200 

@Searchmeeetingroomtags
Scenario Outline: Verify search of Meetingrooms by Meetingrooms API 
	Given ResourceAPI provided with headers and queryparameters with "tags" and "<value>"
	When User calls "resourcesAPI" with "GET" http request 
	Then Verify the API call got a status code 200 
	And Verify provided "tags" is present in responsebody with "<value>"
Examples:
	|value|
	|london-central| 

@Searchmeeetingroomtype
Scenario Outline: Verify search of Meetingrooms by Meetingrooms API 
	Given ResourceAPI provided with headers and queryparameters with "type" and "<value>"
	When User calls "resourcesAPI" with "GET" http request 
	Then Verify the API call got a status code 200 
	And Verify provided "type" is present in responsebody with "<value>"
Examples:
	|value|		  
	|meeting_room|

@Searchmeeetingroomcapacity
Scenario Outline: Verify search of Meetingrooms by Meetingrooms API 
	Given ResourceAPI provided with headers and queryparameters with "capacity" and "<value>"
	When User calls "resourcesAPI" with "GET" http request 
	Then Verify the API call got a status code 200 
	And Verify provided "capacity" is present in responsebody with "<value>"
Examples:
	|value|		  
	|5|

@Searchmeeetingroomtypeandcapacity
Scenario Outline: Verify search of Meetingrooms by Meetingrooms API 
	Given ResourceAPI provided with headers and queryparameters with "type" and "<value>"
	And Provide multiple parameters with "tags" and "<value2>"
	When User calls "resourcesAPI" with "GET" http request 
	Then Verify the API call got a status code 200 
	And Verify provided "type" is present in responsebody with "<value>"
	And Verify provided "tags" is present in responsebody with "<value2>"
Examples:
	|value|		  |value2|
	|meeting_room||london|
