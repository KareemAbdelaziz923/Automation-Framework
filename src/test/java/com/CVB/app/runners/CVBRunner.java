package com.CVB.app.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/resources/features/CVB_Login/Employee.feature"},
		plugin = { "pretty" },
		glue = {"com.CVB.app"},
		tags = "@SmokeTest1",	
		dryRun = false)
public class CVBRunner {
}