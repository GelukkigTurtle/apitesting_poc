package test;

import org.json.simple.JSONObject;

public interface RequestTestNG {
	
	//URL
	static String URL = "https://jsonplaceholder.typicode.com";
	static String PORT = "/posts";
	static String PORT2 = "/posts/1";
	static int STATUS_CODE_OK = 200;
	static int STATUS_CODE_OK_POST = 201;
	
	//Json Params
	static String PARAM_USERID = "userId";
	static String PARAM_TITLE = "title";
	static String PARAM_BODY = "body";
	static String PARAM_ID = "id";
	
	static String VAR_USER_ID = "11";
	static String VAR_ID = "100";

	

}
