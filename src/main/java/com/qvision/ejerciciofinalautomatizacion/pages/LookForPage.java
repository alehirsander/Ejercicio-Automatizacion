package com.qvision.ejerciciofinalautomatizacion.pages;

import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.elempleo.com/co/")
public class LookForPage extends PageObject {
	
	@FindBy(xpath="//input[contains(@class, 'form-control input-lg js-searchbox-input tt-input')]")
	WebElement txtSkill;
	//@FindBy(xpath="//input[contains(@class, 'js-searchbox')]//following::div[contains(@class, 'tt-suggestion tt-selectable')]")
	@FindBy(xpath="//div[contains(@class, 'tt-suggestion tt-selectable')]")
	List<WebElementFacade> txtListSkill;
		
	@FindBy(xpath="//input[contains(@class, 'form-control input-lg js-cities-searchbox ciudad-ux tt-input')]")
	WebElement txtCity;
	@FindBy(xpath="//input[contains(@class, 'js-cities')]//following::div[contains(@class, 'tt-suggestion tt-selectable')]")
	List<WebElementFacade> txtListCity;
	@FindBy(xpath="//h1")
	WebElement lblTitlePage;
	
//WebDriver miDriver= getDriver();
		

	public void lookFor(String skill, String city) {
		WebDriver miDriver= getDriver();
		JavascriptExecutor ejecutar= (JavascriptExecutor) miDriver;
		ejecutar.executeScript("window.scrollBy(0,300)");
		
	    txtSkill.sendKeys(skill.substring(0, 4));
	    for (WebElement listSkill: txtListSkill) {
			if (listSkill.getText().contains(skill)) {
				listSkill.click();
				break;
			}
		}
	    
		txtCity.sendKeys(city);
		
		for (WebElement E: txtListCity) {
			if (E.getText().contains(city)) {
				E.click();
				break;
			}
		}
	}
		
		
	
}
