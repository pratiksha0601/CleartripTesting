package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.tests.Testbase;

public class SignInandRegisterPages extends Testbase {
	
	
	public String frameId = "modal_window";
	public String signInPageUrlCue = "#_=_";
	public String fbSignInPageAlert = "Forgotten password?";
	public String clearTripLoginPageSuccess = "cleartrip.com";
	public String clearTripLoginPageFailure = "username or password you entered is incorrect";
	public String clearTripFbRegisterSuccessCue = "accounts";
	public String clearTripRegisterSuccessCue = "accounts";
	
	@FindBy(xpath="//*[@id=\"userAccountLink\"]/span[2]")
    @CacheLookup   //*[@id="userAccountLink"]/span[2]
    WebElement yourTripsButtonText;
	public String getYourTripsButtonText() {
		return yourTripsButtonText.getText();
	}
	 
	 @FindBy(xpath="//*[@id=\"userAccountLink\"]/span[2]")
     @CacheLookup
     WebElement yourTripsButton;
	
     public void clickYourTripsButton() {
    	 yourTripsButton.click(); 
	 }
     
     @FindBy(id="SignIn")
     @CacheLookup
     WebElement signinButtonUnderYourTrips;
     public void clickSigninUnderYourTrips() {
    	 signinButtonUnderYourTrips.click();
     }
     
     @FindBy(xpath="//*[@id=\"email\"]")
     @CacheLookup
     WebElement username;
     public void enterUsernameUnderSignIn(String usernameInput) {
    	 username.sendKeys(usernameInput);
     }
     
     @FindBy(xpath="//*[@id=\"password\"]")
     @CacheLookup
     WebElement password;
	public void enterPasswordUnderSignIn(String passwordInput) {
		password.sendKeys(passwordInput);
	}
	
	@FindBy(xpath="//*[@id=\"signInButton\"]")
    @CacheLookup
    WebElement signInButton;
	public void clickFinalSignInButton() {
		signInButton.click();
	}//normal signin procedure
	
	@FindBy(xpath="//*[@id=\"ContentFrame\"]/div/div/div[2]/a")
    @CacheLookup
    WebElement FbSignInButton;
	public void clickFbSignInButton() {
		FbSignInButton.click();
	}

	@FindBy(id="email")
    @CacheLookup
    WebElement emailFieldInFbPage;
	public void enterEmailInFbPage(String fbEmail) {
		emailFieldInFbPage.sendKeys(fbEmail);
	}
	
	@FindBy(id="pass")
    @CacheLookup
    WebElement passwordFieldInFbPage;
	public void enterPasswordInFbPage(String fbPassword) {
		passwordFieldInFbPage.sendKeys(fbPassword);
	}

	@FindBy(name="login")
    @CacheLookup
    WebElement loginButtonInFbPage;
	public void clickLoginButtonInFbPage() {
		loginButtonInFbPage.click();
	}//fb login
	
	@FindBy(xpath="//*[@id=\"userAccountMenu\"]/li[1]/ul/li[1]/p/a")
    @CacheLookup
    WebElement registerButtonUnderYourTrips;
	public void clickregisterButtonUnderYourTrips() {
		registerButtonUnderYourTrips.click();
	}
	
	@FindBy(id="username1")
    @CacheLookup
    WebElement usernameUnderRegister;
	public void enterUsernameUnderRegister(String usernameInput) {
		usernameUnderRegister.sendKeys(usernameInput);
	}
	
	@FindBy(id="password")
    @CacheLookup
    WebElement passwordUnderRegister;
	public void enterPasswordUnderRegister(String passwordInput) {
		passwordUnderRegister.sendKeys(passwordInput);
	}
	
	@FindBy(id="profile_title")
    @CacheLookup
    WebElement selectTitleUnderRegister;
	public void selectTitleUnderRegister(String titleInput) {
		Select titleSelector = new Select(selectTitleUnderRegister);
		titleSelector.selectByVisibleText(titleInput);
	}
	
	@FindBy(name="first_name")
    @CacheLookup
    WebElement firstNameUnderRegister;
	public void enterFirstNameUnderRegister(String firstNameInput) {
		firstNameUnderRegister.sendKeys(firstNameInput);
	}
	
	@FindBy(name="last_name")
    @CacheLookup
    WebElement lastNameUnderRegister;
	public void enterLastNameUnderRegister(String lastNameInput) {
		lastNameUnderRegister.sendKeys(lastNameInput);
	}
	
	@FindBy(id="country_code")
    @CacheLookup
    WebElement selectCountryCodeUnderRegister;
	public void selectCountryCodeUnderRegister(String countryCodeAndName) {
		Select countryCodeSelector = new Select(selectCountryCodeUnderRegister);
		countryCodeSelector.selectByVisibleText(countryCodeAndName);
	}
	
	@FindBy(id="mobile_number")
    @CacheLookup
    WebElement mobileNumUnderRegister;
	public void entermobileNumUnderRegister(String mobileNumInput) {
		mobileNumUnderRegister.sendKeys(mobileNumInput);
	}
	
	@FindBy(id="mkt_sbpt")
    @CacheLookup
    WebElement promotionsCheckBoxUnderRegister;
	public void unCheckPromotionsCheckBoxUnderRegister() {
		promotionsCheckBoxUnderRegister.click();
	}
	
	@FindBy(id="signUpButton")
    @CacheLookup
    WebElement createAccountButton2UnderRegister;
	public void clickCreateAccount2ButtonUnderRegister() {
		createAccountButton2UnderRegister.click();
	}
	@FindBy(id="registerButton")
    @CacheLookup
    WebElement createAccountButtonUnderRegister;
	public void clickCreateAccountButtonUnderRegister() {
		createAccountButtonUnderRegister.click();
	}//register normally //*[@id="registerLayer"]/div[3]/a 
	
	@FindBy(xpath="//*[@id=\"registerLayer\"]/div[3]/a")
    @CacheLookup
    WebElement signUpWithFbButtonUnderRegister;
	public void clicksignUpWithFbButtonUnderRegister() {
		signUpWithFbButtonUnderRegister.click();
	}
	
	@FindBy(name="__CONFIRM__")
    @CacheLookup
    WebElement continueAsButtonInFbPageUnderRegister;
	public void clickcontinueAsButtonInFbPageUnderRegister() {
		continueAsButtonInFbPageUnderRegister.click();
	}
	
	@FindBy(xpath="//*[@id=\"globalContainer\"]/div[3]/div/div/div")
	@CacheLookup   
	WebElement invalidLoginAlertFbpage;
	public String getInvalidLoginAlertFbpageText() {
		return invalidLoginAlertFbpage.getText();
	}
	
	@FindBy(id="persistent_login")
    @CacheLookup
    WebElement rememberMeUnderLogin;
	public void clickrememberMeUnderLogin() {
		rememberMeUnderLogin.click();
	}
	public boolean rememberMeUnderLoginStatus() {
		if(rememberMeUnderLogin.isSelected())
			return true;
		else
			return false;
	}
	
	@FindBy(xpath="//*[@id=\"errors1\"]/ol/li")
	@CacheLookup
	WebElement invalidLoginAlertClearTripPage;
	public String getinvalidLoginAlertClearTripPageText() {
		return invalidLoginAlertClearTripPage.getText();
	}
	
	@FindBy(xpath="//*[@id=\"global_signout\"]")
	@CacheLookup
	WebElement signOutButton;
	public void clickSignOutButton() {
		signOutButton.click();
	}
	
	
		public SignInandRegisterPages(WebDriver Driver) {
			this.Driver = Driver;
       
			PageFactory.initElements(Driver, this);
		}
}
