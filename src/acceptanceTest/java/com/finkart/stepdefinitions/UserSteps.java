package com.finkart.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Ignore;

import com.finkart.bdd.SpringBootIntegrationTest;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Ignore
public class UserSteps extends SpringBootIntegrationTest {

	/*
	@Value("${proj.user.url}")
	private String baseUrl;
	*/
	JSONObject json;
	
	Response jwtResponse;
	Response invalidResponse;
	private final String URL = "http://localhost:8080/user/v1";
	
	Scenario scenario;
	String payload;
	
	@Before
	public void setUp(Scenario scenario) throws IOException {
		RestAssured.baseURI = URL;
		request = RestAssured.given();
		this.scenario = scenario;
		
		log.info("request: {}", request);
	}
	
	@Given("^User pass \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" data$")
	public void user_pass_data(String firstName, String lastName, String address1, String city) throws Throwable {
		
		payload = "{\n" +
		        //"  \"id\": "+id + ",\n" +
		        "  \"firstName\": " + firstName + ",\n" +
		        "  \"lastName\": "+ lastName +",\n" +
		        "  \"address1\": " + address1 + ",\n" +
		        "  \"city\": "+ city + "\n" +
		        "}";
	    
	   scenario.write("JSON text ");
	   scenario.write(payload);

	}

	@When("^User calls POST method$")
	public void user_calls_POST_method() throws Throwable {
		log.info("payload {}", payload);
		log.info("request {}", request);
		
		jwtResponse = request.when().contentType(ContentType.JSON).body(payload).post("/create").then()
	            .extract()
	            .response(); 
		
		scenario.write("Response Json");
		scenario.write(jwtResponse.getBody().asString());
	}

	@Then("^user gets response status (\\d+)$")
	public void user_gets_response_status(int status) throws Throwable {
		log.info("jwtResponse.getStatusCode() {}", jwtResponse.getStatusCode());
		
		assertEquals(status, jwtResponse.getStatusCode());
	    
	}
	
	@Given("^User pass data$")
	public void user_pass_data() throws Throwable {
		
		scenario.write("JSON data: ");
		scenario.write(payload);
	}

	@When("^User calls GET method$")
	public void user_calls_GET_method() throws Throwable {
		jwtResponse = request.when().contentType(ContentType.JSON).get("/list").then()
	            .statusCode(200)
	            .extract()
	            .response(); 
		
		scenario.write("Response Json");
		scenario.write(jwtResponse.getBody().asString());
	}

	@Given("^User pass (\\d+) data$")
	public void user_pass_data(int id) throws Throwable {
		
		scenario.write("JSON data: ");
		//scenario.write(payload);
	}
	
	@When("^User calls GET with (\\d+)$")
	public void user_calls_GET_with(int id) throws Throwable {
		jwtResponse = request.when().contentType(ContentType.JSON).get("/"+id).then()
	            .statusCode(200)
	            .extract()
	            .response(); 
		
		scenario.write("Response Json");
		scenario.write(jwtResponse.getBody().asString());
	}
	
	@Given("^User pass (\\d+) invalid data$")
	public void user_pass_invalid_data(int id) throws Throwable {
		
		scenario.write("JSON data: ");
		scenario.write(String.valueOf(id));
	}
	
	@When("^User calls GET with (\\d+) invalid record$")
	public void user_calls_GET_with_invalid_record(int id) throws Throwable {
		
		invalidResponse = request.when().contentType(ContentType.JSON).get("/"+id).then().extract().response();
		
		scenario.write("Response Json");
		scenario.write(invalidResponse.getBody().asString());
	}
	

	@Then("^user gets invalid response status (\\d+)$")
	public void user_gets_invalid_response_status(int status) throws Throwable {
		log.info("invalidResponse.getStatusCode() {}", invalidResponse.getStatusCode());
		
		assertEquals(status, invalidResponse.getStatusCode());
	    
	}

}
