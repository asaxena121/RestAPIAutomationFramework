package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import PayLoads.user;

public class CommonUtils {

	
	
	public Faker faker = new Faker();
	user userPayload = new user();;
	public static Logger logger;
	
	@BeforeClass
	public user generateTestData()
	{
		
		
		userPayload.setid(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger("RestAssuredAutomationFramework_test");
		return userPayload ;

		
	}
	
	
	
	
	
	
	
	
	
}
