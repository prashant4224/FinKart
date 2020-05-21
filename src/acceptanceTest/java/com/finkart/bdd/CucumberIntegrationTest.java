package com.finkart.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:output/cucumber-api-test.json"},
		features = {"src/acceptanceTest/resources/features"},
		glue = {"com.finkart.stepdefinitions"},
		dryRun= false
		)
public class CucumberIntegrationTest extends SpringBootIntegrationTest {

}
