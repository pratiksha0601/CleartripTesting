package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	 ExtentHtmlReporter HtmlReport;
	  ExtentReports XReports;
	  ExtentTest XTests;
	  public void onStart(ITestContext testContext) {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        String repName="Test-Report-"+timeStamp+".html";

       // htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);*/
		  
		//  String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  //String repName="Test-Report-"+timeStamp+".html";
		//  HtmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+"DemoCheck.html");
		  HtmlReport=new ExtentHtmlReporter("Cleartrip"+timeStamp+".html");
			XReports=new ExtentReports();
			HtmlReport.config().setTheme(Theme.DARK);
			HtmlReport.config().setReportName("First Testing Report");
			HtmlReport.config().setDocumentTitle("DOC 1");
			HtmlReport.config().setAutoCreateRelativePathMedia(true);
		
			XReports.setSystemInfo("OS", "WINDOWS");
			XReports.setSystemInfo("QA", "PRATIKSHA");
			XReports.attachReporter(HtmlReport);
	  }

	  
	  public void onFinish(ITestContext testContext) {
		  XReports.flush();
	  }
	
	  public void onTestSuccess(ITestResult tr) {
	   XTests=XReports.createTest(tr.getName());
	   XTests.log(Status.PASS,tr.getName());
	   XTests.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));

	   
	  }

	  
	  public void onTestFailure(ITestResult tr) {
		  XTests=XReports.createTest(tr.getName());
		   XTests.log(Status.FAIL,tr.getName());
		   XTests.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		   String sspath=System.getProperty("user.dir") + "/Screenshots/" + tr.getName() +".png" ;
		   File f=new File(sspath);
		   if(f.exists()) {
			  
				   try {
					XTests.addScreenCaptureFromPath(sspath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
		   }
		   
		   
		   
	  }

	  
	  public void onTestSkipped(ITestResult tr) {
		  XTests=XReports.createTest(tr.getName());
		   XTests.log(Status.SKIP,tr.getName());
		   XTests.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.YELLOW));

	  }
}
