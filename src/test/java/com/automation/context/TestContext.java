package com.automation.context;

import org.openqa.selenium.WebDriver;

import com.automation.driverFactory.DriverFactory;
import com.automation.pages.LoginPage;
import com.automation.pages.RegistrationPage;

public class TestContext {
	
	
		
	private LoginPage loginPage; 
	private RegistrationPage registrationPage;
	
	public WebDriver getDriver()
	{
		return DriverFactory.getDriver();
	}
	
	public LoginPage getLoginPage()
	{
		if(loginPage==null)
		{
			loginPage = new LoginPage(getDriver());
		}
		return loginPage;
	}
	
	public RegistrationPage getRegistrationPage()
	{
		
		if(registrationPage==null)
		{
			registrationPage = new RegistrationPage(getDriver());
		}
		return registrationPage;
	}
}
