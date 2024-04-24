package TestNgproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;


public class testapi {
	
	@Test(priority = 2,groups = {"sanity","windows.smoke","regression"})
	
	public void getuser() {
		
		Response response = given().when().get("https://reqres.in/api/users?page=2");
		int actualresult =response.statusCode();
		Assert.assertEquals(actualresult, 200);
		
	}
	@Test(priority =1,dependsOnGroups= {"sanity"})
	
	public void singleuser() {
		Response response = given().when().get("https://reqres.in/api/users/2");
		ResponseBody rb =response.getBody();
		String str =rb.asString();
		Assert.assertTrue(str.contains("janet"));
	}

}
