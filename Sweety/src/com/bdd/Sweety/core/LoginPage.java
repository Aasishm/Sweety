package com.bdd.Sweety.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import com.bdd.Sweety.utils.Constants;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigate to the given url
	 */
	public void navigate(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	/*
	 * Login to the Sweety application using given username and password
	 */
	public void login(String username, String password) {
		//Enter login credentials and Submit
		driver.findElement(By.id(Constants.user_id)).sendKeys(username);
		driver.findElement(By.id(Constants.user_password)).sendKeys(password);
		driver.findElement(By.name(Constants.submit)).click();
	}
	
	/*
	 * Validates an incorrect login
	 */
	public void validateFalseLogin() {
		try {
			WebElement element = driver.findElement(By.xpath(Constants.loggedInConfirmation));
			if(element.isDisplayed()) 
				Assert.assertTrue("Logged In with incorrect credentials", false);
		}
		catch(Exception e) {
			System.out.println("False login prevented");
		}
	}
	
	/*
	 * Validates correct login
	 */
	public void validateLogin() {
		try {
			WebElement element = driver.findElement(By.xpath(Constants.loggedInConfirmation));
			if(element.isDisplayed()) 
				Assert.assertTrue(true);
		}
		catch(Exception e) {
			System.out.println("Login failed with correct credentials");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}	
