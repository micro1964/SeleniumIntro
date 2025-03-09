package com.demoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.demoqa.Base;
import com.demoqa.pages.BookStoreHomePage;

public class BookStoreHomeTest {
	
	BookStoreHomePage bsHomePage = new BookStoreHomePage();
	
	@Test
	public void canNavigateToBookStoreHomePage() {
		
		bsHomePage.clickBookStoreCard();
		
		//Check for expected title
		Assert.assertEquals(bsHomePage.getWindowTitle(), "DEMOQA");
		
		//Check for expected menu item
		Assert.assertEquals(bsHomePage.isBookStoreAppMenuItemDisplayed(), true);
		
		//Check for Login Button
		Assert.assertEquals(bsHomePage.isLoginButtonDisplayed(), true);
	}
	
	@AfterClass
	public void clearDown(){
		Base.closeBrowser();
	}

}
