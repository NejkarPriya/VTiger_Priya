package com.crm.Listener1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.DwsScreenShot;

public class ScreenShotWithFailed extends DwsScreenShot implements ITestListener{
ExtentReports report;
ExtentSparkReporter spark;
ExtentTest test;

@Override
public void onTestStart(ITestResult result) {
	String t_name = result.getMethod().getMethodName();
	Reporter.log(t_name+"is executed");
}
@Override
public void onTestSuccess(ITestResult result) {
	String t_name = result.getMethod().getMethodName();
	test.log(Status.PASS, t_name+"is success");
}
@Override
public void onTestFailure(ITestResult result) {
	String t_name = result .getMethod().getMethodName();
	test.log(Status.FAIL,t_name+"is Failure");
	TakesScreenshot ts = (TakesScreenshot) driver;
	String screenshot = ts.getScreenshotAs(OutputType.BASE64);
	test.addScreenCaptureFromBase64String(screenshot);
}
@Override
public void onTestSkipped(ITestResult result) {
	String t_name = result.getMethod().getMethodName();
	test.log(Status.SKIP, t_name+"is Skipped");
}

@Override
public void onStart(ITestContext context) {
	       //Create spark reporter
		    spark = new ExtentSparkReporter("./Reports/failedTestCase.html");
			
			//Configure the spark reporter
			spark.config().setDocumentTitle("FailedTC");
			spark.config().setReportName("Priya");
			spark.config().setTheme(Theme.STANDARD);
			
			// Create the extent report
			 report = new ExtentReports();
			
			//Configure the extent report
			report.setSystemInfo("Os", "Window-11");
			report.setSystemInfo("Browser","Chrome-100");
			
			//Attach the spark reporter to the extent report
			report.attachReporter(spark);
		    }
@Override
public void onFinish(ITestContext context) {
	report.flush();
}
}