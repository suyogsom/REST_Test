package com.sai;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.authentication.OAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.http.AuthConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

public class Twitter_test {
	
	private String accessToken;
	private String accessTokenSecret;
	private RequestSpecification recSpec;
	
	
	public RequestSpecification getRecSpec() {
		return recSpec;
	}


	/*public void testResourcesFirst() throws JsonProcessingException {

		final RequestSpecification reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBaseUri("https://api.twitter.com")
				.setBasePath("/oauth")
				.build();	
		FirstTest( reqSpec);
		
		
	}*/
	
	
	@BeforeTest
	public void FirstTest(RequestSpecification reqSpec) throws JsonProcessingException
	{
		

		Response res = 
		given().
				spec(reqSpec).auth().oauth("B5ROdvEXfEpGwRQI7N201t4sE", "1qBIxzqjusxjhvU0M5pxlqzdG9yM9WAtdINW9geNzMnHgsqvzU", "", "").
		when().	
				get("/oauth/request_token").
		then().
				assertThat().statusCode(200).and().
				extract().response();
		
	
		
		// convert raw data to string
		String response = res.asString();
		System.out.print(response);
		

		String accessToken1 = response.substring(response.indexOf("oauth_token="), response.indexOf("&"));
		accessToken = accessToken1.substring(12);
		System.out.print("\n\nAccess token : " +accessToken);
	
		
		String accessTokenSecret1 = response.substring(response.indexOf("oauth_token_secret="), response.lastIndexOf("&"));
		accessTokenSecret = accessTokenSecret1.substring(19);
		System.out.print("\n\n Access token secret:" +accessTokenSecret);

		
	}

	@BeforeTest
	public RequestSpecification gettingRecSpecs()
	{
		AuthenticationScheme auth = new OAuthScheme();

		final RequestSpecification reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBaseUri("https://api.twitter.com")
				.setAuth((AuthenticationScheme) ((AuthenticationSpecification) auth).oauth("B5ROdvEXfEpGwRQI7N201t4sE", "1qBIxzqjusxjhvU0M5pxlqzdG9yM9WAtdINW9geNzMnHgsqvzU", "1113222466862612481-Wtp3gwgS9rjt2NSuHkGsck6juVd2E8", "I5tfBmZIMd8kfnIyiQ1a4s6fxLuTOxxaXejtRoC71OqhM"))
				.build();

		return reqSpec;
		
		
	}
	
	

	
}
