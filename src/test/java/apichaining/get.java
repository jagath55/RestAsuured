package apichaining;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class get {
	
	
	//https://reqres.in/api/users/2 
		
		
	@Test
	public void getuser(ITestContext context) {
		String BEARER_TOKEN="a8dfa7b0735a6351491b559d136bbceacb23fe6a97d5b7ddd9a54a72fea54df9";
		
		int id= (Integer) context.getAttribute("userid");
		
		given()
		.headers("Authorization","Bearer "+BEARER_TOKEN)
		   
	    .pathParam("id",id)
	   //.body(data.toString())		   
    
	.when()
       .get("https://gorest.co.in/public/v2/users/{id}")  // here get request is woring but all the procudeure is correct 
		    
		    
		 .then()
		  // .body("gender",equalTo("male"))    	
		   // .statusCode(200)
		    .log().all();
		
	}

}
