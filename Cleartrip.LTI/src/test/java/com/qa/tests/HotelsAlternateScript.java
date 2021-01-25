package com.qa.tests;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Hotelspages;
import com.qa.utilities.ExcelUtilities;

////AUTHOR @ KASHYAP DHARANIKOTA(TEAM-D)

public class HotelsAlternateScript extends Testbase {
	SoftAssert sassert;
	Hotelspages obj;
	@BeforeMethod
	public void setup()
	{   
	    sassert = new SoftAssert();
		obj=new Hotelspages(Driver);
	}
	@Test(priority=1)
	public void hotelsPageLoading() throws IOException
	{   
		
		if(Driver.getCurrentUrl().contains("Search for hotels"))
		{  
			sassert.assertTrue(false,"Hotels Booking page has already loaded without clicking");
			Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		else
		{   obj.selectHotelsOption();
		getScreenShot(Driver,"hotelsPageLoading");
		logger.info("Hotels page is loaded");
		    Assert.assertTrue(true);
		}
	}
	@Parameters("city")
	@Test(priority=2)
	public void cityAndDatesSelection(String city) throws InterruptedException, IOException
	{
		obj.searchButtonClick();
    	if(obj.getErrorMsg1().contains("RED"))
    	{   
    	obj.whereToCity(city);
		obj.checkInDate();
    	obj.checkOutDate();
    	getScreenShot(Driver,"cityAndDatesSelection");
    	logger.info("City of the Hotel to be booked and check-in and check-out dates are entered");
    	Assert.assertTrue(true);	
    	}
    	else
    	{   
    		sassert.assertTrue(false,"Search Hotels button is enabled for incorrect city selection");
    	}
    }
	@Test(priority=3,dataProvider="countDetails")
    public void travellerAndRoomCount(int room,int adult,int child,String value) throws InterruptedException
    {
		Thread.sleep(5000);
    	if(room<=7 && adult<=9 && child<=7 && room!=0 && adult!=0)
    	{
    		obj.roomAndTravellerCount(room, adult, child,value);
    		logger.info("The Number of Rooms and Traveller Count-(Adult/Children) are entered and Hotels list is produced");
    		if(Driver.getCurrentUrl().contains("Business travel? Your GSTIN unlocks exclusive benefits"))
    		{
    			Assert.assertTrue(true);
    		}
    		else
    		{
    			sassert.assertTrue(false);
    		}
    	}
    	else
    	{
    		sassert.assertTrue(false,"The count for either of the field is exceeding the limit");
    	}
    }
	 @DataProvider
	    public Object[][] countDetails(){
	    		Object[][]data=new Object[1][4];
	    	data[0][0]=1;
	    	data[0][1]=3;
	    	data[0][2]=1;
	    	data[0][3]="More travellers...";
	    		return data;}
	 @Test(priority=4)
		public void hotelAndRoomSelect() throws InterruptedException, IOException
		{   Thread.sleep(5000);
			obj.searchHotel();
			logger.info("A convinient hotel from the list is selected");
			  String parentWindow= Driver.getWindowHandle(); Set<String> allHandles =
			 Driver.getWindowHandles(); String currentWindowHandle =
			 allHandles.iterator().next();
			 allHandles.remove(allHandles.iterator().next()); String lastHandle =
			 allHandles.iterator().next(); Driver.switchTo().window(lastHandle);
			 Driver.navigate().refresh();
			 
			Driver.navigate().refresh();
			if(Driver.getCurrentUrl().contains("Book in three simple steps"))
			{
				sassert.assertTrue(false,"Booking Page loaded before room selection");
			}
			else
			{   Driver.navigate().refresh();
				obj.roomSelect();
				getScreenShot(Driver,"hotelAndRoomSelect");
				logger.info("A convinient Room and Package is selected");
				Assert.assertTrue(true);
			}
			obj.emailEntry();
			logger.info("User Successfully Logged in");
			Thread.sleep(10000);
		}
	 @Test(priority=5,dataProvider="testData")
		public void travellerDetailsEntry(String Fname,String Lname,String gst, String gstnumber,String companyname,String phnumber,String specialrequest) throws IOException
		{ obj.nameInValidEntry(Fname, Lname);
		obj.paymentClick();
		//obj.nameValidEntry(Fname, Lname);
		if(obj.getErrorMsg().contains("RED"))
		{   getScreenShot(Driver,"travellerDetailsEntry");
			logger.info("Error msg for blank first name field is checked");
			Assert.assertTrue(true);
	}
		else
		{
			sassert.assertTrue(false,"Error message is not displayed for invalid entries");
		}
		/*if(Driver.getCurrentUrl().contains("Payment"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			sassert.assertTrue(false, "Payments page not loaded!");
		}*/
			
		}
	
	 @DataProvider(name="testData") // method provides data to another method (@Test) 
	    public Object[][] SearchData(){
	        
	        Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\Cleartrip.xlsx" , "Sheet2");
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
	    
}
