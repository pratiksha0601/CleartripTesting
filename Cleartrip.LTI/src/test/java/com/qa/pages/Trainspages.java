package com.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Trainspages 
{
	WebDriver Driver;
	@FindBy(xpath="//*[@id=\"Home\"]/div/aside[1]/nav/ul[1]/li[3]/a")
	@CacheLookup
	WebElement Trains;
	public void selectTrains() 
	{
		Trains.click();
	}
	@FindBy(id="from_station")
	WebElement FromLocation;
	public void setFromLocation(String fromplace)
	{
		FromLocation.sendKeys(fromplace);
	}
	
	@FindBy(id="to_station")
	WebElement ToLocation;
	public void setToLocation(String toplace)
	{
		ToLocation.click();
		ToLocation.sendKeys(toplace);
	}
	@FindBy(xpath="//*[@id=\"trainClass\"]")
	WebElement ClassofTravel;
	public void setClassofTravel(String classname)
	{
		ClassofTravel.click();
		Select Class=new Select(ClassofTravel);
		Class.selectByVisibleText(classname);
	}
	@FindBy(xpath="/html/body/div[5]/div[3]/table[1]/tbody/tr[5]/td[5]/a")
	WebElement DepartureDate;
	public void setDepartDate(String date) 
	{
		DepartureDate.click();
	}
	@FindBy(id="irctc_username")
	WebElement irctcname;
	public void irctc(String name)
	{
		irctcname.sendKeys(name);
	}
	@FindBy(id="getStartedWithEmailID")
	WebElement proceedButton;
	public void proceedButtonclick()
	{
		proceedButton.click();
	}
	@FindBy(id="email")
	WebElement Signinemail;
	public void setSigninemail(String typeemail) 
	{
		Signinemail.sendKeys(typeemail);
	}
	@FindBy(id="password")
	WebElement Signinpassword;
	public void setSigninpassword(String typepassword) 
	{
		Signinpassword.sendKeys(typepassword);
	}
	@FindBy(id="signInButton")
	WebElement SigninButton;
	public void SigninButtonClick() 
	{
		SigninButton.click();
	}
	@FindBy(id="Check availability")
	WebElement checkavailButton;
	public void checkavailButtonClick() 
	{
		checkavailButton.click();
	}
	@FindBy(id="destination_address-1")
	WebElement Address;
	public void setAddress(String Destinationaddress)
	{
		Address.sendKeys(Destinationaddress);
	}
	@FindBy(id="destination_colony-1")
	WebElement Colony;
	public void setColony(String Destinationcolony)
	{
		Address.sendKeys(Destinationcolony);
	}
	@FindBy(id="destination_pincode-1")
	WebElement Pincode;
	public void setPincode(String Destinationpincode)
	{
		Address.sendKeys(Destinationpincode);
	}
	@FindBy(className="booking")
	WebElement trainbookingButton;
	public void trainbookingButtonClick() 
	{
		trainbookingButton.click();
	}
	@FindBy(xpath="//*[@id=\"trainFormButton\"]")
	WebElement SearchtrainsButton;
	
	public void SearchtrainsButtonClick() 
	{
		SearchtrainsButton.click();
	}
	public Trainspages(WebDriver Driver)
	{
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
}
