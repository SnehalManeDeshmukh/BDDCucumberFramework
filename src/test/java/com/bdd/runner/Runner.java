package com.bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/", glue = "com.bdd.Steps", tags = "@loginTests", 
plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
@RunWith(Cucumber.class)

public class Runner {
	
}
