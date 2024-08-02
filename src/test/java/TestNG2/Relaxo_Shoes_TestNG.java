package TestNG2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Relaxo_Shoes_TestNG {
	@Test(groups = "Regression")
	public void Relaxo() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.relaxofootwear.com/collection/brand-sparx");	
		Thread.sleep(2000);
		driver.quit();
}
}