package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class RegisterUser extends TestBase{

	String email=RestUtilities.email();
	String password=RestUtilities.password();
	@Test
	void register()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		
		httprequest.header("Content-Type","application/json");
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("email","eve.holt@reqres.in");
		requestParams.put("password","pistol");
		
		
		httprequest.body(requestParams.toJSONString());
		response= httprequest.request(Method.POST,"/register");
	}
	
	@Test(dependsOnMethods="register")
	void checkResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
	}
	
	@Test
	void unSuccessFull()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		
		httprequest.header("Content-Type","application/json");
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("email","eve.holt@reqres.in");
		
		
		
		httprequest.body(requestParams.toJSONString());
		response= httprequest.request(Method.POST,"/register");
	}
	
	@Test(dependsOnMethods="unSuccessFull")
	void checkUnSuccessfulResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
	}
	
}
