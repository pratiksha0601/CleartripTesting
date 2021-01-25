package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Flightspages {
	WebDriver Driver;
	public Flightspages(WebDriver Driver) {
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	@FindBy(id="OneWay")
	WebElement OneWayButton;
	public void selectOneWay() {
		OneWayButton.click();
	}
	
	@FindBy(id="RoundTrip")
	WebElement RoundTripButton;
	
	public void selectRoundTrip() {
		RoundTripButton.click();
	}
	@FindBy(id="MultiCity")
	WebElement MultiCityButton;
	
	public void selectMultiCity() {
		MultiCityButton.click();
	}
	@FindBy(id="FromTag")
	WebElement FromLocation;
	@FindBy(id="ui-id-1")
	WebElement FromLocationselect;
	public void setFromLocation(String fromplace) {
		if(fromplace.contains("  ")) {
		FromLocation.sendKeys(fromplace);
		
	}
		else{
			FromLocation.sendKeys(fromplace);
			FromLocationselect.click();
		}
	}
	@FindBy(id="FromTag1")
	WebElement FromLocation1;
	@FindBy(id="ui-id-4")
	WebElement FromLocationselect1;
	public void setFromLocation1(String fromplace) {
		if(fromplace.contains("  ")) {
		FromLocation1.sendKeys(fromplace);
		
	}
		else{
			FromLocation1.sendKeys(fromplace);
			FromLocationselect1.click();
		}
	}
	@FindBy(id="FromTag2")
	WebElement FromLocation2;
	@FindBy(id="ui-id-6")
	WebElement FromLocationselect2;
	public void setFromLocation2(String fromplace) {
		if(fromplace.contains("  ")) {
		FromLocation2.sendKeys(fromplace);
		
	}
		else{
			FromLocation2.sendKeys(fromplace);
			FromLocationselect2.click();
		}
	}
	@FindBy(id="FromTag3")
	WebElement FromLocation3;
	@FindBy(id="ui-id-8")
	WebElement FromLocationselect3;
	public void setFromLocation3(String fromplace) {
		if(fromplace.contains("  ")) {
		FromLocation3.sendKeys(fromplace);
		
	}
		else{
			FromLocation3.sendKeys(fromplace);
			FromLocationselect3.click();
		}
	}
	@FindBy(id="ToTag")
	WebElement ToLocation;
	@FindBy(id="ui-id-2")
	WebElement ToLocationselect;
	public void setToLocation(String toplace) {
		if(toplace.contains("  ")) {
		ToLocation.sendKeys(toplace);}
		else {
			ToLocation.sendKeys(toplace);
		ToLocationselect.click();
	}}
	@FindBy(id="ToTag1")
	WebElement ToLocation1;
	@FindBy(id="ui-id-5")
	WebElement ToLocationselect1;
	public void setToLocation1(String toplace) {
		if(toplace.contains("  ")) {
		ToLocation1.sendKeys(toplace);}
		else {
			ToLocation1.sendKeys(toplace);
		ToLocationselect1.click();
	}}
	@FindBy(id="ToTag2")
	WebElement ToLocation2;
	@FindBy(id="ui-id-7")
	WebElement ToLocationselect2;
	public void setToLocation2(String toplace) {
		if(toplace.contains("  ")) {
		ToLocation2.sendKeys(toplace);}
		else {
			ToLocation2.sendKeys(toplace);
		ToLocationselect2.click();
	}}
	@FindBy(id="ToTag3")
	WebElement ToLocation3;
	@FindBy(id="ui-id-9")
	WebElement ToLocationselect3;
	public void setToLocation3(String toplace) {
		if(toplace.contains("  ")) {
		ToLocation3.sendKeys(toplace);}
		else {
			ToLocation3.sendKeys(toplace);
		ToLocationselect3.click();
	}}
	@FindBy(id="DepartDate")
	WebElement DepartureDate;
	public void setDepartDate(String date) {
		 DepartureDate.clear();
	DepartureDate.click();
	DepartureDate.sendKeys(date);}
	@FindBy(id="DepartDate1")
	WebElement DepartureDate1;
	public void setDepartDate1(String date) {
	DepartureDate1.click();
	DepartureDate1.sendKeys(date);}
	@FindBy(id="DepartDate2")
	WebElement DepartureDate2;
	public void setDepartDate2(String date) {
	DepartureDate2.click();
	DepartureDate2.sendKeys(date);}
	@FindBy(id="DepartDate3")
	WebElement DepartureDate3;
	public void setDepartDate3(String date) {
	DepartureDate3.click();
	DepartureDate3.sendKeys(date);}
	@FindBy(xpath="//body/div[3]/div[1]/div[1]/div[5]/div[3]/div[1]/div[3]/button[1]")
	WebElement Fare;
	public void selectFare() {
		
		
		Fare.click();
	}
	@FindBy(id="MoreOptionsLink")
	WebElement MoreOptions;
	public void setMoreOptions() {
		MoreOptions.click();
	}
	@FindBy(id="ReturnDate")
     WebElement ReturnDate;
	public WebElement getReturnDate() {
		
		return ReturnDate;
	}
	public void setReturnDate(String date) {
		ReturnDate.clear();
		ReturnDate.click();
		ReturnDate.sendKeys(date);
	}
	@FindBy(id="Class")
	WebElement ClassOfTravel;
	public void setClassOfTravel(String classname) {
		Select Class=new Select(ClassOfTravel);
		Class.selectByVisibleText(classname);
	}
	@FindBy(id="SearchBtn")
	WebElement SearchFlights;
	public void clickSearchFlights()
	{	
		SearchFlights.click();
	}
	@FindBy(xpath="//button[text()='Book']")
	WebElement Book;

public void clickBookButton() {
	Book.click();
}
//@FindBy(xpath="//button[contains(text(),'Continue')]")
@FindBy(xpath="//button[contains(text(),'Continue')]")
WebElement Continue;
public void clickContinueafterfare() {
	String parentWindow= Driver.getWindowHandle();
	Set<String> allHandles = Driver.getWindowHandles();
	 String currentWindowHandle = allHandles.iterator().next();
	 allHandles.remove(allHandles.iterator().next());
	 String lastHandle = allHandles.iterator().next();
	 Driver.switchTo().window(lastHandle);
	Continue.click();
}
@FindBy(xpath="//input[@placeholder='Mobile number']")
WebElement MobileNumberBox;
public void setMobile(String number) {
	MobileNumberBox.sendKeys(number);
}
@FindBy(xpath="//input[@placeholder='Email address']")
WebElement EmailAddressBox;
public void setEmail(String email) {
	EmailAddressBox.sendKeys(email);
}
@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[5]/div[1]/div[1]/div[7]/button[1]")
////button[contains(text(),'Continue')]
WebElement Continueafterdetails;
public void clickContinueafterdetails() {
	Continueafterdetails.click();	
}
@FindBy(xpath="//input[@placeholder='First name']")
WebElement FirstName;
public void setFirstName(String firstname) {
	FirstName.sendKeys(firstname);
}
@FindBy(xpath="//input[@placeholder='Last name']")
WebElement LastName;
public void setLastName(String lastname)
{LastName.sendKeys(lastname);
	}
@FindBy(xpath="//input[@placeholder='Nationality (e.g. India)']")
WebElement Nationality;
@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[8]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]")
WebElement NationalitySelect;
public void setNationality(String nationality) {
	Nationality.sendKeys(nationality);
	NationalitySelect.click();
}
@FindBy(xpath="//*[text()='Gender']")
WebElement Gender;
@FindBy(xpath="//*[text()='Male']")
WebElement Male;
@FindBy(xpath="//*[text()='Female']")
WebElement Female;
public void setGender(String gender) {
	Gender.click();
	if(gender.equalsIgnoreCase("male")) {
		Male.click();
	}
	else if(gender.equalsIgnoreCase("female")) {
		Female.click();
	}
	
}
@FindBy(xpath="//button[contains(text(),'Continue to payment')]")
WebElement ContinuetoPayment;
public void clickContinueToPayment() {
	 ContinuetoPayment.click();
	 
}
@FindBy(id="homeErrorMessage")
WebElement Errormsg;
public WebElement getErrormsg() {
	return Errormsg;
}
}

