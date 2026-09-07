package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/registration.feature",
		glue = {"com.automation.stepdefinition",
				"com.automation.hooks"},
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber-report.html","json:target/cucumber-report.json"}		
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	

}
