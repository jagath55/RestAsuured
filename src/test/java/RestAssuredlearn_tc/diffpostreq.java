package RestAssuredlearn_tc;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;






public class diffpostreq {
	
	@SuppressWarnings("unchecked")
	
	
	
	@Test(priority=1,enabled=false)
	public void hashmap() {
		
	
		HashMap data1 = new HashMap();
		data1.put("year","2019");
		data1.put("price","1849.99");
		data1.put("CPU model", "Intel Core i9");
		data1.put("Hard disk size", "1 TB");
		
		HashMap requestbody = new HashMap();
		requestbody.put("name","Apple MacBook Pro 16");
		requestbody.put("data",data1);
		
		given()
		.contentType("application/json")
		.body(requestbody)
		
		.when()
		.post("https://api.restful-api.dev/objects")
		
		.then()
		     .statusCode(200)
		     .body("name", equalTo("Apple MacBook Pro 16"))
		     .log().all();
				  
	   
	}
	
	@Test(priority=2,enabled=false)
	public void delete() {
		when()
		   .delete("https://api.restful-api.dev/objects/ff808181932badb60196b09451145c2d");
	}
	


	




	@Test(priority=1,enabled=false)
	public void orgjson() {
		
	
		JSONObject data1 = new JSONObject();
		data1.put("year","2019");
		data1.put("price","1849.99");
		data1.put("CPU model", "Intel Core i9");
		data1.put("Hard disk size", "1 TB");
		
		JSONObject requestbody = new JSONObject ();
		requestbody.put("name","Apple MacBook Pro 16");
		requestbody.put("data",data1);
		
		given()
		.contentType("application/json")
		.body(requestbody.toString())
		
		.when()
		.post("https://api.restful-api.dev/objects")
		
		.then()
		     .statusCode(200)
		     .log().all();
	
	}
	
	@Test(priority=1,enabled=false)
	public void extjasonfile() throws FileNotFoundException {
		
		File f=new File("/home/garikipatij/eclipse-workspace/RestAssuredlearn/body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		
		/*JSONObject jsonData = loadJsonFromFile("src/test/resources/data.json");
        JSONObject requestBody = jsonData.getJSONObject("testCase1");
        */
		JSONObject requestbody = new JSONObject(jt);
		
		
		
		given()
		.contentType("application/json")
		.body(requestbody.toString())
		
		.when()
		.post("https://api.restful-api.dev/objects")
		
		.then()
		     .statusCode(200)
		     .log().all();

	}
	
	@Test(priority=1,enabled=true)
	public void pojoclass() {
		Pojo_rest data = new Pojo_rest();
		
		       data.setname("rohit");
		       data.setjob("hitter");
		       
		 given()
		       .header("x-api-key", "reqres-free-v1")
		       .contentType("application/json")
		       .body(data)
		       
		 .when()
		      .post("https://reqres.in/api/users")
		      
		  .then()
		       .statusCode(201)
		       .log().all()
		 ;
		       
	}
}


