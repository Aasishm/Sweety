package com.bdd.Sweety.stepDefinitions;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.Sweety.Driver.DriverManager;
import com.bdd.Sweety.core.LevelEntry;
import com.bdd.Sweety.core.LoginPage;
import com.bdd.Sweety.core.Reports;
import com.bdd.Sweety.utils.Constants;

import io.cucumber.java.en.*;

public class StepDefinitions {

	WebDriver driver = null;
	LoginPage loginPage;
	LevelEntry levelEntry;
	Reports reports;
	Random rand;
	
	/*
	 * Constructor for initializing all pages of Sweety
	 */
	public StepDefinitions() {
		driver = DriverManager.getInstanceOfDriver();
		loginPage = new LoginPage(driver);
		levelEntry = new LevelEntry(driver);
		reports = new Reports(driver);
		rand = new Random();
	}
	
	/*
	 * Login to Sweety Application with incorrect password
	 */
	@Given("User logs into the application with incorrect password")
	public void loginWrongPassword() {
		loginPage.navigate(Constants.url);
		loginPage.login(Constants.username, Constants.wrong_password);
		loginPage.validateFalseLogin();
	}

	/*
	 * Login to Sweety Application with incorrect username
	 */
	@Then("User logs into the application with incorrect username")
	public void loginWrongUser() {
		loginPage.navigate(Constants.url);
		loginPage.login(Constants.wrong_user, Constants.password);
		loginPage.validateFalseLogin();
	}
	
	/*
	 * Login to Sweety Application correct credentials
	 */
	@Given("User logs into the application with correct credentials")
	public void loginCorrect() {
		loginPage.navigate(Constants.url);
		loginPage.login(Constants.username, Constants.password);
	}
	
	/*
	 * Close the Browser
	 */
	@Then("Close the browser")
	public void closeBrowser() {
		driver.close();
	}
	
	/*
	 * Navigate to the required tab
	 */
	@Then("User navigates to {string} Tab")
	public void navigateToTab(String tab) {
		if(tab.equals("Levels")) levelEntry.navigateToLevels(Constants.levels);
		else reports.navigateToReports(Constants.reports);
	}
	
	/*
	 * Enter glucose levels
	 */
	@Then("User enters {string} value for glucose level")
	public void enterGlucoseLevels(String level) {
		if(level.equals("blank")) levelEntry.enterLevel("");
		else if(level.equals("negative")) levelEntry.enterLevel(Constants.negative);
		else if(level.equals("zero")) levelEntry.enterLevel(Constants.zero);
		else levelEntry.enterLevel(rand.nextInt(250) + 1 + "");
	}
	
	/*
	 * Enter glucose levels four more times
	 */
	@Then("User enters values more than 4 times")
	public void enterLevelsMultipleTimes() {
		levelEntry.enterLevel(rand.nextInt(250) + 1 + "");
		levelEntry.enterLevel(rand.nextInt(250) + 1 + "");
		levelEntry.enterLevel(rand.nextInt(250) + 1 + "");
		levelEntry.enterLevel(rand.nextInt(250) + 1 + "");
		levelEntry.validateMultipleEntries();
	}
	
	@Then("Check if daily report data values match with expected values")
	public void verifyDailyReportData() {
		reports.checkResults();
	}
	
}
