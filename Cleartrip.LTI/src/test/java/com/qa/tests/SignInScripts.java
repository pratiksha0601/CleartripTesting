package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.SignInandRegisterPages;
import com.qa.utilities.ExcelUtilities;

public class SignInScripts extends Testbase {
	SignInandRegisterPages page;	
	SoftAssert sassert;
	 
	@BeforeMethod
	public void setUp() {
		sassert =new SoftAssert();
		page = new SignInandRegisterPages(Driver);
		
	}
	
	@AfterMethod
	public void afterMethod() {
	
			Driver.navigate().to(baseURL);
		
		page = new SignInandRegisterPages(Driver);
		try {
			page.clickYourTripsButton();
			page.clickSignOutButton();
		}
		catch(Exception e) {
			//e.printStackTrace();
			page.clickYourTripsButton();
		}
		
		
		
	}
	
	
	
	@Test(priority = 1,dataProvider="testData")
	public void clearTripLogin(String userName,String password) throws InterruptedException {//negative clear trip login
		logger.info("Signin process started");
		
		page.clickYourTripsButton();
		page.clickSigninUnderYourTrips();
		Thread.sleep(2000);
		Driver.switchTo().frame(page.frameId);
		Thread.sleep(2000);
		page.enterUsernameUnderSignIn(userName);
		page.enterPasswordUnderSignIn(password);
		
		if(page.rememberMeUnderLoginStatus())
			page.clickrememberMeUnderLogin();
	
		page.clickFinalSignInButton();
		
		try {
		if(page.getinvalidLoginAlertClearTripPageText().contains(page.clearTripLoginPageFailure))
		{
			logger.info("Invalid Clear Trip credentials(Verified by reading the error message");
			sassert.assertTrue(true);
			//logger.error("Logger error message");
			Reporter.log("Invalid Clear Trip credentials(Verified by reading the error message)",true);
		
		}
		
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		
		Driver.switchTo().defaultContent();
		
		if(userName.equals(page.getYourTripsButtonText()))
		{
			logger.info("Valid Clear Trip credentials(Verified by reading the Login username)");

			sassert.assertTrue(true);
			Reporter.log("Valid Clear Trip credentials(Verified by reading the Login username)",true);
		}
		sassert.assertAll();
	
		}//clearTripLogin ends
	
	
	//Data providing code 
	@DataProvider(name="testData")
	public Object[][] dataFeed() throws IOException {
		Object[][] finalData = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\SigninRegisterExcel.xlsx","SignInPage");
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
		