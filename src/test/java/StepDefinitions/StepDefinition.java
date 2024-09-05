package StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;
import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition extends Utils{
	RequestSpecification reqq1;
	ResponseSpecification resspe;
	Response res1;
	
	TestDataBuild data=new TestDataBuild();
	static String placeid;
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		
//		RestAssured.baseURI="https://rahulshettyacademy.com";
//		
//		String response=given().log().all().queryParam("key","qaclick123").body(a).
//				when().post("/maps/api/place/add/json").
//				then().log().all().statusCode(200).extract().response().asString();
		
		
		

//		String res11=given().spec(reqq).body(a).when().post("/maps/api/place/add/json").then().extract().response().asString();
		
		 reqq1=given().spec(requestSpecification()).body(data.testDataBuild(name,language,address));
		
//		String res1=reqq1.when().post("/maps/api/place/add/json").then().extract().response().asString();
		
		
		
		
		 resspe=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
	  
	}
	
	@When("User cals {string} hits {string} http request")
	public void user_cals_hits_http_request(String resorc, String httpmethod) {

	    // Write code here that turns the phrase above into concrete actions
		
		APIResources resAPI= APIResources.valueOf(resorc);
		resAPI.getResource();
		System.out.println(resAPI.getResource());
		
//		 res1=reqq1.when().post(resAPI.getResource()).then().spec(resspe).extract().response();
		 
		 if(httpmethod.equalsIgnoreCase("post")) 
			 res1=reqq1.when().post(resAPI.getResource()).then().spec(resspe).extract().response();
			 else if((httpmethod.equalsIgnoreCase("get")))
			 res1=reqq1.when().get(resAPI.getResource()).then().spec(resspe).extract().response();
			 else if((httpmethod.equalsIgnoreCase("delete")))
				 res1=reqq1.when().post(resAPI.getResource()).then().spec(resspe).extract().response();
//		System.out.println(res1);
	}
	@Then("API call is got success with status code {int}")
	public void api_call_is_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
//		System.out.println(res1);
		System.out.println(res1.getStatusCode());
	   assertEquals(res1.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		String res=res1.asString();
		JsonPath js=new JsonPath(res);
		String str=js.get(string);
		System.out.println(str);
		assertEquals(str, string2);
		String str1=js.get("place_id");
		System.out.println(str1);
		
	
		
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expName, String string2) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(res1);
		placeid=getJsonPath(res1,"place_id");
		 reqq1=given().spec(requestSpecification()).queryParam("place_id", placeid);
		 user_cals_hits_http_request(string2,"GET");
		 String name=getJsonPath(res1,"name");
		 System.out.println(name);
		 assertEquals(expName,name);
	}

	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		reqq1= given().spec(requestSpecification()).body(data.deletePlacePayload(placeid));
		resspe=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
	}


	

}
