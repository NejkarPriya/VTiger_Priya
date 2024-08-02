package Extent_Report;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.Listener1.ReportWithMultipleTestCase.class)// To create a connection in to class
public class ExecuteWithListeners {
@Test
public void dominos() throws InterruptedException {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://pizzaonline.dominos.co.in/");
Reporter.log("my stomach is hungry",true);
Thread.sleep(2000);
}

@Test(timeOut = 1000)
public void rcb() throws InterruptedException {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://www.royalchallengers.com/");
Reporter.log("rcb is hungry for cup", true);
Thread.sleep(2000);
}

@Test (dependsOnMethods = "rcb")
public void csk() {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://www.chennaisuperkings.com/");
Reporter.log("when thala will retire",true);
}
}