package Data_Driven_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Function_Shoppersstack {
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.shoppersstack.com/");
	Thread.sleep(2000);
	driver.findElement(By.id("loginBtn")).click();
	driver.findElement(By.id("Email")).sendKeys("nejkarpriya3376@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Priya@8989");
	driver.findElement(By.linkText("//span[text()='Login']")).click();
	
}
}
