package apichaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class delete {
	
	int id;

	@Test
	public void getuser(ITestContext context) {
		
       String BEARER_TOKEN="a8dfa7b0735a6351491b559d136bbceacb23fe6a97d5b7ddd9a54a72fea54df9";
		
		int id = (Integer) context.getAttribute("userid");
		
		given()
		.headers("Authorization","Bearer "+BEARER_TOKEN)
		.pathParam("path",id)
		   
		.when()
		    .delete("https://gorest.co.in/public/v2/users/{path}")
		    
		 .then()
		   .statusCode(204)
		.log().all();	
	}

}
