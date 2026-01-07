package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
	
	static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log)).addQueryParam("key", "qaclick123")
			.setContentType(ContentType.JSON).build();
			return req;
		}
		else{
			return req;
		}
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\a\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    return js.get(key).toString();
	}
}
