package com.edureka.scripts;

import org.testng.annotations.Test;

import com.edureka.common.BaseTest;
import com.edureka.pages.MyClassroomPage;

public class MyClassroomScripts extends BaseTest 
{
	MyClassroomPage classroomPage = null;
	
	@Test
	public void tc_01_selectBlogOption()
	{
		classroomPage = new MyClassroomPage(driver);
		classroomPage.clickCommunity();
		classroomPage.openBlogInNewTab();
	}
}
