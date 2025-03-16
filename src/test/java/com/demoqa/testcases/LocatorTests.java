package com.demoqa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoqa.Base;

@Listeners(com.demoqa.utils.TestListener.class)
public class LocatorTests {
	String sUrl = "https://demoqa.com/";
	WebDriver driver = Base.getDriver();
	
	@BeforeTest
	public void goToHomePage() {
		driver.get(sUrl);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser() {
		//Base.closeBrowser();
	}

	@Test
	public void canGoToBookApplication() {
		//If I am on the home page
		String actualResult1 = driver.getTitle();
		AssertJUnit.assertEquals("DEMOQA", actualResult1);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//I can navigate to the book
		WebElement wBookStoreAppCard = driver.findElement(By.cssSelector(".home-body > div > div:nth-child(6)"));
		wBookStoreAppCard.click();
		AssertJUnit.assertEquals("DEMOQA",driver.getTitle());
		
		String strCss = "#app > div > div > div > div:nth-child(1) > div > div > div:nth-child(6) > span > div > div.header-text";
		WebElement wBookStoreAppCardMenuItem = driver.findElement(By.cssSelector(strCss));
		AssertJUnit.assertEquals("Book Store Application", wBookStoreAppCardMenuItem.getText());
		
		WebElement wLoginButton = driver.findElement(By.id("login"));
		AssertJUnit.assertEquals(true, wLoginButton.isDisplayed());
		
		driver.quit();
	}
}
