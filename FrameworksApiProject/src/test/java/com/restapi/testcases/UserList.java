package com.restapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class UserList extends TestBase{
	
	@BeforeClass
	void getuserList()
	{
		RestAssured.baseURI="https://reqres.in/api";
		httprequest=RestAssured.given();
		response= httprequest.request(Method.GET,"/users?page=2");
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		System.out.println("Response record "+responseBody.contains(responseBody));
		Assert.assertEquals(responseBody.contains("page"), true);
	}

}
