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
	}

	public void clickBookStoreCard() {
		scrollPageDown();
		wBookStoreCard.click();
	}
	
	//Scrolls down till the bottom of the page
	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public String getWindowTitle() {
		return driver.getTitle();
	}
	
	public boolean isBookStoreAppMenuItemDisplayed() {
		return wBookStoreAppMenuItem.isDisplayed();
	}
	
	public boolean isLoginButtonDisplayed() {
		waitForElementToBeVisible(wLoginButton,5,1);
		return wLoginButton.isDisplayed();
	}
	
	public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds, int pollingInMillis) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))  // Maximum wait time
                .pollingEvery(Duration.ofMillis(pollingInMillis))   // Polling interval
                .ignoring(NoSuchElementException.class);           // Ignore NoSuchElementException
        
        wait.until(driver -> element.isDisplayed());
    }
}
