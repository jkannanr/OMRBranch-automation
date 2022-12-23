package com.runnerClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import baseClass.BaseClassCucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags =" ", publish = true, snippets = SnippetType.CAMELCASE, dryRun = false, monochrome = true,
plugin= {"pretty", "json:target\\Output.json" }, stepNotifications = true, features = "src\\test\\resources", glue = "com.stepDefinition")
public class RunnerClass extends BaseClassCucumber {
	
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
	
//		call JVM report Generation
		Reporting.generateJvmReport(getProjectPath()+getPropertyFileValue("json"));

	}

}
