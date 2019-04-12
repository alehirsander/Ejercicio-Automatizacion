package com.qvision.ejerciciofinalautomatizacion.steps;

import com.qvision.ejerciciofinalautomatizacion.pages.FiltersPage;
import com.qvision.ejerciciofinalautomatizacion.pages.LookForPage;
import com.qvision.ejerciciofinalautomatizacion.pages.WriteFile;

import net.thucydides.core.annotations.Step;

public class LookForStep {
	LookForPage pageLookFor;
	FiltersPage pageFilters;
	WriteFile fileWrite;
	@Step
	public void openUrl() {
		pageLookFor.open();
	}
	@Step
	public void lookFor(String skill,String city) {
		pageLookFor.lookFor(skill, city);
		
	}
	@Step
	public void filterByWages(String dateRange,String workArea) {
		pageFilters.filterByWages(dateRange,workArea);
		
	}
	@Step
	public void saveFileWithJobOffersGenerated(){
		pageFilters.saveFileWithJobOffersGenerated();
	}
	@Step
	public void takeSaveScreenshot() {
		fileWrite.saveScreenshot();
	}
	
	
}
