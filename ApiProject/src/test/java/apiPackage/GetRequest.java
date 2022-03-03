package apiPackage;

import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	void getDetails()
	{
		RestAssured.baseURI= "http://44.192.66.40:7000/api/auth";
		
		//Send request to server 
		RequestSpecification httprequest=RestAssured.given();
		
		//send request
		JSONObject requestParms= new JSONObject();
		
		requestParms.put("name","Am");
		requestParms.put("email","am@gmail.com");
		requestParms.put("password","Ravi@1234");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParms.toJSONString());
		
		Response response= httprequest.request(Method.POST,"/register");
		
		
		//print response in console window 
		String responsebody= response.getBody().asString();
		System.out.println("Response Body is "+responsebody );
		
		//status code
		int statusCode= response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
//		
//		
		boolean auth=response.jsonPath().get("auth");
		Assert.assertEquals(auth, true);
		
		
	}
}
