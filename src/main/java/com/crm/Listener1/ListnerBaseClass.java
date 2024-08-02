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

public class ListnerBaseClass implements ITestListener {
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String t_Name = result.getMethod().getMethodName();
		Reporter.log(t_Name+"is executed");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String t_Name = result.getMethod().getMethodName();
		test.log(Status.PASS,t_Name+"is PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String t_Name = result.getMethod().getMethodName();
		test.log(Status.FAIL,t_Name+"is FAIL");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String t_Name = result.getMethod().getMethodName();
		test.log(Status.SKIP,t_Name+"is Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		    spark = new ExtentSparkReporter("./Reports/DWS.html");
			spark.config().setDocumentTitle("DWSReport");
			spark.config().setReportName("Priya");
			spark.config().setTheme(Theme.STANDARD);
			
			
		    report = new ExtentReports();
			report.setSystemInfo("Operating System", "Windows_125");
			report.setSystemInfo("Browser", "Chrome");
			report.setSystemInfo("Type of Testing", "Functional");
			report.attachReporter(spark);
		    test = report.createTest("sampleReport");
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}	
}
