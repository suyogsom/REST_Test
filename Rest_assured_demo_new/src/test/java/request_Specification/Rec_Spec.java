package request_Specification;

//to use REST import following three
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

//import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.junit.jupiter.api.DisplayName;


//import org.junit.jupiter.api.BeforeEach; // now using testNg's beforeTest
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;  // if you keep this one then it will use by default JUnit


import org.testng.annotations.Test;  // using this will tell compiler to use testNG


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rec_Spec {

	@Test
	public void testCRUDOperationsAllTogether() {
		
		final String token = "115fc253fe634517af590d12c525edfb";
		
		final RequestSpecification reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.addHeader("X-Api-Key", token)
				.setBaseUri("https://api.getpostman.com")
				.setBasePath("/collections")
				.build();	
		create(reqSpec);
	}
	
	
	
	private void create(RequestSpecification reqSpec) {
			
		
		// Create a new customer
		final Response resp = 
			given()
				.spec(reqSpec)
			.when()
				.get("")
			.then()
				.assertThat()
				.statusCode(200)
				.extract().response();
		
		final String info = resp.asString();
		System.out.print(info);
				
		
	}
	 
	
}
