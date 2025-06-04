package apichaining;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.ITestContext;
import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;

public class createuser{
	
	
	/*
	"name": "Rep. Dayaamay Iyengar",
        "email": "iyengar_rep_dayaamay@sporer.test",
        "gender": "female",
        "status": "active"
*/
	@Test
	public void create(ITestContext context) {
		
		String BEARER_TOKEN="a8dfa7b0735a6351491b559d136bbceacb23fe6a97d5b7ddd9a54a72fea54df9";
		
		Faker fk= new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", fk.name().fullName());
		data.put("email", fk.internet().emailAddress());
		data.put("gender","female");
		data.put("status", "active");
		
		int id =given()
		   .headers("Authorization","Bearer "+BEARER_TOKEN)
		   .contentType("application/json")
		   .body(data.toString())		   
	    
		.when()
	       .post("https://gorest.co.in/public/v2/users")
	       .jsonPath().getInt("id") ;
	      
		
	       
	       
	       System.out.println("generated id " +id);
	       
	       context.setAttribute("userid", id);
		   
		   
	}

}
