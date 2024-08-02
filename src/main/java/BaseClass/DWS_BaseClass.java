package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DWS_BaseClass 
{
	public static WebDriver driver;
	public static void CrossBrowser(String browser) 
	{
	if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}
	else {
		driver=new ChromeDriver();
	}
}
	public static void precondition() {
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	public static void dwslogin() throws InterruptedException 
	{
	   driver.findElement(By.className("ico-login")).click();
	   
	   driver.findElement(By.id("Email")).sendKeys("nejkarpriya3376@gmail.com");
	   
	   driver.findElement(By.id("Password")).sendKeys("Priya@8989");
	   
	   driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}

	public static void dwslogout()
	{
		driver.findElement(By.className("ico-logout")).click();
		driver.quit();	
	}

}
