package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	@Before
	public void beforeScenrio() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximizewindow();
		implicitWait(10);

	}

	@After
	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshotAs, scenario.getName(),".png");
			close();
			
		}

		close();
	}

}
