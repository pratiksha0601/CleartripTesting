package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.tests.Testbase;

////AUTHOR @ KASHYAP DHARANIKOTA(TEAM-D)

public class Hotelspages extends Testbase {
	WebDriver Driver;
	@FindBy(id="hotelLink")
	@CacheLookup
	WebElement selecthotels;
	public void selectHotelsOption()
	{	
		selecthotels.click();
		
	}
	@FindBy(id="Tags")
	@CacheLookup
	WebElement cityname;
	@FindBy(xpath="/html/body/ul[1]/li[2]/a")
	@CacheLookup
	WebElement cityselect;
	public void whereToCity(String city)
	{
		cityname.sendKeys(city);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cityselect.click();
	}
	@FindBy(id="CheckInDate")
	@CacheLookup
	WebElement checkin;
	@FindBy(xpath="/html/body/div[6]/div[1]/table/tbody/tr[4]/td[5]/a")
	@CacheLookup
	WebElement indate;
	public void checkInDate() 
	{
		checkin.click();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		indate.click();
	}
	@FindBy(id="CheckOutDate")
	@CacheLookup
	WebElement checkout;
	@FindBy(xpath="/html/body/div[6]/div[1]/table/tbody/tr[5]/td[1]/a")
	@CacheLookup
	WebElement outdate;
	public void checkOutDate() 
	{
		checkout.click();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		outdate.click();
	}
	@FindBy(xpath="/html/body/section[2]/section/div/div/div[1]/form/section[3]/div/dl/dd/select")
	@CacheLookup
	WebElement traveler;
	@FindBy(xpath="//*[@id=\"SearchForm\"]/nav[2]/ul/li/section/div[1]/dl/dd/select")
	@CacheLookup
	WebElement rooms;
	@FindBy(id="Adult_1")
	@CacheLookup
	WebElement adults;
	@FindBy(id="Childs_1")
	@CacheLookup
	WebElement children;
	@FindBy(id="SearchHotelsButton")
	@CacheLookup
	WebElement searchbutton;
	public void roomAndTravellerCount(int room,int adult,int child,String value)
	{   Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select tr=new Select(traveler);
		Select r=new Select(rooms);
		Select a=new Select(adults);
		Select c=new Select(children);
	    tr.selectByVisibleText(value);
		
		r.selectByIndex(room-1);
		
		a.selectByIndex(adult-1);

		c.selectByIndex(child-1);
		
		searchbutton.click();
		
	}
	public void searchButtonClick()
	{
		searchbutton.click();
	}
	@FindBy(xpath="//*[@id=\"312740\"]/section/div[3]/nav/ul/li[1]/h2/a")
	@CacheLookup
	WebElement hotel;
	public void hotelSelect()
	{
		hotel.click();
	}
	@FindBy(id="showNearByBox")
	@CacheLookup
	WebElement search;
	@FindBy(name="Fortune Park Vallabha, Road Number 12, NBT Nagar, Banjara Hills, Hyderabad, Telangana, India")
	@CacheLookup
	WebElement searchselect;
	public void searchHotel()
	{   
		search.sendKeys("Fortune Park Vallabha");
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchselect.click();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hotel.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Select Room')]")
	@CacheLookup
	WebElement roomtype;
	@FindBy(xpath="//*[@id=\"hotelDetailContainer_1_1\"]/section/div[2]/div/div[2]/div[6]/ul/li[1]/div/div[2]/ul/li[1]/div[2]/div/div[2]/div/button")
	@CacheLookup
	WebElement roomselect;
	@FindBy(id="itineraryBtn")
	@CacheLookup
	WebElement continuebutton;
	public void roomSelect() throws InterruptedException
	{
		roomtype.click();
		Thread.sleep(5000);
		roomselect.click();
		Thread.sleep(5000);
		continuebutton.click();
	}
	@FindBy(xpath="//*[@id=\"hotelDetailsHeader\"]/div/div[1]/div[2]/div/div[3]/a")
	@CacheLookup
	WebElement selectroom;
	@FindBy(xpath="//*[@id=\"hotelDetailContainer_1_1\"]/section/div[2]/div/div[2]/div[6]/ul/li[1]/div/div[2]/ul/li[1]/div[2]/div/div[2]/div/button")
	@CacheLookup
	WebElement selectroomtype;
	public void searchRoomSelect() throws InterruptedException
	{   hotel.click();
	Thread.sleep(5000);
		roomtype.click();
		Thread.sleep(5000);
		roomselect.click();
		Thread.sleep(5000);
		continuebutton.click();
	}
	@FindBy(id="username")
	@CacheLookup
	WebElement username;
	@FindBy(id="signinLabel")
	@CacheLookup
	WebElement checkbox;
	@FindBy(id="password_1")
	@CacheLookup
	WebElement password;
	@FindBy(id="LoginContinueBtn_1")
	@CacheLookup
	WebElement login;
	public void emailEntry() throws InterruptedException
	{
		username.sendKeys("cleartriptest123@gmail.com");
		checkbox.click();
		password.sendKeys("Test@1234");
		login.click();
		Thread.sleep(10000);
	}
	@FindBy(xpath="/html/body/div[1]/section[2]/div[2]/div[3]/form/div/div[1]/dl[1]/dd[2]/select")
	@CacheLookup
	WebElement title;
	@FindBy(xpath="/html/body/div[1]/section[2]/div[2]/div[3]/form/div/div[1]/dl[1]/dd[2]/select/option[2]")
	@CacheLookup
	WebElement salutation;
	@FindBy(xpath="/html/body/div[1]/section[2]/div[2]/div[3]/form/div/div[1]/dl[1]/dd[2]/input[1]")
	@CacheLookup
	WebElement firstname;
	@FindBy(name="/html/body/div[1]/section[2]/div[2]/div[3]/form/div/div[1]/dl[1]/dd[2]/input[2]")
	@CacheLookup
	WebElement lastname;
	public void nameValidEntry(String Fname,String Lname)
	{   Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		title.click();
		salutation.click();
		firstname.sendKeys(Fname);
		lastname.sendKeys(Lname);
	}
	@FindBy(id="contactSalutation")
	@CacheLookup
	Select title1;
	@FindBy(id="contactFirstName")
	@CacheLookup
	WebElement firstname1;
	@FindBy(id="contactLastName")
	@CacheLookup
	WebElement lastname1;
	public void nameInValidEntry(String Fname,String Lname)
	{ 
		firstname1.clear();
	}
	@FindBy(id="use_gst")
	@CacheLookup
	WebElement gstselect;
	@FindBy(id="gst_number")
	@CacheLookup
	WebElement gstin;
	@FindBy(name="gst[gst_holder_name]")
	@CacheLookup
	WebElement company;
    public void gstDetails(String gstnumber,String companyname)
    {
    	gstselect.click();
    	gstin.sendKeys(gstnumber);
    	company.sendKeys(companyname);
    }
    @FindBy(xpath="/html/body/div[1]/section[2]/div[2]/div[3]/form/div/div[1]/dl[2]/dd[1]/input")
	@CacheLookup
	WebElement mobile;
	@FindBy(xpath="//*[@id=\"specialRequest\"]")
	@CacheLookup
	WebElement special;
	@FindBy(xpath="//*[@id=\"travellerBtn\"]")
	@CacheLookup
	WebElement continuetopayment;
	public void mobileAndSpecialRequest(String phnumber,String specialrequest)
	{  // mobile.clear();
		//mobile.sendKeys(phnumber);
		special.sendKeys(specialrequest);
		continuetopayment.click();
	}
	public void paymentClick()
	{
		continuetopayment.click();
	}
	@FindBy(id="TravellerBlockError")
	WebElement errmsg;
	public String getErrorMsg() {
		return errmsg.getText();
	}
	@FindBy(id="homeErrorMessage")
	WebElement errmsg1;
	public String getErrorMsg1() {
		return errmsg1.getText();
	}
	public Hotelspages (WebDriver driver) {
	    this.Driver = driver;
	    PageFactory.initElements(driver, this);
	}
}
