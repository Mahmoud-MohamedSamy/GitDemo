package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.*;

public class TestDataBuild {
	AddPlace addPlace = new AddPlace();

	public AddPlace addPlacePayload(String name, String language, String address) {
		addPlace.setAccuracy(50);
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setName(name);
		addPlace.setPhoneNumber("+20 1234567890");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		
		List<String> typesList = new ArrayList<String>();
		typesList.add("home");
		typesList.add("house");
		addPlace.setTypes(typesList);
		
		Location location = new Location();
		location.setLat(-40.123456);
		location.setLng(40.987654);
		addPlace.setLocation(location);
		
		return addPlace;
	}
	
	public String deletePlacePayload(String place_id) {
		
		return "{\r\n	\"place_id\":\""+place_id+"\"\r\n}";
	}
}
