package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class CreateUser extends TestBase {
	
	String name=RestUtilities.username();
	String job=RestUtilities.job();

	@BeforeClass
	void singleUserList()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("name",name);
		requestParams.put("job", job);
		
		
		httprequest.body(requestParams.toJSONString());
		response= httprequest.request(Method.POST,"/users");
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
	}
}
