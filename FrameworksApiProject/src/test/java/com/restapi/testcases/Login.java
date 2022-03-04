package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Login extends TestBase {

	@Test
	void login()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		
		httprequest.header("Content-Type","application/json");
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("email","eve.holt@reqres.in");
		requestParams.put("password","cityslicka");
		
		
		httprequest.body(requestParams.toJSONString());
		response= httprequest.request(Method.POST,"/login");
	}
	
	@Test(dependsOnMethods="login")
	void checkResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(statusCode);
	}
}
