package all_Resourcse;

import io.restassured.path.json.JsonPath;

public class Reusable_methods {
	
	public static String rawToJson(String raw)
	{
		JsonPath js = new JsonPath(raw);
		String ID = js.get("ID");  // here you got place ID
		return ID;
	}

	public static JsonPath rawToJsonForAll(String raw)
	{
		JsonPath js = new JsonPath(raw);
		return js;
	}
}
