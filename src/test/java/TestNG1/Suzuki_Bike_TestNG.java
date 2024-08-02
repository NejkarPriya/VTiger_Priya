package TestNG1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Suzuki_Bike_TestNG {
	@Test(groups = "smoke")
	public void Suzuki() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.suzukimotorcycle.co.in/");	
		Thread.sleep(2000);
		driver.quit();
}
}