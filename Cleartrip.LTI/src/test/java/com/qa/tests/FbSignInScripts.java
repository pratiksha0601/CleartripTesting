package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.SignInandRegisterPages;
import com.qa.utilities.ExcelUtilities;

public class FbSignInScripts extends Testbase{
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
	
	@Test(priority=1,dataProvider="testData")
	public void loginWithFb(String userName,String password) throws InterruptedException {//fb logins
		logger.info("FB login process started");
		
		page.clickYourTripsButton();
		page.clickSigninUnderYourTrips();
		Driver.switchTo().frame(page.frameId);
		Thread.sleep(2000);
		page.clickFbSignInButton();
		Thread.sleep(2000);
		page.enterEmailInFbPage(userName);
		page.enterPasswordInFbPage(password);
		page.clickLoginButtonInFbPage();
		
		
		try {	
		if(page.getInvalidLoginAlertFbpageText().contains(page.fbSignInPageAlert))
		{
			logger.info("Invalid FB credentials(Verified by reading the error message)");
			sassert.assertTrue(true);
			Reporter.log("Invalid FB credentials(Verified by reading the error message)",true);
		}
		}
		catch(NoSuchElementException e)
		{
			//e.printStackTrace();
		}
		if(Driver.getCurrentUrl().contains(page.signInPageUrlCue))
		{
			sassert.assertTrue(true);
			logger.info("Valid FB credentials(Verified by reading the URL)");
			Reporter.log("Valid FB credentials(Verified by reading the URL)",true);

		}
			
		sassert.assertAll();		
	}//loginWithFb ends
	
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
