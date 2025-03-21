package com.demoqa.runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




/*
@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/com/demoqa/bdd/featurefiles/"},
glue= {"com.demoqa.bdd.stepdefinitions"},
plugin = {"pretty"},
monochrome = true)
*/

@CucumberOptions(features= {"src/test/java/com/demoqa/bdd/featurefiles/"},
glue= {"com.demoqa.bdd.stepdefinitions"},
plugin = {"html:target/cucumber-reports/cucumber-html-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CukeTest extends AbstractTestNGCucumberTests{

}
