package all_tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


class MathUnitsTest {

	
	@Test
	public static void trial() 
	{
		System.out.println("Trying ");
	}

	
	@Test
	public static void read() 
	{
		System.out.println("This is from math unit class");
	}


	@Test
	public void testCRUDOperationsAllTogether() {
		
		
		
		final RequestSpecification reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBaseUri("http://localhost:8080")
				.setBasePath("/topics")
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
