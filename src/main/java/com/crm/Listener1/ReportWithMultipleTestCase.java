package com.crm.Listener1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportWithMultipleTestCase implements ITestListener {
	ExtentReports report; // Global Variable
	ExtentSparkReporter spark; // Global Variable
	ExtentTest test; // Global Variable
	
	@Override
	public void onTestStart(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		Reporter.log(t_name+"is executed");
		test = report.createTest(t_name); // To create a report for multiple test case so write step in this
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		test.log(Status.PASS, t_name+"is Success");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		test.log(Status.FAIL , t_name+"is Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		test.log(Status.SKIP, t_name+"is Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		//Create spark reporter
	spark = new ExtentSparkReporter("./Reports/Multiple.html");
		
		//Configure the spark reporter
		spark.config().setDocumentTitle("SampleReport");
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
