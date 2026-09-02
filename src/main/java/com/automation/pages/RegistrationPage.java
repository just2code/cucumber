package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("userEmail");
	By mobile = By.id("userNumber");
	By submitButton = By.id("submit");
	By success = By.id("example-modal-sizes-title-lg");
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(15));
				
	}
	
	public void navigateTo()
	{
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		
	}
	
	public void enterFirstName(String strFirstName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(strFirstName);
	}
	
	public void enterLastName(String strLastName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(strLastName);
	}
	
	public void enterUserEmail(String strEmail)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(strEmail);
	}
	
	public void enterMobileNumber(String strMobileNumber)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobile)).sendKeys(strMobileNumber);
	}
	
	public void clickSubmitButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(submitButton));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
	
	public boolean isConfirmationDisplayed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(success));
			return true;
		}catch(TimeoutException e)
		{
			return false;
		}
	}

}
