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

public class FlightRoundtrip extends Testbase{
	Flightspages FlightsObj;
	@BeforeMethod
	public void objectInitialization() {
		FlightsObj=new Flightspages(Driver);
	}

//checking for valid data combination but presence of return date field is determined....
@Test(dataProvider="datasetforsearch")
public void searchFlightsRoundTrip(String fromplace,String toplace,String depart,String returndate,String classoftravel) throws IOException {
	SoftAssert sassert=new SoftAssert();
	FlightsObj.selectRoundTrip();
	if(FlightsObj.getReturnDate().isDisplayed()){
		Assert.assertTrue(true);
FlightsObj.setFromLocation(fromplace);
FlightsObj.setToLocation(toplace);
FlightsObj.setDepartDate(depart);
FlightsObj.setReturnDate(returndate);
FlightsObj.setMoreOptions();
FlightsObj.setClassOfTravel(classoftravel);
FlightsObj.clickSearchFlights();
try {
if((FlightsObj.getErrormsg()).isDisplayed()){
	Reporter.log(FlightsObj.getErrormsg().getText(), true);
	sassert.assertFalse(true);
	getScreenShot(Driver,"searchFlights");
	Driver.navigate().refresh();
}
}
catch(NoSuchElementException e) {
	Reporter.log("A list of flights is displayed", true);
	//Driver.navigate().back();
}




	}
	else {
		Reporter.log("Round trip functionality is not working",true);
		getScreenShot(Driver,"searchFlightsRoundTrip");
		Assert.assertTrue(FlightsObj.getReturnDate().isDisplayed());
		//Driver.navigate().back();
		
	}
}
@Test(priority=2,dependsOnMethods="searchFlightsRoundTrip")
public void bookFlightsRoundTrip() {
	/*FlightsObj.selectRoundTrip();
	FlightsObj.setFromLocation("Delhi");
	FlightsObj.setToLocation("Jaipur");
	FlightsObj.setDepartDate("23-02-2021");
	FlightsObj.setReturnDate("25-02-2021");
	FlightsObj.setMoreOptions();
	FlightsObj.setClassOfTravel("Business");
	FlightsObj.clickSearchFlights();*/
	FlightsObj.clickBookButton();
	FlightsObj.clickContinueafterfare();
	FlightsObj.setMobile("0000000000");
	FlightsObj.setEmail("abc@gmail.com");
	FlightsObj.clickContinueafterdetails();
	FlightsObj.setFirstName("Ayushi");
	FlightsObj.setLastName("Sharma");
	FlightsObj.setGender("Female");
	FlightsObj.setNationality("India");
	FlightsObj.clickContinueToPayment();
}

@DataProvider
public Object[][] datasetforsearch() throws InterruptedException{
	
	Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\FlightsExcel.xlsx" ,"roundtripsearch");
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