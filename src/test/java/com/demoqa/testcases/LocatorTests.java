package com.demoqa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorTests {
	String sUrl = "https://demoqa.com/";
	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void goToHomePage() {
		driver.get(sUrl);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void canGoToBookApplication() {
		//If I am on the home page
		String actualResult1 = driver.getTitle();
		Assert.assertEquals("DEMOQA", actualResult1);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//I can navigate to the book
		WebElement wBookStoreAppCard = driver.findElement(By.cssSelector(".home-body > div > div:nth-child(6)"));
		wBookStoreAppCard.click();
		Assert.assertEquals("DEMOQA",driver.getTitle());
		
		String strCss = "#app > div > div > div > div:nth-child(1) > div > div > div:nth-child(6) > span > div > div.header-text";
		WebElement wBookStoreAppCardMenuItem = driver.findElement(By.cssSelector(strCss));
		Assert.assertEquals("Book Store Application", wBookStoreAppCardMenuItem.getText());
		
		WebElement wLoginButton = driver.findElement(By.id("login"));
		Assert.assertEquals(true, wLoginButton.isDisplayed());
		
	}
}
