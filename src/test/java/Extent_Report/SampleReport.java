package Extent_Report;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
@Test
public void BasicReport() 
{
	//Create spark reporter
	ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/SampleReport.html");
	
	//Configure the spark reporter
	spark.config().setDocumentTitle("SampleReport");
	spark.config().setReportName("Priya");
	spark.config().setTheme(Theme.STANDARD);
	
	// Create the extent report
	ExtentReports report = new ExtentReports();
	
	//Configure the extent report
	report.setSystemInfo("Os", "Window-11");
	report.setSystemInfo("Browser","Chrome-100");
	
	//Attach the spark reporter to the extent report
	report.attachReporter(spark);
	ExtentTest test = report.createTest("BasicReport");
	test.log(Status.INFO,"reports is successfully created");
	report.flush();
}
}