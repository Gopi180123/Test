  Feature: Validating Building API's' 

@Addbuilding
Scenario: Verify Building is added successfully by AddBuilding API 
	Given ResourceAPI provided with headers 
	When User calls "buildingsAPI" with "POST" request and "addBuilding" payload
	Then Verify the API call got a status code 200 
	And Verify the "pmsId" in the response with "buildingsAPI" with "GET"
	Then Verify the API call got a status code 200 

@Addbuildingfail
Scenario: Verify Building by adding same Payload by AddBuilding API 
	Given ResourceAPI provided with headers 
	When User calls "buildingsAPI" with "POST" request and "addBuilding" payload	
	Then Verify the API call got a status code 200 
	When User calls "buildingsAPI" with "POST" request and "same" payload
	Then Verify the API call got a status code 409  

@Updatebuilding
Scenario: Verify Building is updated succesfully by updateBuilding API 
	Given ResourceAPI provided with headers 
	When User calls "buildingsAPI" with "POST" request and "addBuilding" payload
	Then Verify the API call got a status code 200
	When User calls "buildingsAPI" with "PUT" request and "updateBuilding" with "pmsId"
	And Verify the "pmsId" in the response with "buildingsAPI" with "GET" 
	Then Verify the API call got a status code 200
	And Verify "cmsId" in the response is "UUID"
	And Verify "resourceId" in the response is "UUID"
	
@Getbuilding
Scenario: Verify carieid of each building by GetBuilidngs API 
	Given ResourceAPI provided with headers 
	When User calls "buildingsAPI" with "GET" http request 
	Then Verify the API call got a status code 200 
	
@Deletebuilding
Scenario: Verify Delete of  building by GetBuilidngs API 
	Given ResourceAPI provided with headers
	When User calls "buildingsAPI" with "POST" request and "addBuilding" payload
	Then Verify the API call got a status code 200
	And Verify the "pmsId" in the response with "buildingsAPI" with "DELETE" 
	Then Verify the API call got a status code 405

@building
Scenario Outline: Verify tags of buildings by Builidngs API 
    Given ResourceAPI provided with headers and queryparameters with "tags" and "<value>"
	When User calls "buildingsAPI" with "GET" http request 
	Then Verify the API call got a status code 200 
	And Verify provided "tags" is present in responsebody with "<value>"
Examples:
	|value|
	|london-central,london-central-covent-garden|	  
	
  
 
 
 
 
 
 
 
 
 
 
 
 
 