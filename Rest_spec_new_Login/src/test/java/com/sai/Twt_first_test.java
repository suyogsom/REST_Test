package com.sai;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Twt_first_test {
	
	
	Twitter_test test = new Twitter_test();
	
	
	@Test
	public void FirstTest()
	{
		

		Response res = 
		given().
				spec(test.gettingRecSpecs()).
		when().	
				get("/1.1/statuses/user_timeline.json").
		then().
				assertThat().statusCode(200).and().
				extract().response();
		
	
		
		// convert raw data to string
		String response = res.asString();
		System.out.print(response);

	}
}
