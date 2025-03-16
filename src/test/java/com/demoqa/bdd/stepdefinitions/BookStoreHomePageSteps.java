package com.demoqa.bdd.stepdefinitions;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;

import com.demoqa.pages.BookStoreHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@Listeners(com.demoqa.utils.TestListener.class)
public class BookStoreHomePageSteps {
	
	BookStoreHomePage bsHomePage = new BookStoreHomePage();
	
	@Given("I am on the demoqa homepage")
	public void i_am_on_the_demoqa_homepage() {
		AssertJUnit.assertEquals(bsHomePage.getWindowTitle(), "DEMOQA");
	}

	@When("I click on the Book Store App Card")
	public void i_click_on_the_book_store_app_card() {
		bsHomePage.clickBookStoreCard();
	}

	@Then("I am taken to the Book Store App Home Page")
	public void i_am_taken_to_the_book_store_app_home_page() {
		AssertJUnit.assertEquals(bsHomePage.isBookStoreAppMenuItemDisplayed(), true);
	}

	@Then("The Login button is displayed")
	public void the_login_button_is_displayed() {
		AssertJUnit.assertEquals(bsHomePage.isLoginButtonDisplayed(), true);
	}


}
