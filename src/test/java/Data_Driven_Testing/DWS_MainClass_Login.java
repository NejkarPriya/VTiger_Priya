package Data_Driven_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import BaseClass.DWS_BaseClass;

public class DWS_MainClass_Login extends DWS_BaseClass{
public static void main(String[] args) throws InterruptedException {
	
	String given_url = "https://demowebshop.tricentis.com/";
	CrossBrowser("chrome");
	Thread.sleep(2000);

	// precondition
	precondition();
	Thread.sleep(2000);

	// Verification
	String current_url = driver.getCurrentUrl();
	if (given_url.equals(current_url)) {

		System.out.println("Given url is matching");
	}

	else {
		System.out.println("Given url is not matching");
	}

	dwslogin();

	//Scroll Down
	Actions actions = new Actions(driver);
	actions.keyDown(Keys.PAGE_DOWN).build().perform();

	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click(); // Click on Add to Cart
	Thread.sleep(1000);
	driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys("Priya");// To send the 
	Thread.sleep(1000);
	driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys("nejkarpriya3376@gmail.com");
	Thread.sleep(1000);
	driver.findElement(By.id("giftcard_2_Message")).sendKeys("Hi");
	Thread.sleep(1000);
	driver.findElement(By.id("addtocart_2_EnteredQuantity")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("addtocart_2_EnteredQuantity")).sendKeys("5");
	driver.findElement(By.id("add-to-cart-button-2")).click();
	Thread.sleep(1000);
	actions.keyDown(Keys.PAGE_UP).build().perform();
	driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

	if (driver.findElement(By.xpath("//td/a[text()='$25 Virtual Gift Card']")).isDisplayed()) {
		System.out.println("Product added successfully");
	} else {
		System.out.println("Product not been added successfully");
	}
	
	dwslogout();
}	
}
