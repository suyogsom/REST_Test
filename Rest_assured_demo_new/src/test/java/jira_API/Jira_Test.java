package jira_API;

/*import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test; */

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static all_Resourcse.Resource.placePostData;
// to use REST import following three
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// to use JSON schema validation import following
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class Jira_Test {
	

	static String session_ID;
	
		// first JIRA test
		
		@Test
		public void firstJiraTest()
		{
			// creating session
			
			RestAssured.baseURI = "http://localhost:8080";
			Response res =
			
			
			given().header("Content-Type", "application/json").
					body("{ \"username\": \"Gauranga\", \"password\": \"HareKrishna108\" }").
							
			when().	
					post("/rest/auth/1/session").
			then().
					assertThat().statusCode(200).and().
					contentType(ContentType.JSON).and().
					extract().response();
			
			String response = res.asString();
			System.out.print(response);
			
			session_ID = all_Resourcse.Reusable_methods.rawToJsonForAll(response).get("session.value");

			System.out.println("\n\n"+session_ID);
			
			
		}
		
		@Test
		public void secondiraTest()
		{
			// creating session
			
			RestAssured.baseURI = "http://localhost:8080";				
			Response res =
			
			
			given().header("Content-Type", "application/json").
					header("Cookie", "JSESSIONID="+session_ID).
					body("{\r\n" + 
							"	\"fields\": {\r\n" + 
							"	   \"project\":\r\n" + 
							"	    {\r\n" + 
							"		\"key\":\"ANUP\"\r\n" + 
							"      	},\r\n" + 
							"    \"summary\": \"something's wrong\",\r\n" + 
							"    \"description\": \"first bug \",\r\n" + 
							"     \"issuetype\": {\r\n" + 
							"     \"name\":\"anup\"\r\n" + 
							"    }\r\n" + 
							"  }\r\n" + 
							"}").
							
			when().	
					post("/rest/api/2/issue").
			then().
					assertThat().statusCode(201).and().
					contentType(ContentType.JSON).and().
					extract().response();		
			
			String response = res.asString();
			System.out.print(response);
			
			String id = all_Resourcse.Reusable_methods.rawToJsonForAll(response).get("id");
			System.out.print(id);
			
			
		}
		

}
