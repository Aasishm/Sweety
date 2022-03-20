package com.bdd.Sweety.core;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bdd.Sweety.utils.Constants;

public class LevelEntry {

	WebDriver driver = null;
	
	public LevelEntry(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToLevels(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	@SuppressWarnings("deprecation")
	public void enterLevel(String level) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Constants.addNew)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.id(Constants.level_id)).sendKeys(level);
		driver.findElement(By.name(Constants.submit)).click();
	}
	
	public void validateMultipleEntries() {
		try {
			WebElement element = driver.findElement(By.xpath(Constants.limitReached));
			if(element.isDisplayed()) 
				Assert.assertTrue(true);
		}
		catch(Exception e) {
			Assert.assertTrue("More than 4 entries present", false);
			System.out.println("ERROR: Entries more than 4 times are permitted.");
		}
	}
	
}
