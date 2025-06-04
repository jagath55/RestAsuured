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
		
		String BEARER_TOKEN="a8dfa7b0735a6351491b559d136bbceacb23fe6a97d5b7ddd9a54a72fea54df9";
		
		int id = (Integer) context.getAttribute("userid");
		
		Faker fk = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", fk.name().fullName());
		data.put("email", fk.internet().emailAddress());
		data.put("gender","male");
		data.put("status", "inactive");
		
		
		given().
		headers("Authorization","Bearer "+BEARER_TOKEN)
		   .contentType("application/json")
		   .body(data.toString())	
		   .pathParam("id", id)
		   
		.when()
		    .put("https://gorest.co.in/public/v2/users/{id}")
		    
		 .then()
		     .log().all();
		    
		
		
	}

}
