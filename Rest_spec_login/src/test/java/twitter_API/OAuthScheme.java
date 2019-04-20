package twitter_API;

import io.restassured.authentication.AuthenticationScheme;

public class OAuthScheme{

	private String ConsumerKey;
	private String ConsumerSecret ;
	private String AccessToken ; 
	private String TokenSecret ;
	
	
	OAuthScheme ()
	{
		this.ConsumerKey= "B5ROdvEXfEpGwRQI7N201t4sE";
		this.ConsumerSecret= "1qBIxzqjusxjhvU0M5pxlqzdG9yM9WAtdINW9geNzMnHgsqvzU";
		this.AccessToken="1113222466862612481-Wtp3gwgS9rjt2NSuHkGsck6juVd2E8";
		this.TokenSecret="I5tfBmZIMd8kfnIyiQ1a4s6fxLuTOxxaXejtRoC71OqhM";
	}
	
	
	
	public String getConsumerKey() {
		return ConsumerKey;
	}


	public String getConsumerSecret() {
		return ConsumerSecret;
	}


	public String getAccessToken() {
		return AccessToken;
	}


	public String getTokenSecret() {
		return TokenSecret;
	}


	
}
