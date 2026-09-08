package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	By male = By.xpath("//input[@value='Male']");
	By female = By.xpath("//input[@value='Female']");
	By other = By.xpath("//input[@value='Other']");
	//Thanks for submitting the form
	//closeLargeModal
	
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
	
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(male)).click();
		}else if(gender.equalsIgnoreCase("female"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(female)).click();
		}else 
		{
			wait.until(ExpectedConditions.elementToBeClickable(other)).click();
		}
			
	}
	
	public void clickSubmitButton()
	{
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		System.out.println("Before scroll");
		System.out.println("Is displayed: "+submit.isDisplayed());
		System.out.println("Is enabled: "+submit.isEnabled());
		System.out.println("Location: "+submit.getLocation());
		//System.out.println("BoundingLocation: "+ submit.ge );
		System.out.println("Size: "+submit.getSize());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({block : 'center'});",driver.findElement(submitButton));
		System.out.println("After scroll");
		System.out.println("Location: "+submit.getLocation());
		
		//wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		//for diagnosis
		 js = (JavascriptExecutor) driver;

		String rect = (String) js.executeScript("""
		    const r = arguments[0].getBoundingClientRect();

		    return `top=${r.top}, bottom=${r.bottom}, ` +
		           `left=${r.left}, right=${r.right}, ` +
		           `width=${r.width}, height=${r.height}, ` +
		           `viewportHeight=${window.innerHeight}, ` +
		           `viewportWidth=${window.innerWidth}`;
		    """, submit);

		System.out.println("Button viewport position: " + rect);

			//System.out.println("Element at button center:");
			//System.out.println(elementAtPoint);
		
		String scrollInfo = (String) js.executeScript("""
			    let el = arguments[0];
			    let result = [];

			    while (el) {
			        result.push(
			            el.tagName +
			            " | class=" + el.className +
			            " | scrollHeight=" + el.scrollHeight +
			            " | clientHeight=" + el.clientHeight +
			            " | overflowY=" +
			            getComputedStyle(el).overflowY
			        );

			        el = el.parentElement;
			    }

			    return result.join("\\n");
			    """, submit);

			System.out.println("Scroll hierarchy:");
			System.out.println(scrollInfo);
		submit.click();
	}
	
	public boolean isConfirmationDisplayed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(success));
			return true;
		}catch(TimeoutException e)
		{
			return false;
		}
	}

}
