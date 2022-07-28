package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestExample {

	@Test
	public void testGET() {
		
		baseURI = "https://jsonplaceholder.typicode.com";
		given().
		contentType(ContentType.JSON).
		param("id", "100").
		expect().
		statusCode(200).
		body("", hasSize(1)).
		when().
		get("/posts").
		then().
		log().all();

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPOST() {
		
		JSONObject request = new JSONObject();
		
		request.put("userId", "11");
		request.put("title", "EFRA");
		request.put("body", "Prueba");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://jsonplaceholder.typicode.com";
		given().
		contentType(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/posts").
		then().
		statusCode(201).
		log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPUT() {
		JSONObject request = new JSONObject();
		
		request.put("userId", "11");
		request.put("title", "EFRA");
		request.put("body", "Prueba777");
		
		baseURI = "https://jsonplaceholder.typicode.com";
		given().
		contentType(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/posts/1").
		then().
		statusCode(200).
		log().all();
	}
	
	@Test
	public void testDelete() {
		
		baseURI = "https://jsonplaceholder.typicode.com";
		given().
		param("userId", "11").
		expect().
		statusCode(200).
		when().
		delete("/posts/1").
		then().
		log().all();
	}

}