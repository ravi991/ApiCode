package com.restapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class SingleUser extends TestBase {
	
	@BeforeClass
	void singleUserList()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		response= httprequest.request(Method.GET,"/users/2");
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
	}

	@Test
	void singleuserNotFound()
	{
		response= httprequest.request(Method.GET,"/users/23");
		String responseBody=response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		System.out.println(statusCode);
	}
}
