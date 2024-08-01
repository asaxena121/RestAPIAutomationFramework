package TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import EndPoints.userEndPoints;
import PayLoads.user;
import TestBase.TestBase;
import Utilities.CommonUtils;
import io.restassured.response.Response;

public class UserTest extends TestBase {
	
	
	public CommonUtils objCommonUtils = new CommonUtils();
	user userPayload;
	Faker faker = new Faker();
	
	
	
@Test
public void testCreateUser()
{
	userPayload=objCommonUtils.generateTestData();
	
	Response response = userEndPoints.createUser(userPayload);

	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);
	
	
	
}

@Test
public void testGetUserData()
{
	Response response = userEndPoints.GetUser(this.userPayload.getUsername());

	System.out.println("Read User Data.");
	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);

	
}

@Test
public void testUpdateUser()
{
	userPayload=objCommonUtils.generateTestData();
    // Create the user using API
	Response createResponse=userEndPoints.createUser(userPayload);
	
	createResponse.then().log().all();
    Assert.assertEquals(200, createResponse.getStatusCode());
    
	userPayload.setFirstName(faker.name().username());
	Response response = userEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);


	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);

	//Read User data to check if first name is updated 

	Response responsePostUpdate = userEndPoints.GetUser(this.userPayload.getUsername());

	System.out.println("After Update User Data.");

	responsePostUpdate.then().log().all();


}

@Test
public void testDeleteUser()
{

	Response response = userEndPoints.DeleteUser(this.userPayload.getUsername());

	System.out.println("Delete User Data.");

	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);

	


}

}
