package TestNG1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Bajaj_Bike_TestNG {
	@Test(groups = "smoke")
	public void Bajaj() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.bajajauto.com/");	
		Thread.sleep(2000);
		driver.quit();
	}
}
