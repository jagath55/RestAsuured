package restassured_paramters;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class parampetrs {
	
	//https://reqres.in/api/users?page=2
	@Test(enabled=false)
	void test1(){
	
	given()
	       .header("x-api-key", "reqres-free-v1")
	       .pathParam("path1","users")
	       .queryParam("page","2")
	      .queryParam("id", "7")
	       
	.when()
	      .get("https://reqres.in/api/{path1}")
	 .then()
	       .statusCode(200)
	       .log().all();
	}
	
	
	@Test(enabled=false)
	void testcookie() {
		given()
		.when().get("https://www.google.co.in/")
		.then()
		      .cookie("AEC")
		      .log().all();
	}
	
	@Test(enabled=false)
	void getcookieinfo() {
		
		Response res=given()
				
				.when().get("https://www.google.co.in/");
	
		/*
	String cookievalue=	res.getCookie("AEC"); // to get single cookie
		*/
		Map<String,String>all_cookies=res.getCookies();   // to get all cookies
		System.out.println(all_cookies.keySet());
		
		
		for(String k:all_cookies.keySet()) {
			System.out.println(k+"      "+res.cookie(k));
			
			
	}}
	
	
	@Test(enabled=false)
	public void testheader() {
		Response res=given()
		
		.when().get("https://www.google.co.in/");
		
		//.then();
		//.header("", "");
		
		Headers all_headers=res.getHeaders();
		for(Header h:all_headers) {
			System.out.println(h.getName() +"  header value " +h.getValue());
		}
		//System.out.println(res.getHeader());
	}
	
	@Test
	public void testlog() {
         
		given()
		
		.when().get("https://www.google.co.in/")
		
		.then()
		  .log().headers();
		
	
		
	}
}
