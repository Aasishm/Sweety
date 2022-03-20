package com.bdd.Sweety.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.Sweety.utils.Constants;

public class Reports {

	WebDriver driver = null;
	
	public Reports(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigate to Reports Tab
	 */
	public void navigateToReports(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	/*
	 * Validate expected results with actual results
	 */
	@SuppressWarnings("deprecation")
	public void checkResults() {
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		for(int i = 1; i <= 4; i++) {
			String xPath = Constants.row + "[" + i + "]" + Constants.col + "[3]";
			int level = Integer.parseInt(driver.findElement(By.xpath(xPath)).getText());
			sum += level;
			min = Math.min(min, level);
			max = Math.max(max, level);
		}
		int avg = sum/4;
		String xPathMin = Constants.row + "[1]" + Constants.col + "[4]";
		String xPathMax = Constants.row + "[1]" + Constants.col + "[5]";
		String xPathAvg = Constants.row + "[1]" + Constants.col + "[6]";
		int actualMin = Integer.parseInt(driver.findElement(By.xpath(xPathMin)).getText());
		int actualMax = Integer.parseInt(driver.findElement(By.xpath(xPathMax)).getText());
		int actualAvg = Integer.parseInt(driver.findElement(By.xpath(xPathAvg)).getText());
		Assert.assertTrue(min == actualMin, "Actual and Expected Minimum Values do not match");
		Assert.assertTrue(max == actualMax, "Actual and Expected Maximum Values do not match");
		Assert.assertTrue(avg == actualAvg, "Actual and Expected Average Values do not match");
	}
}
