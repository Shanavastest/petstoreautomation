package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints1;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		//TO CREATE data randomnly to pass in pojo class
		faker =new Faker();
		//to pass in pojo clas
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().name());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
			
	}
	@Test(priority=1)
	public void testPostUser() {
		 Response response=UserEndPoints1.createUser(userPayload);
		 response.then().log().all();
		 
		 //to valiadte Response code 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 //
	}
	@Test(priority=2)
	public void testGetUserByName() {
	 Response response=UserEndPoints1.readUser(this.userPayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	}
//Put --> to update the data first we want to change the data
	//update the data using payload
	
	@Test(priority=3)
	public void testupdateUser() {
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		 Response response=UserEndPoints1.updateUser(this.userPayload.getUsername(),userPayload);
		 response.then().log().all();
		 
		 //Chai Assertion
		 //response.then().log().body().statusCode(200);
		 
		 //to validate Response code 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 //
	}
	@Test(priority=4)
	public void testdeleteUser() {
		
		 Response response=UserEndPoints1.deleteuser(this.userPayload.getUsername());
		 response.then().log().all();
		 
		 //Chai Assertion
		 //response.then().log().body().statusCode(200);
		 
		 //to validate Response code 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 //
	}
	
}
