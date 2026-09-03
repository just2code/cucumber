package com.automation.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.context.TestContext;
import com.automation.driverFactory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContext context;
	
	public Hooks(TestContext context)
	{
		this.context=context;
	}
	
	@Before("@ui")
	public void beforeScenario()
	{
		DriverFactory.initDriver();
	}
	
	@After("@ui")
	public void afterScenario(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] srcFile = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcFile,"image/png" ,"failure-screenshot");
		}
		
		DriverFactory.quitDriver();
	}
	

}
