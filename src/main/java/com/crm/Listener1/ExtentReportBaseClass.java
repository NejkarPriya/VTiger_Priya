package com.crm.Listener1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ExtentReportBaseClass {
	public static WebDriver driver;
	@BeforeClass
	public void launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
	}
	@BeforeMethod
	public void login() throws IOException
	{
//		driver.findElement(By.partialLinkText("Log in")).click();
//		driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
//		driver.findElement(By.id("Password")).sendKeys("admin01");
//		driver.findElement(By.id("RememberMe")).click();
//		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}	
	@AfterMethod
	public void logout()
	{
//		driver.findElement(By.partialLinkText("Log out")).click();
	}	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}
