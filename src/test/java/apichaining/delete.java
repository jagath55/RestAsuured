package apichaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class delete {
	
	int id;

	@Test
	public void getuser(ITestContext context) {
		
		int id =(Integer) context.getAttribute("userid");
		given()
		   .header("x-api-key","reqres-free-v1")
		   .param("path",id)
		   
		.when()
		    .delete("https://reqres.in/api/users/{path}")
		    
		 .then()
		     .statusCode(204);
		
	}

}
