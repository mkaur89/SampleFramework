package com.edureka.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class MyClassroomPage extends SharedActions
{
	@FindBy(xpath = "//button[contains(text(), 'Community')]")
	private WebElement BTN_community;
	@FindBy(xpath = "//li[@role=\"menuitem\"]/a[text() = 'Blog']")
	private WebElement LNK_blog;
	
	public MyClassroomPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickCommunity()
	{
		try
		{
			click(BTN_community);
			log.info("Clicked on "+BTN_community);
		}
		catch(Exception e)
		{
			log.error("Unable to click on Community menu option "+ e.getMessage());
		}
	}
	public void openBlogInNewTab()
	{
		try
		{
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).click(LNK_blog).keyUp(Keys.CONTROL).build().perform();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			//Set<String> tabs = driver.getWindowHandles();
			driver.switchTo().window(tabs.get(1));
			log.info("Clicked on "+LNK_blog);
		}
		catch(Exception e)
		{
			log.error("Unable to click on Blog sub-menu option "+ e.getMessage());
		}
	}
}
