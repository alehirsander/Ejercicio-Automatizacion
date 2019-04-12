package com.qvision.ejerciciofinalautomatizacion.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qvision.ejerciciofinalautomatizacion.steps.LookForStep;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LookForStepDefinitions {
	
	@Steps
	LookForStep stepLookFor;

	

	@Given("^That I am in the look for employ page$")
	public void thatIAmInTheLookForPage() {
		stepLookFor.openUrl();
	}
	@And("^I into by skill and city$")
	public void iTypeTheData(DataTable arg1) {
	    List<Map<String, String>> listData = arg1.asMaps(String.class, String.class);
	    String skill = listData.get(0).get("skill");
	    String city = listData.get(0).get("city");
	    stepLookFor.lookFor(skill, city);
	}

	@When("^I filter by wages$")
	public void iFilterByWages(DataTable arg2) {
		   List<Map<String, String>> listData = arg2.asMaps(String.class, String.class);
		    String dateRange = listData.get(0).get("dateRange");
		    String workArea = listData.get(0).get("workArea");
		stepLookFor.filterByWages(dateRange,workArea);
	}
	

	@Then("^I save the job offers into a file$")
	public void iSaveTheJobOffersIntoAFile() {
	    stepLookFor.saveFileWithJobOffersGenerated();
	    //Assert.assertFalse(stepLookFor.validarSubtitle());
	}
	@And("^I take Screenshot$")
	public void iTakeScreenshot() {
		stepLookFor.takeSaveScreenshot();
	}
	

}
