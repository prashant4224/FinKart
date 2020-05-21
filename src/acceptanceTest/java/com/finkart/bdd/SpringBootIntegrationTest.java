package com.finkart.bdd;

import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.ContextConfiguration;

import com.finkart.BankingAppApplication;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;

import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(classes = BankingAppApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public abstract class SpringBootIntegrationTest {

	
	protected RequestSpecification request;
    protected Response response;
    //protected ValidatableResponse json;
    protected RestAssuredConfig config;

    @ClassRule
    public static WireMockClassRule wiremock = new WireMockClassRule(
            WireMockSpring
                    .options()
                    .port(8090));

    /*
    @Value("${app.endpoint.timeout}")
    protected Integer timeOut;


    @Value("${spring.profiles.active}")
    protected String activeProfile;

    protected WireMockPactGenerator wireMockPact;
    */
}
