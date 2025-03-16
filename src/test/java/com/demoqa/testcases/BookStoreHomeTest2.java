package com.demoqa.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoqa.Base;
import com.demoqa.pages.BookStoreHomePage;

@Listeners(com.demoqa.utils.TestListener.class)
public class BookStoreHomeTest2 {
	
	BookStoreHomePage bsHomePage = new BookStoreHomePage();

	@Test (priority=1)
	public void canNavigateToBookStoreHomePage() {
		bsHomePage.clickBookStoreCard();
		AssertJUnit.assertEquals(bsHomePage.getWindowTitle(), "DEMOQA");
		}
	
	@Test (priority=2)
	public void bookStoreAppMenuItemIsDisplayed() {
		AssertJUnit.assertEquals(bsHomePage.isBookStoreAppMenuItemDisplayed(), true);
		}
	
	@Test (priority=3)
	public void loginButtonIsDisplayed() {
		AssertJUnit.assertEquals(bsHomePage.isLoginButtonDisplayed(), true);
		}
		
	@Test (priority=4)
	public void intentionalFailingTest() {
		AssertJUnit.assertTrue(false);
	}
	
	@Test (priority=5)
	public void intentionalSkippedTest() {
		System.out.println("Dummy Test");
	}
	
	@AfterClass
	public void clearDown(){
		Base.closeBrowser();
	}

}
