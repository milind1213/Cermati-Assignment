package com.Cermati.testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = {"src/test/java/com/Cermati/features/ProductAccess.feature"}, 
                  glue = {"com.Cermati.stepDefinitions"},
                  plugin = {"pretty","html:reports/Cucumber-Report.html",
                		    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                		    "rerun:reports/Failed-Scenarios.txt"},
                  dryRun = false,
                  monochrome = true)
public class TestNG_TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();  
	}
}	