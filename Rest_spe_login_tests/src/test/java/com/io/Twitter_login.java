package com.io;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Twitter_login {

	
	@Test
	public void testResourcesFirst() {

		final RequestSpecification reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBaseUri("https://api.twitter.com")
				.setBasePath("/1.1/statuses")
				.build();	
		FirstTest( reqSpec);
		
	}
	
	
	
	public void FirstTest(RequestSpecification reqSpec)
	{
		

		Response res = 
		given().
				spec(reqSpec).auth().oauth("B5ROdvEXfEpGwRQI7N201t4sE", "1qBIxzqjusxjhvU0M5pxlqzdG9yM9WAtdINW9geNzMnHgsqvzU", "1113222466862612481-Wtp3gwgS9rjt2NSuHkGsck6juVd2E8", "I5tfBmZIMd8kfnIyiQ1a4s6fxLuTOxxaXejtRoC71OqhM").
		when().	
				get("/home_timeline.json").
		then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				extract().response();
		
		
		// convert raw data to string
		String response = res.asString();
		System.out.print(response);
	}
}
