package EndPoints;

import PayLoads.user;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class userEndPoints {

	
	public static Response createUser(user payload) {
				return RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
				
				
	}

	
	public static Response GetUser(String userName)
	{
		return RestAssured.given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
	
	}
	
	
	public static Response UpdateUser(String userName, user payload)
	{
		return RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
		.put(Routes.put_url);
		
		
	}
	
	
	public static Response DeleteUser(String userName)
	{
		return RestAssured.given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
			
		
		.when()
		.delete(Routes.del_url);
		
		
	}
	
	
	




	
	
	

}
