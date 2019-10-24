package com.edureka.scripts;

import org.testng.annotations.Test;

import com.edureka.common.BaseTest;
import com.edureka.pages.BlogPage;
import com.edureka.pages.SeleniumTutorialPage;

public class BlogScripts extends BaseTest 
{
	BlogPage blogPage = null;
	SeleniumTutorialPage seleniumPage = null;
	
	@Test
	public void tc_01_seleniumBlog()
	{
		blogPage = new BlogPage(driver);
		seleniumPage = new SeleniumTutorialPage(driver);
		
		blogPage.clickNoThanks();
		blogPage.clickSeleniumTraining();
		seleniumPage.clickSeleniumQues();
		seleniumPage.closeCurrentTab();
	}
}
