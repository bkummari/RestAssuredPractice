import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	
	//@Test
	void getMethod1()
	{
		String url="https://reqres.in/api/users?page=2";
		Response resp=RestAssured.get(url);
		System.out.println(resp.getBody());
		int scod=resp.getStatusCode();
		System.out.println(scod);
		System.out.println(resp.getHeaders());
		System.out.println(resp.asString());
	}
	 @Test
	void getMethod2()
	{
		given()
				.get("https://reqres.in/api/users?page=2")
		.then()
				.statusCode(200)
				.body("data.id[1]", equalTo(8))
				.body("data.first_name", hasItem("Lindsay"))
				.log().all();
		System.out.println(given().get("https://reqres.in/api/unknown").then().toString());
		System.out.println(given().get("https://reqres.in/api/users/23").then().statusCode(404));
	}
	 @Test
	void getMethod3()
	{
		Response response=RestAssured.get("https://reqres.in/api/unknown");
		if(response.getStatusCode()==200)
		{
			System.out.println("The Responce is correct");
		}
		System.out.println(response.getStatusLine());
		String s[]=response.getStatusLine().split(" ");
		System.out.println(s[0]);
	}
	@Test
	void getMethod4()
	{
		Response resp= RestAssured.get("https://reqres.in/api/unknown/23");
		System.out.println("The Actual status code is : "+ resp.statusCode());
	    Assert.assertEquals(resp.getStatusCode(), 404);
	}
	

}
