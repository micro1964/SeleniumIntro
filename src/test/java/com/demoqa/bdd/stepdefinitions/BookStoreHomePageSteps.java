package com.demoqa.bdd.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

import com.demoqa.pages.BookStoreHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


//@Listeners(com.demoqa.utils.BddTestListener.class)
public class BookStoreHomePageSteps {
	private static final Logger logger = LogManager.getLogger(BookStoreHomePageSteps.class);
	
	BookStoreHomePage bsHomePage = new BookStoreHomePage();
	
	@Given("I am on the demoqa homepage")
	public void i_am_on_the_demoqa_homepage() {
		softAssertEquals(bsHomePage.getWindowTitle(), "DEMOQA","Is the browser title as expected");
	}

	@When("I click on the Book Store App Card")
	public void i_click_on_the_book_store_app_card() {
		bsHomePage.clickBookStoreCard();
	}

	@Then("I am taken to the Book Store App Home Page")
	public void i_am_taken_to_the_book_store_app_home_page() {
		softAssertEquals(bsHomePage.isBookStoreAppMenuItemDisplayed(), true,"Is the Book Store App Menu Item Displayed");
	}

	@Then("The Login button is displayed")
	public void the_login_button_is_displayed() {
		softAssertEquals(bsHomePage.isLoginButtonDisplayed(), false,"Is the Login Button Displayed");
	
		BookStoreHomePage.closeBrowser();
	}

	@AfterClass
	public void clearUp() {
		BookStoreHomePage.closeBrowser();
	}
	
	
	private void softAssertEquals(boolean bActual, boolean bExpected, String sMessage) {
		try {
			AssertJUnit.assertEquals(bActual,bExpected);
			logger.info(sMessage+": "+true);
			}
		catch(Exception ex) {
			logger.info(sMessage+": "+false);
			ex.getMessage();
			}
		}
	
	private void softAssertEquals(String bActual, String bExpected, String sMessage) {
		try {
			AssertJUnit.assertEquals(bActual,bExpected);
			logger.info(sMessage+": "+true);
			}
		catch(Exception ex) {
			logger.info(sMessage+": "+false);
			ex.getMessage();
			}
		}
}
