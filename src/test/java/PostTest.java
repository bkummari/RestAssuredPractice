import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostTest {
	
	@Test
	public void postMethod1()
	{
		/*Map<String, Object> map= new HashMap<String, Object>();
		map.put("name", "bhik");
		map.put("job", "Automation QA");
		System.out.println(map);*/
		
		JSONObject js= new JSONObject();
		js.put("name", "pant");
		js.put("job", "wicket Keeper");
		System.out.println(js.toJSONString());
		
		given().
		  header("Content- type","application-Json").
		  accept(ContentType.JSON).
		  contentType(ContentType.JSON).
		  body(js.toJSONString()).
		  
		when().
		      post("https://reqres.in/api/users").
		then().
		     statusCode(201);
		      
	
	}
	

}
