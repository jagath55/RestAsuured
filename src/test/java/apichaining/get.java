package apichaining;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class get {
	
	
	//https://reqres.in/api/users/2 
		
		
	@Test
	public void getuser(ITestContext context) {
		
		int id= (Integer) context.getAttribute("userid");
		given()
		   .header("x-api-key","reqres-free-v1")
		   .pathParam("path",id)
		   
		.when()
		    .get("https://reqres.in/api/users/{path}")
		    
		    
		 .then()
		   // .statusCode(200)
		    .log().status();
		
	}

}
