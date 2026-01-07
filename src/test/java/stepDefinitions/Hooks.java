package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		//Write a code that will give you place id
		// execute this code only when place id is null
		
		StepDefinition sd = new StepDefinition();
		if(StepDefinition.place_id==null) {
			sd.add_place_payload_with("Mahmoud", "Arabic", "Africa");
			sd.user_calls_with_http_request("addPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Mahmoud", "getPlaceAPI");
		}
	}
	
}
