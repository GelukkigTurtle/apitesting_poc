package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestExample extends RequestTestNG {

	@Test
	public void testGET() {

			baseURI = URL;
			
			Response result = given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					expect().
					statusCode(STATUS_CODE_OK).
					then().
					body(notNullValue()).log().all().
					when().
					get(PORT);

			result.prettyPrint();
			
			@SuppressWarnings("rawtypes")
			ResponseBody body = result.getBody();
			
			Assert.assertEquals(body.asString().contains(PARAM_ID), true, VAR_ID);
	}
	
	@Test
	public void testPOST() {
		
		baseURI = URL;
		
		Response result = given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		body(requestParam().toJSONString()).log().all().
		expect().
		statusCode(STATUS_CODE_OK_POST).
		then().
		when().
		post(PORT);
		
		result.prettyPrint();
		
		@SuppressWarnings("rawtypes")
		ResponseBody body = result.getBody();
		
		Assert.assertEquals(body.asString().contains(PARAM_USERID), true, VAR_USER_ID);
		
	}
	
	@Test
	public void testPUT() {
		
		baseURI = URL;
		
		Response result = given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		body(requestParam().toJSONString()).log().all().
		expect().
		statusCode(STATUS_CODE_OK).
		then().
		when().
		put(PORT2);
		
		result.prettyPrint();
		
		@SuppressWarnings("rawtypes")
		ResponseBody body = result.getBody();
		
		Assert.assertEquals(body.asString().contains(PARAM_USERID), true, VAR_USER_ID);
	}
	
	@Test
	public void testDelete() {
		
		baseURI = URL;
		
		Response result = given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		param(PARAM_USERID, VAR_USER_ID).log().all().
		expect().
		statusCode(STATUS_CODE_OK).
		then().
		when().
		delete(PORT2);
		
		result.prettyPrint();
		
		@SuppressWarnings("rawtypes")
		ResponseBody body = result.getBody();
		
		Assert.assertEquals(body.asString().contains(""), true, "");
	}

}