package all_tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;  

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
