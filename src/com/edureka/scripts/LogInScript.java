package com.edureka.scripts;

import org.testng.annotations.Test;

import com.edureka.common.BaseTest;
import com.edureka.common.ReadExcel;
import com.edureka.pages.HomePage;
import com.edureka.pages.LoginPage;

public class LogInScript extends BaseTest 
{
	HomePage homePage = null;
	LoginPage loginPage = null;
	
	@Test
	public void tc_01_login()
	{
		try
		{
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			String[][] credentials = ReadExcel.fetchData(FILE_PATH, "Credentials.xlsx", "Login");
			for(int indexRow = 1; indexRow<credentials.length; indexRow++)
			{
				String email = credentials[indexRow][0];
				String password = credentials[indexRow][1];
				
				homePage.clickOnLogin();
				loginPage.fillEmailId(email);
				loginPage.fillPassword(password);
				loginPage.clickLoginBtn();
				log.info("TC_01 has been executed successfully");
			}
		}
		catch(Exception e)
		{
			log.error("TC_01 has failed " + e);	
		}
	}
}
