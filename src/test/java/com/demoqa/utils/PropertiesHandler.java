package com.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesHandler {

	static Properties config = new Properties();
	public static Properties objectRepo = new Properties();

	public static String fs = System.getProperty("file.separator");
	public static String userDir = System.getProperty("user.dir");
	public static String testResources = userDir + fs + "src" + fs + "test" + fs + "resources" + fs;

	public static String configFile = testResources + "config.properties";
	public static String objectRepoFile = testResources + "objectRepositories.properties";

	public static String getConfig(String strKey) throws FileNotFoundException {
		String result="";
		FileInputStream fis = new FileInputStream(configFile);
		try {
				config.load(fis);
				result=config.getProperty(strKey);
			} catch (Exception e) {
				e.getMessage();
			}
		return result;
		}
	
	/*
	NOT Needed due to PageFactory limitation - Value must be a constant
	public static String getObjectRepo(String strKey) throws FileNotFoundException {
		String result="";
		FileInputStream fis2 = new FileInputStream(objectRepoFile);
		try {
			objectRepo.load(fis2);
		} catch (Exception e) {
			e.getMessage();
		}

		return result;
	}
	*/

}
