package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.utilities.RestUtilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class UpdateClass extends TestBase{
	
	String name=RestUtilities.username();

	@BeforeClass
	void updateList()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("name",name);
		requestParams.put("job", "zion resident");
		
		
		httprequest.body(requestParams.toJSONString());
		response= httprequest.request(Method.PUT,"/users/2");
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
	}
}
