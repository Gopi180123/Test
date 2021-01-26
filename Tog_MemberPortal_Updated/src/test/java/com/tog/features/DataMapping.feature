  Feature: Mapping Building  and Meeting data 

@MeetingMapping
Scenario: Verify meeting is updated succesfully by updatemeetingroom API 
	Given ResourceAPI provided with headers 
	When User calls "resourcesAPI" with "POST" request and updatemeetingroom payload
	Then Verify the API call got a status code 200
	
@BuildingMapping
Scenario: Verify building data is updated succesfully from buildings json file
	Given ResourceAPI provided with headers	
	When User calls "resourcesAPI" with "POST" request and addbuilding payload
	Then Verify the API call got a status code 200
	
	