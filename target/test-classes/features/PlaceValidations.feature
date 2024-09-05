Feature: validating place API's

@AddPlace @regression
Scenario Outline: Verifi if place is being successfully added using AddPlaceAPI

Given Add place payload with "<name>" "<language>" "<address>"
When User cals "addPlaceAPI" hits "post" http request
Then API call is got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"
 
 Examples:
 |name  |language   |address|
 |Abhii	|Spanish    |A Street|
 #|Bharath|Chinese   |B Stret| 
 
 @DeletePlace @regression
 Scenario: Verif if Delete place functioality is working
 
 Given DeletePlace payload
 When User cals "deletePlaceAPI" hits "delete" http request

 