package Data_Driven_Testing;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Function_Tricentis {
public static void main(String[] args) throws IOException, InterruptedException {
	
	//Properties prop = new Properties(); // Create a object
	//FileInputStream fis = new FileInputStream(".\\Configurefile\\LoginFunction.properties"); // Location of the file
	//prop.load(fis);
	//String email = prop.getProperty("email");
	//System.out.println(email);
	//String password = prop.getProperty("password");
	//System.out.println("password");
	
	String email = Javautility_Class_Tricentis.logindata("email");
	String password = Javautility_Class_Tricentis.logindata("password");
	
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	Thread.sleep(2000);
	driver.findElement(By.className("ico-login")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("Email")).sendKeys(email);
	driver.findElement(By.id("Password")).sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	
	driver.quit();	
}
}
