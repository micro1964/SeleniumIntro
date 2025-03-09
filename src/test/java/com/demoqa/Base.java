package com.demoqa;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
			case "ie":
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				driver = new  ChromeDriver();
				break;
				}
		//Set Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertiesHandler.getConfig("implicitWait"))));
		
		//Navigate to Application under test
		driver.get(PropertiesHandler.getConfig("applicationUnderTest"));
		
		//Maximise Window
		driver.manage().window().maximize();
			
		return driver;
		}
	
	public static void closeBrowser() {
		if(driver!= null) {
			driver.quit();
			driver = null;
			}
		}

}
