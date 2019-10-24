package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class BlogPage extends SharedActions 
{
	@FindBy(xpath = "//a[text() = 'Selenium tutorial']")
	private WebElement LNK_seleniumTutorial;
	@FindBy(xpath = "//button[text() = 'No thanks']")
	private WebElement BTN_decline;

	public BlogPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSeleniumTraining()
	{
		try
		{
			click(LNK_seleniumTutorial);
			log.info("Clicked on "+LNK_seleniumTutorial);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
	public void clickNoThanks()
	{
		try
		{
			click(BTN_decline);
			log.info("Clicked on "+BTN_decline);
		}
		catch(Exception e)
		{
			log.error("Unable to click on "+BTN_decline + " "+ e.getMessage());
		}
	}
}
