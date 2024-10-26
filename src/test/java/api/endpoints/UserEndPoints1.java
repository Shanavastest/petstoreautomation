package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints1 {
	
	//method created for getting url from property file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("route"); //load properties files
		return routes;
	}
	
	//post request
	

		public static Response createUser(User payload)
		{
			
			String post_url = getURL().getString("post_url");
		Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		return response;
		}
		
		//Get http method
		public static Response readUser(String userName )
		{
			String get_url = getURL().getString("get_url");
		Response response =given()
			               .pathParam("username",userName )
		.when()
			.get(get_url);
		return response;
		}
		
		//PUT  --> FOR update we have to use both path param and body
		public static Response updateUser(String userName ,User payload )
		{
			String update_url = getURL().getString("update_url");
		Response response =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName )
				.body(payload)
			               
		.when()
			.put(update_url);
		return response;
		}
		
		public static Response deleteuser(String userName )
		{
			String delete_url = getURL().getString("delete_url");
		Response response =given()
			               .pathParam("username",userName )
		.when()
			.delete(delete_url);
		return response;
		}
	}



