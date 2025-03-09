package com.qa.tutorials.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProofOfConcept {

	public static void main(String[] args) {
		
		//Get the webdriver instance driver for chrome
		WebDriver driver = new ChromeDriver();
		
		//Navigate to google.com
		driver.get("https:\\google.com");
		
		//Maximise window
		driver.manage().window().maximize();
		
		//Print out the title
		System.out.println("The Browser title is: "+driver.getTitle());
		
		if(driver.findElement(By.id("W0wltc")).isDisplayed()) {
			driver.findElement(By.id("W0wltc")).click();
			}
		
		// Locate the Google logo using XPath
        WebElement googleLogo = driver.findElement(By.xpath("//img[@alt='Google']"));

        // Print the src attribute of the Google logo
        //System.out.println("Google Logo Src: " + googleLogo.getAttribute("src"));
        
        // Get the src attribute using getDomAttribute()
        String logoSrc = googleLogo.getDomAttribute("src");
		System.out.println(logoSrc);
		
		driver.quit();
	}

}
