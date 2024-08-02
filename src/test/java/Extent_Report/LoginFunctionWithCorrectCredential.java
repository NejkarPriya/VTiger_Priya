package Extent_Report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginFunctionWithCorrectCredential {
@Test
public void CorrectCredential() throws InterruptedException {
	//Create spark reporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/LoginFunction.html");
		
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
		ExtentTest test = report.createTest("CorrectCredential");
		
		//Test Case
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("admin01");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
	    WebElement community_poll = driver.findElement(By.xpath("//strong[text()='Community poll']"));
	    
	    if (community_poll.isDisplayed()) {
			test.log(Status.INFO, "community_poll is displayed");
		}
	    else {
	    	test.log(Status.INFO, "community_poll is not displayed");
	    }
		report.flush();
}
}