package com.demoqa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoqa.Base;
import com.demoqa.pages.BookStoreHomePage;

@Listeners(com.demoqa.utils.TestListener.class)
public class BookStoreHomeTest {
	
	BookStoreHomePage bsHomePage = new BookStoreHomePage();

	@Test (priority=1)
	public void canNavigateToBookStoreHomePage() {
		bsHomePage.clickBookStoreCard();
		Assert.assertEquals(bsHomePage.getWindowTitle(), "DEMOQA");
		}
	
	@Test (priority=2)
	public void bookStoreAppMenuItemIsDisplayed() {
		Assert.assertEquals(bsHomePage.isBookStoreAppMenuItemDisplayed(), true);
		}
	
	@Test (priority=3)
	public void loginButtonIsDisplayed() {
		Assert.assertEquals(bsHomePage.isLoginButtonDisplayed(), true);
		}
		
	@Test (priority=4)
	public void intentionalFailingTest() {
		assertTrue(false);
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
