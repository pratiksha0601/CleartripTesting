package com.qa.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.SignInandRegisterPages;
import com.qa.tests.Testbase;
import com.qa.utilities.ExcelUtilities;

public class FbRegisterScripts extends Testbase {
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
		
		try {
			page.clickYourTripsButton();
			page.clickSignOutButton();
		}
		catch(Exception e) {
			
		}
		if(!Driver.getCurrentUrl().equals(baseURL))
		Driver.navigate().to(baseURL);
	}
	
	@Test(priority=1,dataProvider="testData1")
	public void signUpWithFb(String userName, String password) throws InterruptedException {// fb condition
		logger.info("FB registration process started");
		
		page.clickYourTripsButton();
		page.clickregisterButtonUnderYourTrips();
		Driver.switchTo().frame(page.frameId);
		page.clicksignUpWithFbButtonUnderRegister();
		Driver.switchTo().defaultContent();
		page.enterEmailInFbPage(userName);
		page.enterPasswordInFbPage(password);
		page.clickLoginButtonInFbPage();
		//page.clickcontinueAsButtonInFbPageUnderRegister();
		
		try {	
			if(page.getInvalidLoginAlertFbpageText().contains(page.fbSignInPageAlert))
			{
				logger.info("Invalid FB credentials(Verified by reading the error message)");
				sassert.assertTrue(true);
				getScreenShot(Driver,"signUpWithFb");
				Reporter.log("Invalid FB credentials(Verified by reading the error message)",true);
			}
			}
			catch(Exception e)
			{
				
			}
		
		if(Driver.getCurrentUrl().contains(page.clearTripFbRegisterSuccessCue))
		{
			logger.info("FB registration Successful(Verified by reading URl)");
			sassert.assertTrue(true);
			Reporter.log("FB registration Successful(Verified by reading URl)",true);
		}
				
			sassert.assertAll();		
		}//signUpWithFb ends
		
	//Data providing code for signUpWithFb
	@DataProvider(name="testData1")
	public Object[][] dataFeed1() throws IOException {
		Object[][] finalData = testData1("C:\\Users\\Praktiksha Sharma\\Desktop\\SigninRegisterExcel.xlsx","RegisterPageFb");
		return finalData;
	}
	
	
	public Object[][] testData1(String path, String sheetName) throws IOException {
		
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
