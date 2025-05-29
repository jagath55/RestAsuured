package RestAssuredlearn_tc;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class AppTest {
	
	int id;

    @Test(enabled=true,priority=1)
    public void getusers() {
    	
    	
    	
    	when()
    	  .get("https://reqres.in/api/users?page=2")
    	
    	.then()
    	.statusCode(200)
    	.body("total_pages", equalTo(2))
    	.body("data[1].email",equalTo("lindsay.ferguson@reqres.in"))
    	
    	.log().all();
    	
    	Response res = given()
    			      // .contentType(ContentType.JSON)    		
    			       .when().get("https://reqres.in/api/users?page=2");
    	
    	/*
    	String emailo=res.jsonPath().get("data[0].email").toString();
    	Assert.assertEquals(emailo,"michael.lawson@reqres.in");
    	
    	res.XmlPath().get().toString();
    	    	*/
    	
    	JSONObject jo = new JSONObject(res.asString());
    	
    for(int j =0;j<jo.getJSONArray("data").length();j++) {
    	String id =jo.getJSONArray("data").getJSONObject(j).get("email").toString();
    	System.out.println(id);
    }
    
    
    
    /*    
     * 
     * 
     * */
    	
    	
       
    }
    
    @Test(enabled=false,priority=2)
    public void postuser() {
    	HashMap hm = new HashMap();
    	hm.put("name","dhoni");
    hm.put("job","leader");
    	
    	
    	id =given()
    			//.auth().basic("username","password")
    			//.auth().digest("username","password")
    			//.auth().preemptive().basic("username", "password")
    			//.auth().oauth(DEFAULT_URI, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
    			//.auth().oauth2(DEFAULT_BODY_ROOT_PATH)
    	     .header("x-api-key", "reqres-free-v1")
    	     .contentType("application/json")
    	     .body(hm)
    	
    	.when()
    	       //.post("https://api.restful-api.dev/objects\n"
    	       	//	+ "")
    	       //.jsonPath().get("id");
    	
    	//System.out.println(id);
    	      .post("https://reqres.in/api/users")
    	      .jsonPath().getInt("id");
    	
    	/*
    	.then()
              .statusCode(201)
              
    	      .log().all()
    	;*/
    	
    }
    
    @Test(enabled=false,priority=3,dependsOnMethods = {"postuser"})
    public void upadteuser() {
    	HashMap hm=new HashMap();
    	hm.put("name","virat");
    	
    	given()
    	.header("x-api-key", "reqres-free-v1")
    	 .contentType("application/json")
	     .body(hm)
	   
	     .when()
	        .put("https://reqres.in/api/users/" +id)
	        
	        
	      .then()
	     // .body(null, null)
	          .statusCode(200)
	         // .header("Content-Type","application/json")
	          .log().all();
    	      
     }
    
    @Test(enabled=false,dependsOnMethods = {"postuser"},priority=4)
    
    public void deleteuser() {
    	
    	
    	given()
    	.header("x-api-key", "reqres-free-v1")
    	 .contentType("application/json")
	  
	   
	     .when().delete("https://reqres.in/api/users/" +id)
	      
	        
	        
	      .then()
	          .statusCode(204)
	          
	          .log().all();
}
}
