package all_Resourcse;

public class PayLoad {

	public static String getPostData()
	{
		String post = "{ \"location\":"
				+ "{ \"lat\" : -44565646.45456465, "
				+ "\"lng\" : 45546.4274545664362 }, "
				+ "\"accuracy\":4564564646, "
				+ "\"name\":\"Pankaj house\", "
				+ "\"phone_number\":\"(+91) 234 344 4567\", "
				+ "\"address\" : \"West plum street\", "
				+ "\"types\": [\"asd park\",\"soupung\"], "
				+ "\"website\" : \"http://google.com\", "
				+ "\"language\" : \"English-IN\" }";
		
		return post;
	}
	
	public static String getDeleteData()
	{
		String post = "{ \"location\":"
				+ "{ \"lat\" : -34.234, "
				+ "\"lng\" : 234.34 }, "
				+ "\"accuracy\":46, "
				+ "\"name\":\"Karthink house\", "
				+ "\"phone_number\":\"(+91) 234 344 4567\", "
				+ "\"address\" : \"West plum street\", "
				+ "\"types\": [\"asd park\",\"soupung\"], "
				+ "\"website\" : \"http://google.com\", "
				+ "\"language\" : \"English-IN\" }";
		return post;
	}
	
	public static String libraryPostData()
	{
		String post = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"aqfrs\",\r\n" + 
				"\"aisle\":\"2433\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
	
	 return post;
	 
	}
	
	public static String AddBook(String isbn, String aisle)
	{
		String payLoad = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" +   // note to break string give " + variable name + " this way can add variable
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
		return payLoad;
	}
	
}