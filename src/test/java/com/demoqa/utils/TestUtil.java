package com.demoqa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demoqa.Base;

public class TestUtil extends Base {
	
	public static String captureScreenshot() {
		String sFilename="";
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			sFilename = PropertiesHandler.getScreenshotFilename();
			FileUtils.copyFile(scrnshot, new File(sFilename));
			
			logInfoMessage("Screenshot taken");
		} catch (IOException e) {
			logErrorMessage(e.getMessage());
		}
		return sFilename;
	}

}
