	Feature: Search API validation's'
@search
Scenario: verify when only city and no area selected
	Given SearchAPI provided with headers 
	And Provide multiple parameters with "country" and "United Kingdom"
	And Provide multiple parameters with "city" and "london"
	And Provide date parameters with "availableFrom" and "2020-10-08T16:30:00.000Z"
	And Provide date parameters with "availableTo" and "2020-10-08T17:30:00.000Z"
	When User calls "searchAPI" with "GET" http request
	Then Verify the API call got a status code 200
	Then Verify "nearby" is null
	Then Verify "alternateAvailability" is null
	
Scenario: verify when for cities with no area
	Given SearchAPI provided with headers 
	And Provide multiple parameters with "country" and "United Kingdom"
	And Provide multiple parameters with "city" and "leeds"
	And Provide multiple parameters with "availableFrom" and "2020-10-08T14:30:00.000Z"
	And Provide multiple parameters with "availableTo" and "2020-10-08T16:30:00.000Z"
	When User calls "searchAPI" with "GET" http request
	Then Verify the API call got a status code 200
	Then Verify "nearby" is null
	Then Verify "alternateAvailability" is not null

Scenario: verify when only city and multiple area is selected
	Given SearchAPI provided with headers 
	And Provide multiple parameters with "country" and "United Kingdom"
	And Provide multiple parameters with "city" and "london"
	And Provide multiple parameters with "availableFrom" and "2020-10-08T14:30:00.000Z"
	And Provide multiple parameters with "availableTo" and "2020-10-08T16:30:00.000Z"
	And Provide multiple parameters with "areas" and "bank,moogate,holborn,soho,angel"
	When User calls "searchAPI" with "GET" http request
	Then Verify the API call got a status code 200
	Then Verify "nearby" is null

Scenario: verify when only city and multiple area is selected
	Given SearchAPI provided with headers 
	And Provide multiple parameters with "country" and "United Kingdom"
	And Provide multiple parameters with "availableFrom" and "2020-10-08T14:30:00.000Z"
	And Provide multiple parameters with "availableTo" and "2020-10-08T16:30:00.000Z"
	And Provide multiple parameters with "areas" and "bank"
	When User calls "searchAPI" with "GET" http request
	Then Verify the API call got a status code 200
	Then Verify "nearby" is null
	Then Verify "alternateAvailability" is null
  	