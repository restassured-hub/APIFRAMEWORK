package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		//write a code that gives you place id
		//execute this code only when placeid is null
		
		
		StepDefinition s=new StepDefinition();
		
		if(StepDefinition.placeid==null) {
		s.add_place_payload_with("venka", "French", "Asia");
		s.user_cals_hits_http_request("addPlaceAPI", "post");
		s.verify_place_id_created_maps_to_using("venka", "getPlaceAPI");
		}
		
	}

}
