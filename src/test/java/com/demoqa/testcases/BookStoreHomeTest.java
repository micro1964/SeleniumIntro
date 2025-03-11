package com.demoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.demoqa.Base;
import com.demoqa.pages.BookStoreHomePage;

public class BookStoreHomeTest {
	
	BookStoreHomePage bsHomePage = new BookStoreHomePage();
	String testTitle = "canNavigateToBookStoreHomePage";
	@Test
	public void canNavigateToBookStoreHomePage() {
		Base.test=Base.extent.createTest(testTitle);
		Base.logInfoMessage("Starting "+testTitle+" Test.");
		bsHomePage.clickBookStoreCard();
		
		//Check for expected title
		Assert.assertEquals(bsHomePage.getWindowTitle(), "DEMOQA");
		Base.test.pass("Browser title is as expected.");
		
		//Check for expected menu item
		Assert.assertEquals(bsHomePage.isBookStoreAppMenuItemDisplayed(), true);
		Base.test.pass("Menu item is displayed as expected");
		
		//Check for Login Button
		Assert.assertEquals(bsHomePage.isLoginButtonDisplayed(), true);
		Base.test.pass("Button is displayed as expected");
		
		Base.tearDownExtentReports();
	}
	
	@AfterClass
	public void clearDown(){
		Base.closeBrowser();
	}

}
