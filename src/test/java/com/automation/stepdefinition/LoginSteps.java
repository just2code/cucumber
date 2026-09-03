package com.automation.stepdefinition;

import static org.testng.Assert.assertEquals;

import com.automation.context.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private final TestContext context;
	
	public LoginSteps(TestContext context)
	{
		this.context=context;
	}
	
	@Given("the user is on the login page")
	public void userIsOnTheLoginPage()
	{
		context.getLoginPage().navigateTo();
	}
	
	@When("the user logs in wuth username {string} and password {string}")
	public void userEntersLoginCredentials(String userName,String password)
	{
		context.getLoginPage().enterUserName(userName);
		context.getLoginPage().enterPassword(password);
		context.getLoginPage().clickLoginButton();
	}
	
	@Then("an error message should be displayed")
	public void loginErrorMessageDisplayed()
	{
		Assert.assertEquals(context.getLoginPage().isErrorMessageDisplayed(),true);
	}

}
