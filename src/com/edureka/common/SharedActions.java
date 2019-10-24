package com.edureka.common;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SharedActions 
{
	protected WebDriver driver = null;
	public Logger log = Logger.getLogger(SharedActions.class);
	
	public SharedActions(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void verifyTitle(String expectedTitile)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try
		{
			wait.until(ExpectedConditions.titleContains(expectedTitile));
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitile);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
	public void verifyElementPresent(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
	public void mouseHover(WebElement element)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
	public void click(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			log.info("Clicked on "+ element);
		}
		catch(Exception e)
		{
			log.error("Unable to click on " + element + " " +e.getMessage());
		}
	}
	public void scrollWindow()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try 
		{
			js.executeScript("window.scroll(0,200)");
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
	public void closeCurrentTab()
	{
		try
		{
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.close();
			driver.switchTo().window(tabs.get(0));
			log.info("Successfully closed current tab");
		}
		catch(Exception e)
		{
			log.error("Unable to close current tab");
		}
	}
}
