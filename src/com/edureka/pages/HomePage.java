package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class HomePage extends SharedActions 
{
	@FindBy(xpath = "//a[text() = 'Log In']")
	private WebElement LNK_login;
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin()
	{
		try
		{
			click(LNK_login);
			log.info("Clicked on "+LNK_login);
		}
		catch(Exception e)
		{
			log.error("Unable to click on "+LNK_login + " " + e.getMessage());
		}
	}


}
