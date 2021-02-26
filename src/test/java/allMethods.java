
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class allMethods {
	
	@Test(priority = 1)
	public void get_Test()
	{
		baseURI="http://localhost:3000/";
		
		given().
		     params("lastName","kum").
		     get("/users/3").
		then().
		     statusCode(200).
		     log().all();
		
	}
	
	@Test(priority = 2)
	public void post_Test()
	{
		JSONObject req= new JSONObject();
		req.put("firstName","kishore5");
		req.put("lastName","bhumadi5");
		req.put("Sub","QAFunctional");
		req.put("Sub id",1);
		
		baseURI="http://localhost:3000/";
		
		given().
		      contentType(ContentType.JSON).
		      accept(ContentType.JSON).
		      headers("Content-Type", "application/json").
		      body(req.toJSONString()).
		when().
		     post("/users").
		then().
		     statusCode(201).
		     log().all();
		
	}
	
	@Test(priority = 3)
	public void patch_Test()
	{
		JSONObject req= new JSONObject();
		req.put("lastName","yashoda");
		
		baseURI="http://localhost:3000/";
		
		given().
		      contentType(ContentType.JSON).
		      accept(ContentType.JSON).
		      headers("Content-Type", "application/json").
		      body(req.toJSONString()).
		when().
		     patch("/users/3").
		then().
		     statusCode(200).
		     log().all();
		
	}
	
	@Test(priority = 4)
	public void put_Test()
	{
		JSONObject req= new JSONObject();
		req.put("firstName","Ashwini5");
		req.put("lastName","Appam5");
		req.put("Sub","JavaScript");
		req.put("Sub id",5);
		
		baseURI="http://localhost:3000/";
		
		given().
		      contentType(ContentType.JSON).
		      accept(ContentType.JSON).
		      headers("Content-Type", "application/json").
		      body(req.toJSONString()).
		when().
		     put("/users/2").
		then().
		     statusCode(200).
		     log().all();
		
	}
	@Test(priority = 5)
	public void delete_Test()
	{
		baseURI="http://localhost:3000/";
		
		when().
		     delete("/users/4").
		then().
		     statusCode(404);
		
	}

}
