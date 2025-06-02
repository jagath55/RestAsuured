package apichaining;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;

public class update {
	int id;
	@Test
	public void modify(ITestContext context) {
		
		int id = (Integer) context.getAttribute("userid");
		
		Faker fk = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name",fk.name().fullName());
		data.put("job", "cricketer");
		
		
		
		given()
		   .header("x-api-key","reqres-free-v1")
		   .param("path",id)
		   .body(data.toString())
		   
		.when()
		    .put("https://reqres.in/api/users/{path}")
		    
		 .then()
		     .log().all();
		    
		
		
	}

}
