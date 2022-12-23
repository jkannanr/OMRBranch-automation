package com.stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import baseClass.BaseClassCucumber;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClassCucumber {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWait();
	}
    
	@After
	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {

			scenario.attach(screenshot(), "images/png", "Every Scenario");
		}
		quitWindow();

	}

}
