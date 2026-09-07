package com.automation.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.automation.context.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	
	private final TestContext context;
	
	public RegistrationSteps(TestContext context)
	{
		this.context=context;
	}
	
	@Given("the user is on the registration page")
	public void userIsonTheRegistrationPage()
	{
		context.getRegistrationPage().navigateTo();
	}
	
	@When("the user submits the registration form with the following details:")
	public void userSubmitsRegistrationForm(DataTable data)
	{
		//The below step converts data table into a two dimensional map
		//i.e first it creates a list rows where each row contains username, pword 
		//Then the map to store username and password
		
		Map<String,String> row= data.asMap(String.class, String.class);
		
			context.getRegistrationPage().enterFirstName(row.get("firstName"));
			context.getRegistrationPage().enterLastName(row.get("lastName"));
			context.getRegistrationPage().enterUserEmail(row.get("email"));
			context.getRegistrationPage().enterMobileNumber(row.get("mobile"));			
		
		context.getRegistrationPage().clickSubmitButton();
	}
	
	@Then("the registration should be successful")
	public void registrationIsSuccessful()
	{
		Assert.assertTrue(context.getRegistrationPage().isConfirmationDisplayed());
		
	}
	

}
