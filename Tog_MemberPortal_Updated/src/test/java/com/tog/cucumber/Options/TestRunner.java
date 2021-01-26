package com.tog.cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\tog\\features\\", plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/jsonReports/cucumber-report.json", }, glue = {
				"com/tog/steps" }, monochrome = true  , tags = { "@Getbuilding" })
public class TestRunner {

}
