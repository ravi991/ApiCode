package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class UnSucessLogin extends TestBase {

	@Test
	void unsuccesfullogin()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		
		httprequest.header("Content-Type","application/json");
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("email","eve.holt@reqres.in");
		
		
		
		httprequest.body(requestParams.toJSONString());
		response= httprequest.request(Method.POST,"/login");
	}
	
	@Test(dependsOnMethods="unsuccesfullogin")
	void checkResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
	
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 400);
		System.out.println(statusCode);
	}
}
