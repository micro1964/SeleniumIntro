package com.demoqa.bdd.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demoqa.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends Base{

    @BeforeAll
    public static void setup() {
        System.out.println("Before All: Test execution started.");
        // ExtentCucumberAdapter will automatically create reports
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            byte[] screenshotBytes = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
            //scenario.embed(screenshotBytes,"image/png");
            scenario.attach(screenshotBytes, "image/png", "img_"+getCurrentDateAndTime()+".png");
            if(Base.driver!=null) {
            	Base.driver.quit();
            }
        }
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All: Test execution completed.");
        // ExtentCucumberAdapter automatically flushes the report
        if(Base.driver!=null) {
        	Base.driver.quit();
        }
    }
    
}
