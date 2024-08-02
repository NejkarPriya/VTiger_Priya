package BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
		public static WebDriver driver;
		
//		@Parameters({"browser","url"})
		@BeforeClass
		public void preCondition()
		{
			driver = new ChromeDriver();
//			if(browser.equalsIgnoreCase("chrome"))
//			{
//				driver = new ChromeDriver();
//			}else if(browser.equalsIgnoreCase("edge"))
//			{
//				driver = new EdgeDriver();
//			}else {
//				driver = new ChromeDriver();
//			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://demowebshop.tricentis.com/");
		}
		
		@BeforeMethod
		public void login()
		{
			driver.findElement(By.partialLinkText("Log in")).click();
			driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("admin01");
			driver.findElement(By.id("RememberMe")).click();
			driver.findElement(By.cssSelector("input[value='Log in']")).click();
		}
		
		@AfterMethod
		public void logout()
		{
			driver.findElement(By.partialLinkText("Log out")).click();
		}
		
		@AfterClass
		public void postCondition()
		{
			driver.quit();
		}
}