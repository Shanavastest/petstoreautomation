package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtest {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testpostuser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userpayload = new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstname(fname);
		userpayload.setLastname(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userpayload);
		 response.then().log().all();
		 
		 //to valiadte Response code 
		 Assert.assertEquals(response.getStatusCode(), 200);
}
	@Test(priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String UserName) {
		
		Response response =UserEndPoints.deleteuser(UserName);
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testGetUserByName(String UserName) {
		Response response =UserEndPoints.readUser(UserName);
		Assert.assertEquals(response.getStatusCode(),200);
	}

	
	}
