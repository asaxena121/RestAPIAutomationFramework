package TestCases;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
	Response response;
	
	@BeforeMethod
    public void setUp() {
        // Initialize userPayload with test data
        userPayload = objCommonUtils.generateTestData();
        // Create the user using API and store the response
        response = userEndPoints.createUser(userPayload);
    }
	
	
@Test
public void testCreateUser()
{

	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);
	
	
	
}

@Test
public void testGetUserData()
{
    
	response = userEndPoints.GetUser(this.userPayload.getUsername());

	System.out.println("Read User Data.");
	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);

	
}

@Test
public void testUpdateUser()
{
    
	System.out.println("Get the Current User Data");
	response = userEndPoints.GetUser(this.userPayload.getUsername());
	//log response
	response.then().log().all();
	
	userPayload.setFirstName(faker.name().username());
	response = userEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);

	//log response
	response.then().log().all();


	//validation
	Assert.assertEquals(response.getStatusCode(),200);

	//Read User data to check if first name is updated 

	response = userEndPoints.GetUser(this.userPayload.getUsername());

	System.out.println("After Update User Data.");

	response.then().log().all();


}

@Test
public void testDeleteUser()
{

	response = userEndPoints.GetUser(this.userPayload.getUsername());
	
	response.then().log().all();
	
	response = userEndPoints.DeleteUser(this.userPayload.getUsername());

	System.out.println("Delete User Data.");

	//log response
	response.then().log().all();


	
	//validation
	Assert.assertEquals(response.getStatusCode(),200);

	


}

}
