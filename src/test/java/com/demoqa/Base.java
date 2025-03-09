package com.demoqa;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.demoqa.utils.PropertiesHandler;

/*
 * 	Purpose: - Initialisation of major functionality used by all test cases
 * 
 *	WebDriver 
 * 	Test Properties
 * 	Logs
 * 	Reporting
 * 	DataBase
 * 	Mail
 * 	Excel
 * 
 * @Author	Reggy Williams
 */


public class Base {
	
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() throws FileNotFoundException {
		
		switch(PropertiesHandler.getConfig("browserType")) {
			case "chrome":
				driver = new  ChromeDriver();
				break;
			
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "internetexplorer":
				driver = new InternetExplorerDriver();
				break;
			default:
				driver = new  ChromeDriver();
				break;
				}
			
			driver.get(PropertiesHandler.getConfig("applicationUnderTest"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesHandler.getConfig("implicitWait")),TimeUnit.SECONDS);
		return driver;
		}

}
