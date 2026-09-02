package com.automation.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	
	private DriverFactory()
	{
		
	}
	
	public static void initDriver()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driverThreadLocal.set(driver);
	}
	
	public static WebDriver getDriver()
	{
		return driverThreadLocal.get();
	}
	
	public static void quitDriver()
	{
		WebDriver driver = driverThreadLocal.get();
		
		if(driver!=null)
		{
			driver.quit();
			driverThreadLocal.remove();
		}
	}

}
