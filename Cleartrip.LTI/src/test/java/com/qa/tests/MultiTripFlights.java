//Prepared by Pratiksha
package com.qa.tests;
import java.io.IOException;
import java.sql.DriverAction;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Flightspages;
import com.qa.utilities.ExcelUtilities;


public class MultiTripFlights extends Testbase{
	Flightspages FlightsObj;
	@BeforeMethod
	public void objectInitialization() {
		FlightsObj=new Flightspages(Driver);
	}

//search in multitrip for valid inputs and still the search result is not displayed!!!!! DEFECT
@Test(priority=1,dataProvider="datasetforsearch")
public void searchFlightsMultiTrip(String from1,String to1) throws IOException, InterruptedException {
	SoftAssert sassert=new SoftAssert();
	FlightsObj.selectMultiCity();
	FlightsObj.setFromLocation1(from1);
	FlightsObj.setToLocation1(to1);
	Driver.findElement(By.xpath("//tbody/tr[5]/td[4]/a[1]")).click();
	FlightsObj.clickSearchFlights();	
	if(Driver.getCurrentUrl().contains("results")) {
		Assert.assertTrue(Driver.getCurrentUrl().contains("results"));
	}
	else {
		sassert.assertTrue(Driver.getCurrentUrl().contains("results"));
		getScreenShot(Driver,"searchFlightsMultiTrip");
	}
	sassert.assertAll();
}

@DataProvider
public Object[][] datasetforsearch() throws InterruptedException{
	Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\FlightsExcel.xlsx" ,"multitripsearch");
	return data;
		
}


public static Object[][] testData(String FilePath, String SheetName) throws InterruptedException{
	
	ExcelUtilities EUtil = new ExcelUtilities(FilePath, SheetName);
	int rowCount = EUtil.getRowCount();
	int colCount = EUtil.getColCount();
	Object data[][] = new Object[rowCount-1][colCount];
	
	for(int i=1; i<rowCount ; i++) {
		for(int j=0 ; j<colCount ; j++) {
			
			String cellData = EUtil.getCellData(i, j);
			
			data[i-1][j] = cellData;
		}
	}
	
	
	return data;
	
}
}
