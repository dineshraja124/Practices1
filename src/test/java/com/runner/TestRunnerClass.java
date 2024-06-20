package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@login", dryRun = false,publish=true,stepNotifications=false,plugin = { "pretty",
		"json:target/output.json" },monochrome = true, features = "src\\test\\resources", glue = "com.stepdefinition")

public class TestRunnerClass extends BaseClass {

	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {

		Reporting.generateJvmReport(getPropertyPath() + getPropertyFileValue("jsonpath"));
	}

}
