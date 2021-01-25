package com.qa.tests;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Hotelspages;
import com.qa.utilities.ExcelUtilities;

////AUTHOR @ KASHYAP DHARANIKOTA(TEAM-D)

public class Hotelstestscripts extends Testbase
{
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
		obj.selectHotelsOption();
		logger.info("Hotels page is loaded");
		if(Driver.getCurrentUrl().contains("Search for hotels"))
		{   getScreenShot(Driver,"hotelsPageLoading");
			Assert.assertTrue(true);
			Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		else
		{
			sassert.assertTrue(false,"Hotels Booking page has failed to load");
		}
	}
	
	@Parameters("city")
	@Test(priority=2)
	public void cityAndDatesSelection(String city) throws IOException
	{
		//String city = "Hyderabad";
		obj.whereToCity(city);
		obj.checkInDate();
    	obj.checkOutDate();
    	getScreenShot(Driver,"cityAndDatesSelection");
    	logger.info("City of the Hotel to be booked and check-in and check-out dates are entered");
    }
    @Test(priority=3,dataProvider="countDetails")
    public void travellerAndRoomCount(int room,int adult,int child,String value) throws IOException
    {
    	
    	if(room<=7 && adult<=9 && child<=7 && room!=0 && adult!=0)
    	{
    		obj.roomAndTravellerCount(room, adult, child,value);
    		logger.info("The Number of Rooms and Traveller Count-(Adult/Children) are entered and Hotels list is produced");
    		if(Driver.getCurrentUrl().contains("Business travel? Your GSTIN unlocks exclusive benefits"))
    		{   getScreenShot(Driver,"travellerAndRoomCount");
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
    			obj.hotelSelect();
    			logger.info("A convinient hotel from the list is selected");
    			String parentWindow= Driver.getWindowHandle();
    			Set<String> allHandles = Driver.getWindowHandles();
    			String currentWindowHandle = allHandles.iterator().next();
    			allHandles.remove(allHandles.iterator().next());
    			String lastHandle = allHandles.iterator().next();
    			Driver.switchTo().window(lastHandle);
    			 Driver.navigate().refresh();
    			obj.roomSelect();
    			logger.info("A convinient Room and Package is selected");
    		    			
    			if(Driver.getCurrentUrl().contains("Book in three simple steps"))
    			{   getScreenShot(Driver,"hotelAndRoomSelect");
    				Assert.assertTrue(true);
    			}
    			else
    			{
    				sassert.assertTrue(false,"Booking Page failed to load");
    			}
    			obj.emailEntry();
    			logger.info("User Successfully Logged in");
    			Thread.sleep(5000);
    		}
    		@Test(priority=5,dataProvider="testData")
    		public void travellerDetailsEntry(String Fname,String Lname,String gst, String gstnumber,String companyname,String phnumber,String specialrequest) throws InterruptedException, IOException
    		{   logger.info("This test Method is Deliberately Failed!");
    		    getScreenShot(Driver,"travellerDetailsEntry");
    			Assert.assertTrue(false);
    			//obj.nameValidEntry(Fname, Lname);
    			if(gst=="true")
    			{
    				obj.gstDetails(gstnumber, companyname);
    				obj.mobileAndSpecialRequest(phnumber, specialrequest);
    			}
    			else
    		{
    				obj.mobileAndSpecialRequest(phnumber, specialrequest);
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
    		/*@Test
    		public void travellerDetailsInValidEntry(String Fname,String Lname,boolean gst, String gstnumber,String companyname,String phnumber,String specialrequest)
    		{
    			obj.nameInValidEntry(Fname, Lname);
    			if(gst=true)
    			{
    				obj.gstDetails(gstnumber, companyname);
    				obj.mobileAndSpecialRequest(phnumber, specialrequest);
    			}
    			else
    		{
    				obj.mobileAndSpecialRequest(phnumber, specialrequest);
    		}
    			if(obj.getErrorMsg().contains("RED"))
    			{
    				Assert.assertTrue(true);
    		}
    			else
    			{
    				sassert.assertTrue(false,"Error message is not displayed for invalid entries");
    			}*/
    		@DataProvider(name="testData") // method provides data to another method (@Test) 
    	    public Object[][] SearchData(){
    	        
    	        Object data[][] = testData("C:\\Users\\Praktiksha Sharma\\Desktop\\Cleartrip.xlsx" , "Sheet1");
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

