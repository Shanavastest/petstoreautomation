package api.endpoints;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform crud operations

public class UserEndPoints {
	//post request
	public static Response createUser(User payload)
	{
	Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	.when()
		.post(Routes.post_url);
	return response;
	}
	
	//Get http method
	public static Response readUser(String userName )
	{
	Response response =given()
		               .pathParam("username",userName )
	.when()
		.get(Routes.get_url);
	return response;
	}
	
	//PUT  --> FOR update we have to use both path param and body
	public static Response updateUser(String userName ,User payload )
	{
	Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",userName )
			.body(payload)
		               
	.when()
		.put(Routes.update_url);
	return response;
	}
	
	public static Response deleteuser(String userName )
	{
	Response response =given()
		               .pathParam("username",userName )
	.when()
		.delete(Routes.delete_url);
	return response;
	}
}
