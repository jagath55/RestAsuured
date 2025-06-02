package apichaining;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.ITestContext;
import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;

public class createuser{
	
	
	/*
	"name": "morpheus",
    "job": "leader"s
*/
	@Test
	public void create(ITestContext context) {
		
		Faker fk= new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", fk.name().fullName());
		data.put("job", "writer");
		
		int id =given()
		   .header("x-api-key","reqres-free-v1")
		   .contentType("application/json")
		   .body(data.toString())		   
	    
		.when()
	       .post("https://reqres.in/api/users")
	       .jsonPath().getInt("id") ;
		
	       
	       
	       System.out.println("generated id " +id);
	       
	       context.setAttribute("userid", id);
		   
		   
	}

}
