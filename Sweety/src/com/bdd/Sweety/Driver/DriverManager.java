package com.bdd.Sweety.Driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	public static WebDriver driver = null;

	/*
	 * Returns the WebDriver instance
	 */
	public static WebDriver getInstanceOfDriver() {
		//Get the absolute file path of chrome driver
		File file = new File("src/com/bdd/Sweety/Driver/chromedriver.exe");
		String filePath = file.getAbsolutePath();
		System.out.println("The absolute path is : " + filePath);
		
		//Set the property of driver
		System.setProperty("webdriver.chrome.driver", filePath);
		
		driver = new ChromeDriver();
		return driver;
	}
	
}
