package com.demoqa.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.demoqa.Base;

public class BookStoreHomePage extends Base{
	
	@FindBy(css = ".home-body > div > div:nth-child(6)") WebElement wBookStoreCard;
	@FindBy(css = "#app > div > div > div > div:nth-child(1) > div > div > div:nth-child(6) > span > div > div.header-text") WebElement wBookStoreAppMenuItem;
	@FindBy(xpath = "//*[@id=\"login\"]") WebElement wLoginButton;
	
	WebDriver driver;
	
	public BookStoreHomePage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
		logDebugMessage("PageFactory initialised on BookStore Home Page.");
	}

	public void clickBookStoreCard() {
		scrollPageDown();
		wBookStoreCard.click();
		logInfoMessage("BookStoreCard clicked.");
	}
	
	//Scrolls down till the bottom of the page
	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		logInfoMessage("Pressing the Scroll Down button...");
	}
	
	public String getWindowTitle() {
		logInfoMessage("Retrieving the browser title");
		return driver.getTitle();
	}
	
	public boolean isBookStoreAppMenuItemDisplayed() {
		logInfoMessage("Checking if BookStoreAppMenuItem is displayed.");
		return wBookStoreAppMenuItem.isDisplayed();
	}
	
	public boolean isLoginButtonDisplayed() {
		waitForElementToBeVisible(wLoginButton,7,1);
		logInfoMessage("Checking if Login Button is displayed.");
		return wLoginButton.isDisplayed();
	}
	
	public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds, int pollingInMillis) {
		logInfoMessage("Waiting for WebElement "+element.getAccessibleName());
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))  // Maximum wait time
                .pollingEvery(Duration.ofMillis(pollingInMillis))   // Polling interval
                .ignoring(NoSuchElementException.class);           // Ignore NoSuchElementException
        
        wait.until(driver -> element.isDisplayed());
    }
}
