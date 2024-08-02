package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleTestCase {

	@Test(priority = 1, invocationCount = 2, threadPoolSize = 2)
	public void dws() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");	
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(priority = 2, invocationCount = 2, threadPoolSize = 2)
	public void csk() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority = 0,invocationCount = 4, threadPoolSize = 6)
	public void rcb() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		Thread.sleep(2000);
		driver.quit();
	}
}
// If a class having multiple test cases then it will get executed with the alphabetical order of the method name
// If Rcb is named in cap then the execution will be based on the ASKI value.