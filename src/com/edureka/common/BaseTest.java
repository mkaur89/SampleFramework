package com.edureka.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

public class BaseTest implements IConstants
{
	protected Logger log = Logger.getLogger(BaseTest.class);
	public static WebDriver driver = null; //made static, otherwise when the object of that
										//class gets destroyed, driver becomes null.
	
	@Parameters({"browser"})
	@BeforeTest
	public void LaunchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}
		else
		{
			Reporter.log("Incorrect browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(APP_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	/*
	 * @AfterMethod public void CloseBrowser() { driver.close(); }
	 */
	
	@AfterTest
	public void CloseBrowsers()
	{
		driver.quit();
	}
}
