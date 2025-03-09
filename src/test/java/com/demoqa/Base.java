package com.demoqa;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.demoqa.utils.PropertiesHandler;

/*
 * 	Purpose: - Initialisation of major functionality used by all test cases
 * 
 *	WebDriver - Done
 * 	Test Properties - Done
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

    private static final Logger logger = LogManager.getLogger(Base.class);
	
    
    
	public static WebDriver getDriver() {

		try {

			switch (PropertiesHandler.getConfig("browserType")) {
			case "chrome":
				driver = new ChromeDriver();
				logInfoMessage("Chrome Driver is selected.");
				break;

			case "firefox":
				driver = new FirefoxDriver();
				logInfoMessage("Firefox Driver is selected.");
				break;

			case "internetexplorer":
				driver = new InternetExplorerDriver();
				logInfoMessage("Internet Explorer Driver is selected.");
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				logInfoMessage("Internet Explorer Driver is selected.");
				break;
			case "edge":
				driver = new EdgeDriver();
				logInfoMessage("Edge Driver is selected.");
				break;
			default:
				driver = new ChromeDriver();
				logInfoMessage("By default, Chrome Driver is selected");
				break;
			}

		} catch (Exception ex) {
			logErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());
		}

		// Maximise Window
		driver.manage().window().maximize();
		
		// Navigate to Application under test
		goToApplicationUnderTest();
		
		return driver;
	}

	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
			driver = null;
			logInfoMessage("Closing Browser!!!");
		}
	}

	public static void goToApplicationUnderTest() {
		try {
			Thread.sleep(Duration.ofSeconds(2));
			String sUrl = PropertiesHandler.getConfig("applicationUnderTest");
			driver.get(sUrl);
			logInfoMessage("Navigating to: - "+sUrl);
		} catch (Exception ex) {
			logErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());
		}
	}

	public static String getCurrentDateAndTime() {
		LocalDate myDateNow = LocalDate.now();
		LocalTime myTimeNow = LocalTime.now();
		return myTimeNow.getHour()+":"+myTimeNow.getMinute()+":"+myTimeNow.getSecond()
		+" on "+myDateNow.getDayOfMonth()+"/"+myDateNow.getMonth()+"/"+myDateNow.getYear()+":- ";
	}
	
	public static void logInfoMessage(String message) {
		logger.info(getCurrentDateAndTime()+message);
	}
	
	public static void logErrorMessage(String message) {
		logger.error(getCurrentDateAndTime()+message);
	}
	
	public static void logDebugMessage(String message) {
		logger.debug(getCurrentDateAndTime()+message);
	}
}
