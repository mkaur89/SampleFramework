package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class SeleniumTutorialPage extends SharedActions 
{
	@FindBy(xpath = "//a[text() = 'Selenium interview questions']")
	private WebElement LNK_seleniumQues;
	
	public SeleniumTutorialPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSeleniumQues()
	{
		try
		{
			click(LNK_seleniumQues);
			log.info("Click on "+LNK_seleniumQues);
		}
		catch(Exception e)
		{
			log.error("Unable to click on " + LNK_seleniumQues + " " + e.getMessage());
		}
	}
}
