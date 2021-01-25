package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Flightspages;
import com.qa.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase  {
	public WebDriver Driver;
	public static Logger logger;
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	
@BeforeClass
@Parameters("browser")
public void setUp(String browser) {
	logger=Logger.getLogger("Testbase");
	PropertyConfigurator.configure("log4j.properties");
	//System.out.println("I am before test!");
	if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	Driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		Driver=new EdgeDriver();
	}else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		Driver=new FirefoxDriver();
	}
	
	Driver.get(baseURL);
	Driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//FlightsObj=new Flightspages(Driver);
	
}

@AfterClass
public void tearDown() {
	//System.out.println("I am after test!");
	Driver.quit();

}
public void getScreenShot(WebDriver Driver , String tname) throws IOException {
	
	
	//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot SShot = (TakesScreenshot) Driver;
	
	File Source = SShot.getScreenshotAs(OutputType.FILE);
	// destination
	
	String Destination  = System.getProperty("user.dir") + "/Screenshots/" + tname +".png" ;
	
	FileUtils.copyFile(Source,new File(Destination));	
	
	
}
	

}
