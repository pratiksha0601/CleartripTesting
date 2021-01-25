//Prepared by Anjana
package com.qa.tests;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.SignInandRegisterPages;
import com.qa.pages.Trainspages;
import com.qa.utilities.ExcelUtilities;

public class Trainsscripts extends Testbase
{
		SignInandRegisterPages page;
		Trainspages Trainpage;
		SoftAssert sassert;
		@BeforeClass
		public void setUp() 
		{
			page = new SignInandRegisterPages(Driver);
			Trainpage=new Trainspages(Driver);
			sassert=new SoftAssert();
		}
		
		@Test(priority = 1)
		public void clearTripLogin() 
		{
			page.clickYourTripsButton();
			page.clickSigninUnderYourTrips();
			Driver.switchTo().frame(page.frameId);
			page.enterUsernameUnderSignIn("cleartriptest123@gmail.com");
			page.enterPasswordUnderSignIn("Test@1234");
			page.clickFinalSignInButton();
		}
		@Test(priority=3,dataProvider="testData") 
		 //valid booking
		  public void Searchingtrains(String fromplace, String toplace, String classname) throws InterruptedException, IOException 
		  { 
		  //Driver.navigate().refresh();
		  Driver.navigate().back();
		  Driver.navigate().refresh();
		  //Trainpage.selectTrains();
		  Trainpage.setFromLocation(fromplace);
		  Trainpage.setToLocation(toplace);
		  Thread.sleep(2000);
		  Trainpage.setClassofTravel(classname);
		  Thread.sleep(2000);
		  Trainpage.setDepartDate("29012021");
		  Thread.sleep(2000);
		  Trainpage.SearchtrainsButtonClick();
		  Thread.sleep(5000);
		  //Driver.switchTo().frame("modal_window");
		  //Trainpage.irctc("abcd");
		  //Trainpage.proceedButtonclick();
		  //Thread.sleep(3000);
		  //Trainpage.SearchtrainsButtonClick();
		  //Thread.sleep(6000);
		  }
		
		@Test(priority=2,dataProvider="test")
		public void Searchtrains(String fromplace, String toplace, String classname) 
				throws InterruptedException, IOException {
			Trainpage.selectTrains();
			Trainpage.setFromLocation(fromplace);
			Trainpage.setToLocation(toplace);
			Thread.sleep(2000);
			Trainpage.setClassofTravel(classname);
			Thread.sleep(2000);
			Trainpage.setDepartDate("29012021");
			Thread.sleep(2000);
			Trainpage.SearchtrainsButtonClick();
			Thread.sleep(6000);
			Driver.switchTo().frame("modal_window");
			Trainpage.irctc("abcd");
			Trainpage.proceedButtonclick();
			Thread.sleep(3000);
			Trainpage.SearchtrainsButtonClick();
			Thread.sleep(6000);
			  
			  if(Driver.getTitle().contains("ctrip"))
			  {
				  sassert.assertTrue(true);
			  }
			  else
			  {
				  sassert.assertTrue(false);
					getScreenShot(Driver,"Searchtrains");
			  }
			  sassert.assertAll();
			  
		}
		
		@Test(priority=4,dataProvider="LData") 
		 //valid booking
		  public void Localtrain(String fromplace, String toplace, String classname) throws InterruptedException, IOException 
		  { 
		  //Driver.navigate().refresh();
		  Driver.navigate().back();
		  Driver.navigate().refresh();
		  //Trainpage.selectTrains();
		  Trainpage.setFromLocation(fromplace);
		  Trainpage.setToLocation(toplace);
		  Thread.sleep(2000);
		  Trainpage.setClassofTravel(classname);
		  Thread.sleep(2000);
		  Trainpage.setDepartDate("29012021");
		  Thread.sleep(2000);
		  Trainpage.SearchtrainsButtonClick();
		  Thread.sleep(5000);
		  //Driver.switchTo().frame("modal_window");
		  //Trainpage.irctc("abcd");
		  //Trainpage.proceedButtonclick();
		  //Thread.sleep(3000);
		  //Trainpage.SearchtrainsButtonClick();
		  //Thread.sleep(6000);
		  }
		
		@DataProvider(name="LData") 
		public Object[][] LocalData()
		{
			Object data[][] = LData("C:\\Users\\Praktiksha Sharma\\Desktop\\Trains.xlsx" , "Sheet3");
			return data;
		}
		
		@DataProvider(name="testData") 
		public Object[][] SearchData()
		{
			Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\Trains.xlsx" , "Trainsexcel");
			return data;
		}
		
		@DataProvider(name="test") 
		public Object[][] Data()
		{
			Object data[][] = test("C:\\Users\\Praktiksha Sharma\\Desktop\\Trains.xlsx" , "Sheet2");
			return data;
		}
		public static Object[][] testData(String FilePath, String SheetName){
			
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
		public static Object[][] test(String FilePath, String SheetName){
			
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
		
public static Object[][] LData(String FilePath, String SheetName){
			
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
