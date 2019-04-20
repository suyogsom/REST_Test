package twitter_API;

// to use REST import following three
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.BeforeEach; // now using testNg's beforeTest
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
// import org.junit.jupiter.api.Test;  // if you keep this one then it will use by default JUnit

import org.testng.annotations.Test;  // using this will tell compiler to use testNG

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.OAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Twitter_Test_1 {	
	
	public AuthenticationScheme gettingAuth()
	{
		AuthenticationScheme auth =   new OAuthScheme(); 
		 ((OAuthScheme) auth).getAccessToken();
		 ((OAuthScheme) auth).getConsumerKey();
		 ((OAuthScheme) auth).getConsumerSecret();
		 ((OAuthScheme) auth).getSecretToken();
		 
		
		return (AuthenticationScheme)auth;
	}
	
	@Test
	public void testResourcesFirst() {
		AuthenticationScheme auth =   new OAuthScheme(); 
		System.out.print(((OAuthScheme) auth).getAccessToken());
		
		final RequestSpecification reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setAuth(gettingAuth())
				.setBaseUri("https://api.twitter.com")
				.setBasePath("/1.1/statuses")
				.build();	
		FirstTest( reqSpec);
		
	}
	
	
	public void FirstTest(RequestSpecification reqSpec)
	{
		
		Response res = 
		given().
				spec(reqSpec).
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
