package com.netbanktest.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter; 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportingconfig extends TestListenerAdapter{
	
	public ExtentSparkReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlreporter=new ExtentSparkReporter("./test-output/"+repName);
		try {
			htmlreporter.loadXMLConfig("./extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host Name", "Local Name");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("User", "BalaKrishnan");
		
		htmlreporter.config().setDocumentTitle("netbanking project");//Title of the report
		htmlreporter.config().setReportName("Functional Report Name");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String screenshotPath=".\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotPath);
		if(f.exists()) {
			logger.fail("Screenshot is below"+logger.addScreenCaptureFromPath(screenshotPath));
		}
	}
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
