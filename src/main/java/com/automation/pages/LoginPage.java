package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	By userName = By.id("userName");
	By password = By.id("password");
	By newUser = By.id("newUser");
	By login = By.id("login");
	By error = By.id("name");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(15));
	}
	
	public void enterUserName(String strUsername)
	{
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		username.clear();
		username.sendKeys(strUsername);
	}
	
	public void enterPassword(String strPassword)
	{
		WebElement pword = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		pword.clear();
		pword.sendKeys(strPassword);
	}
	
	public void clickNewUserButton()
	{
		WebElement newuser = wait.until(ExpectedConditions.elementToBeClickable(newUser));
		newuser.click();
	}
	
	public void clickLoginButton()
	{
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(login));
		loginButton.click();
	}
	
	
	public void navigateTo()
	{
		driver.navigate().to("https://demoqa.com/login");
	}

	public boolean isErrorMessageDisplayed()
	{
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(error));
			return true;
		}catch(TimeoutException e)
		{
			return false;
		}
	}
	
}
