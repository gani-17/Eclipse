package TestNgproject;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class testngxml {
	
@Test(priority = 2)
	
	public void getuserxml() {
		
		Response response = given().when().get("https://reqres.in/api/users?page=2");
		int actualresult =response.statusCode();
		Assert.assertEquals(actualresult, 200);
		
	}
	@Test(priority =1)
	
	public void singleuserxml() {
		Response response = given().when().get("https://reqres.in/api/users/2");
		ResponseBody rb =response.getBody();
		String str =rb.asString();
		Assert.assertTrue(str.contains("janet"));
	}


}
