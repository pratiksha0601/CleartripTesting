//Prepared by Pratiksha

package com.qa.tests;
import java.io.IOException;
import java.sql.DriverAction;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qa.pages.Flightspages;
import com.qa.utilities.ExcelUtilities;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FlightOneway extends Testbase{
	Flightspages FlightsObj;
//for valid data in one way......
	@BeforeMethod
	public void objectInitialization() {
		FlightsObj=new Flightspages(Driver);
	}
@Test(priority=2,dataProvider="datasetforbook")
public void bookFlightsoneway(String fromplace,String toplace,String date,String classoftravel,String phone,String email,String firstname,String lastname,String gender,String nationality) throws InterruptedException, IOException {
	SoftAssert sassert=new SoftAssert();
	WebDriverWait wait=new WebDriverWait(Driver,30);
	//wait.until(ExpectedConditions.alertIsPresent());
	//Driver.switchTo().alert().dismiss();
try {	
	logger.info("I am testing the booking feature of one way of the website!!!!.These are for valid input.");
	FlightsObj.selectOneWay();
	
	FlightsObj.setFromLocation(fromplace);
	
	FlightsObj.setToLocation(toplace);
	FlightsObj.setDepartDate(date);
	FlightsObj.setMoreOptions();
	FlightsObj.setClassOfTravel(classoftravel);
	FlightsObj.clickSearchFlights();
	FlightsObj.clickBookButton();
	FlightsObj.clickContinueafterfare();
	FlightsObj.selectFare();
	FlightsObj.setMobile(phone);
	FlightsObj.setEmail(email);
	Thread.sleep(5000);
	FlightsObj.clickContinueafterdetails();
	FlightsObj.setFirstName(firstname);
	FlightsObj.setLastName(lastname);
	FlightsObj.setGender(gender);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Nationality (e.g. India)'])")));
	FlightsObj.setNationality(nationality);
	FlightsObj.clickContinueToPayment();	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Make Payment']")));
	if(Driver.getCurrentUrl().contains("pay")) {
		//getScreenShot(Driver,"bookFlightsoneway");
		Assert.assertTrue(true);
	}
	else {
		sassert.assertTrue(false);
		getScreenShot(Driver,"bookFlightsoneway");
	}}
catch(Exception e) {
	FlightsObj.clickContinueToPayment();	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Make Payment']")));
	if(Driver.getCurrentUrl().contains("pay")) {
		//getScreenShot(Driver,"bookFlightsoneway");
		Assert.assertTrue(true);
	}
	else {
		sassert.assertTrue(false);
		getScreenShot(Driver,"bookFlightsoneway");
}}
	sassert.assertAll();
}	
//check for all the invalid data sets where error message should be displayed!!!!!!   1.already past date    2.same to and from
@Test(priority=1,dataProvider="datasetforsearch")   
public void searchFlightsoneway(String fromplace,String toplace,String date,String classoftravel) throws InterruptedException, IOException {
	SoftAssert sassert=new SoftAssert();
	logger.info("I am testing the searching feature of one way of the website!!!!.These are for invalid input.");
FlightsObj.selectOneWay();
FlightsObj.setFromLocation(fromplace);
FlightsObj.setToLocation(toplace);
FlightsObj.setDepartDate(date);
FlightsObj.setMoreOptions();
FlightsObj.setClassOfTravel(classoftravel);
FlightsObj.clickSearchFlights();
try {
if((FlightsObj.getErrormsg()).isDisplayed())
{
	Reporter.log(FlightsObj.getErrormsg().getText(), true);
	sassert.assertTrue(true);
	Driver.navigate().refresh();
}}
catch(NoSuchElementException e) {
	Reporter.log("A list of flights is displayed for invalid data!!", true);
	sassert.assertTrue(false);
	getScreenShot(Driver,"searchFlightsoneway");
	Driver.navigate().back();
	Thread.sleep(5000);
}
sassert.assertAll();
}


@DataProvider
public Object[][] datasetforsearch() throws InterruptedException{
	Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\FlightsExcel.xlsx" ,"onewayinvalidsearch");
	return data;
		
}
@DataProvider
public Object[][] datasetforbook() throws InterruptedException{
	Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\FlightsExcel.xlsx" ,"onewayvalidbook");
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




