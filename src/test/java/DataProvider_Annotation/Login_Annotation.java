package DataProvider_Annotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Annotation {
	public class StoreData 
	{
	@DataProvider(name = "data")
	public Object [][] sender(){
		Object[][] obj = new Object[2][2];
		obj[0][0] = "admin01@gmail.com";
		obj[0][1] = "admin01";
		obj[1][0]="admin02@gmail.com";
		obj [1][1] = "admin02";
		return obj;
	}
	@Test(dataProvider = "data")
	public void receiver(String data1,String data2)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(data1);
		driver.findElement(By.id("Password")).sendKeys(data2);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.quit();
	}
}
}
