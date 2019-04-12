package com.qvision.ejerciciofinalautomatizacion.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/lookfor.feature",
		glue = "com.qvision.ejerciciofinalautomatizacion.stepdefinitions",
		snippets = SnippetType.CAMELCASE)



public class LookForRunner {

	

}
