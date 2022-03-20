package com.bdd.Sweety.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/*
 * Runner implementation class for Cucumber
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/com/bdd/Sweety/features", glue={"com.bdd.Sweety.stepDefinitions"})
public class SweetyRunner {
	
}
