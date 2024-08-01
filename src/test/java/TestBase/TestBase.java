package TestBase;


import org.testng.annotations.BeforeClass;

import Utilities.CommonUtils;
import io.restassured.response.Response;

public class TestBase {

	
	public CommonUtils objCommonUtils;
	
	
	@BeforeClass
	public void beforeclass() {
		
		objCommonUtils = new CommonUtils();
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
