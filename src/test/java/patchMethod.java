import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class patchMethod {
	 @Test
		public void putMethod()
		{
			JSONObject js= new JSONObject();
			
			js.put("name", "msd");
			js.put("job", "captain");
			System.out.println(js.toJSONString());
			
			given().
			    headers("Content-type", "application.Json")
			    .accept(ContentType.JSON)
			    .contentType(ContentType.JSON).
			when()  
			    .patch("https://reqres.in/api/users/2").
			then()
			    .statusCode(200)
			    .log().all();
			    
	       }
}
