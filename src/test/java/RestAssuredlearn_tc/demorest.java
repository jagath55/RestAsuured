package RestAssuredlearn_tc;

import org.testng.annotations.Test;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demorest {
	
	@Test (enabled=true)
	public void test1() {
		
		//Create a reference for Response interface
		Response response;
		
		response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		JsonPath jsoneval=response.jsonPath(); 
		List<Object> names = jsoneval.getList("data.id");
		
		String Efirstname = jsoneval.get("data[0].email");
		String Afirstname ="michael.lawson@reqres.i";
		
		String responsebody = response.getBody().asString();
		String contenttype = response.getContentType();
		
		System.out.println("respones is " +responsebody);
		System.out.println("content is " + contenttype);  //prints content tyoe ex: application/json,xml like that
		System.out.println("json first name " + Efirstname);
		System.out.println(jsoneval.getString("page"));
		
		
	//	Assert.assertEquals(responsebody.contains());
		
		System.out.println("no of ids "+names.size());
		System.out.println("no of ids "+names);
		for(Object n:names) {
			System.out.println(n);
		}
		
		
		
		//Assert.assertEquals(Afirstname,Efirstname,"incorrect mail");
		
		/*
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Afirstname,"michael.lawson@reqres.ie","incorrect mail");
		sa.assertAll();
		System.out.println("all asertions are completed");
		*/
		
	}
	
	@Test(enabled=false)
	public void test2() {
		
		RestAssured.baseURI= "https://reqres.in/";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response =httprequest.request(Method.GET,"/api/users/2");
	//	Response response1=httprequest.request(Method.POST,"wdfref");
		
		String responsebody = response.getBody().asString();
		String sessionid= response.getSessionId();    //session id
		int statuscode=response.getStatusCode(); // status code
		String statusline= response.getStatusLine();  // status line like http
		Headers allheaders = response.getHeaders();  // get all headers present 
		String header_content_type=response.getHeader("Content-Type"); //individual header 
		
	//	String
		
		System.out.println("test2 " + responsebody);
		System.out.println("test2 session" + sessionid);   //prints session id , if it is not there null value 
		System.out.println("test2 session" + statuscode);  
		System.out.println("test2 statusline " + statusline); 
		
		System.out.println("headers" + allheaders);
		
		for (Header header: allheaders) {
			System.out.println("KEY "+ header.getName() + "  " +" VALUE " + header.getValue());   //
			
		}
		
		System.out.println(header_content_type);
		
	}
	
	
	@Test(enabled=true)
	public void test2post() {
		
		RestAssured.baseURI= "https://reqres.in/";
		
		RequestSpecification httprequest=RestAssured.given();
		
		httprequest.header("content-type","application/json");
		
		JSONObject requestpara= new JSONObject();
		requestpara.put("name", "morpheus");
		requestpara.put("job", "leader");
		
        httprequest.body(requestpara.toString());
		
		Response response =httprequest.post("/api/users");
		
		
		System.out.println(response.getStatusCode());
	
	
	}
}
