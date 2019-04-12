package com.qvision.ejerciciofinalautomatizacion.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;

public class WriteFile extends PageObject {
	
	public boolean writeFileWhitJobVacancies(String[] arrayJobVacanci) {
		boolean isFileSave=false;
		File myFile = new File("jobVacancies.txt");
		
		
		  try {
		myFile.createNewFile();
		FileWriter FW = new FileWriter("jobVacancies.txt");
		BufferedWriter BW = new BufferedWriter(FW); 						
			for (int i = 0; i < arrayJobVacanci.length; i++) {
		        if (arrayJobVacanci[i] != null && !arrayJobVacanci[i].isEmpty()) {
		        	BW.write(arrayJobVacanci[i]);
		        	BW.newLine();
		        }
				
		      }
			BW.close();
			isFileSave=true;
			
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return isFileSave;
	}
	
	public void saveScreenshot() {
		WebDriver miDriver= getDriver();
		File scrFile = ((TakesScreenshot)miDriver).getScreenshotAs(OutputType.FILE); 
		// Now you can do whatever you need to do with it, for example copy somewhere 
		try {
			FileUtils.copyFile(scrFile, new File("PantallaEmpleoCom.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
