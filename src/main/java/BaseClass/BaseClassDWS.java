package BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClassDWS {
	public WebDriver driver;
	@Parameters({"browser","url"})
	@BeforeClass
	public void precondition(String browser,String url) 
	{
		if (browser.equals("chrome")) 
		{
			driver = new ChromeDriver();	
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	@BeforeMethod
	public void login() 
	{
		driver.findElement(By.className("ico-login")).click(); //Click on Log in button
		driver.findElement(By.id("Email")).sendKeys("nejkarpriya3376@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Priya@8989");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
	@AfterClass
	public void postCondition() 
	{
		driver.quit();
	}
}