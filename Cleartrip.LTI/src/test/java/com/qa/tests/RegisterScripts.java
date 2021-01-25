package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.SignInandRegisterPages;
import com.qa.utilities.ExcelUtilities;

public class RegisterScripts extends Testbase {
	SignInandRegisterPages page;	
	SoftAssert sassert;
	 
	@BeforeMethod
	public void setUp() {
		
		sassert =new SoftAssert();
		page = new SignInandRegisterPages(Driver);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		page = new SignInandRegisterPages(Driver);
		
		if(!Driver.getCurrentUrl().equals(baseURL))
			Driver.navigate().to(baseURL);
		
		try {
			page.clickYourTripsButton();
			page.clickSignOutButton();
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
		
	}
	
	
	
	
	
	@Test(priority=1,dataProvider="testData")
	public void signUpWithClearTrip(String userName,String password,String title,String firstName,String lastName,String countryCode,String phoneNumber) throws InterruptedException, IOException {//cleartrip condition
		logger.info("Registration process started");
		
		page.clickYourTripsButton();
		page.clickregisterButtonUnderYourTrips();
		Driver.switchTo().frame(page.frameId);
		page.enterUsernameUnderRegister(userName);
		page.clickCreateAccountButtonUnderRegister();
		page.enterPasswordUnderRegister(password);
		page.selectTitleUnderRegister(title);
		page.enterFirstNameUnderRegister(firstName);
		page.enterLastNameUnderRegister(lastName);
		page.selectCountryCodeUnderRegister(countryCode);
		page.entermobileNumUnderRegister(phoneNumber);//defect
		
		if(phoneNumber.matches("[0-9]+"))
		{
		Reporter.log("The Mobile number entered is valid",true);
		logger.info("The Mobile number entered is valid");
		}
	else
		{
		Reporter.log("The Mobile number entered is invalid create defect report",true);
		logger.info("The Mobile number entered is invalid create defect report");
		getScreenShot(Driver,"signUpWithClearTrip");
		}
		page.clickCreateAccount2ButtonUnderRegister();
		
		Thread.sleep(4000);
		
			
		if(Driver.getCurrentUrl().contains(page.clearTripRegisterSuccessCue))
		{
			if(phoneNumber.matches("[0-9]+"))
			{
			sassert.assertTrue(true);
			}
		else
			{
			Reporter.log("Clear Trip account creation was successful",true);
			sassert.assertTrue(false);
			}
			
			
		}
			
		sassert.assertAll();		
	}//signUpWithClearTrip ends  
	
	
		//Data providing code for signUpWithClearTrip
		@DataProvider(name="testData")
		public Object[][] dataFeed() throws IOException {
			Object[][] finalData = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\SigninRegisterExcel.xlsx","RegisterPage");
			return finalData;
		}
		
		
		public Object[][] testData(String path, String sheetName) throws IOException {
			
			ExcelUtilities excel = new ExcelUtilities(path, sheetName);
			int rows = excel.getRowCount();
			int cols = excel.getColCount();
			Object[][] data = new Object[rows-1][cols];
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					data[i-1][j]=excel.getCellData(i,j);
				}
			}
			
			return data;
		}//method ends here

		
	
	
}
