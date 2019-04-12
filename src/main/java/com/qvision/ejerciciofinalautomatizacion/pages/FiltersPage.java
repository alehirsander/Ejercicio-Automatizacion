package com.qvision.ejerciciofinalautomatizacion.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.qvision.ejerciciofinalautomatizacion.pages.WriteFile;
import net.serenitybdd.core.pages.PageObject;
 


public class FiltersPage extends PageObject {
	
	LookForPage pageLookForPage;
	WriteFile fileWrite;

	JavaScriptExecutor ejecutor1;
	@FindBy(xpath = "/html/body/div[8]/div[2]/h1")
	WebElement lblSubTitle;
	//@FindBy(xpath = "//div[contains(@class, 'js-filter-salary')]/div")
	@FindBy(xpath ="div[contains(@class, 'checkbox')]/label")
	List<WebElement> txtListaSalarios;
	@FindBy(id="salary3")
	WebElement cheSalary;
	
	@FindBy(xpath="//*[@id=\"WorkAreaFilter1\"]")
	WebElement txtWorkArea;
	
	@FindBy(id="publishDate1")
	WebElement raDatePublication;
	

	@FindBy(xpath="//*[@id=\"WorkAreaFilter1\"]/option")
	List<WebElement> txtListEmployArea;
	
	@FindBy(xpath="//a[contains(@class, 'text-ellipsis')]")
	List<WebElement> lblListEmploy;
	@FindBy(xpath="//span[contains(@class, 'info-company-name')]")
	List<WebElement> lblListCompany;
	
	public void filterByWages() {
		
		int i = 0;
		try {
		WebDriver miDriver= getDriver();
		
		JavascriptExecutor ejecutar= (JavascriptExecutor) miDriver;
		ejecutar.executeScript("window.scrollBy(0,100)");
		cheSalary.click();
		
			Thread.sleep(5000);
		//WebDriverWait myWaitVar = new WebDriverWait(miDriver,30);
		
	ejecutar.executeScript("window.scrollBy(0,1000)");
		//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("publishDate1")));

		raDatePublication.click();
		//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"WorkAreaFilter1\"]/option")));
		Thread.sleep(5000);
		
		//raDatePublication=miDriver.findElement(By.id("publishDate1"));
		//ejecutar.executeScript("argument[0].click();", raDatePublication);
		/*for (WebElement listDate:listRaPublishDate ) {
			System.out.println("ListaDe fechas:"+listDate.getText());
			System.out.println("ListaDe fechas:"+listDate.getAttribute("value"));
			
			if (listDate.getText().contains("Hace 1 semana")) {
				listDate.click();
				break;
			}
		}*/
		//Capturar la lista de empleo
		ejecutar.executeScript("window.scrollBy(0,500)");
	for (WebElement listArea:txtListEmployArea ) {
		System.out.println("Valor de la lista de arear de trabajo:"+listArea.getText());
		
		if (listArea.getText().contains("Administrativa y Financiera")) {
			listArea.click();
			break;
		}
	}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveFileWithJobOffersGenerated() {
		int i;
		String[] arrayListJob = new String[lblListEmploy.size()+1];
		arrayListJob[0]="Job Offers,Companys";
		for(i=1; i<lblListEmploy.size();i++) {
			arrayListJob[i]=lblListEmploy.get(i-1).getAttribute("title") +","+ lblListCompany.get(i-1).getText();
				
		}
		
		if (fileWrite.writeFileWhitJobVacancies(arrayListJob)==true){
			System.out.println("Archivo guardado correctamente");
		}else {
			System.out.println("Archivo no guardado");
		}
	}
	


	public boolean validateLabelSubTitle() {
		boolean isVisible = false;
		try {
			System.out.println(lblSubTitle.getText());
			if (lblSubTitle.getText().contains("Empleos Contador en Bogotá")) {
				isVisible = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isVisible;
	}

}
