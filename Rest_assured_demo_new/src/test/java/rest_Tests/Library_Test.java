package rest_Tests;

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
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Library_Test {
	
	
	// define properties variable
		Properties prop = new Properties();
		
		
		
		@BeforeTest
		public void getData() throws IOException
		{
			// define FIle input stream variable and give path of that file 
			FileInputStream fis = new FileInputStream("C:\\Users\\Sravanthi\\git\\Final_Trial\\Rest_assured_demo\\src\\test\\java\\all_Files\\env.properties");
			// use load method on properties variable
			prop.load(fis);
		}
		

			@Test(dataProvider="BookData")
			//@DisplayName("Library - first method ")
			public void AddBook(String isbn, String aisle)
			{
				RestAssured.baseURI = prop.getProperty("HOST_LIBRARY");
				
				Response res = 
				given().
						header("Content-Type","application/json").
						body(all_Resourcse.PayLoad.AddBook(isbn,aisle)). // Method is in payLoad
				when().	
						post(all_Resourcse.Resource.resrcLibraryPost()).
				then().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("Msg",equalTo("successfully added")).and().
						extract().response();
				
				
				// convert raw data to string
				String response = res.asString();
				
				// convert string into jason 
				
				System.out.println(all_Resourcse.Reusable_methods.rawToJson(response));
			}
			
			@DataProvider(name="BookData")
			public Object[][] getBookData()
			{
				return new Object[][] {{"asd","12"},{"ad","34"},{"asdds","356"}};
			}
			
			
			
			// this test is used to take input from external json file and give it to your post method
			@Test
			@DisplayName("Library - second method ")
			public void addingBookUsingExternalFile() throws IOException
			{
				RestAssured.baseURI = prop.getProperty("HOST_LIBRARY");
				
				Response res = 
				given().
						header("Content-Type","application/json").
						body(GenerateStringFromFile("C:\\Users\\Sravanthi\\Desktop\\addBook.json")). // give the path of json file having data
				when().	
						post(all_Resourcse.Resource.resrcLibraryPost()).
				then().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("Msg",equalTo("successfully added")).and().
						extract().response();
				
				
				// convert raw data to string
				String response = res.asString();
				
				// convert string into jason 
				
				System.out.println(all_Resourcse.Reusable_methods.rawToJson(response));
			}
			
			
			public static String GenerateStringFromFile(String path) throws IOException
			{
				return new String(Files.readAllBytes(Paths.get(path)));
			}

}
