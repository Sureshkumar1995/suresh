package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * @author Suresh Kumar G
 * @Description Test runner class which run all Feature files based on tags and
 *              scenarios present on Feature file
 * @CreationDate 27/06/2022
 */

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, plugin = { "pretty",
		"json:target/cucumber.json" }, monochrome = true, dryRun = false, strict = true, features = "src/test/resources", glue = "com.stepdefinition")

public class TestRunnerClass {
	/**
	 * @Description To generate JVM report after the execution of all scenarios in
	 *              Feature file
	 * @CreationDate 27/06/2022
	 */
	@AfterClass
	public static void afterClass() {

		Reporting.generateJVMReport(System.getProperty("user.dir") + "/target/cucumber.json");

	}

}
