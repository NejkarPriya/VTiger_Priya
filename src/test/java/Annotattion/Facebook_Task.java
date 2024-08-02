package Annotattion;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.FacebookDWS;

public class Facebook_Task extends FacebookDWS{
	@Test
	public void fillFacebookDetails() throws InterruptedException
	{
		if((driver.getCurrentUrl()).equalsIgnoreCase("https://demowebshop.tricentis.com/")) {
			System.out.println("You are in DWS landing page");
			
			Actions act = new Actions(driver);
			act.keyDown(Keys.PAGE_DOWN).build().perform();
			act.keyDown(Keys.PAGE_DOWN).build().perform();
			 List<WebElement> followUs = driver.findElements(By.xpath("//div[contains(@class,'column follow-us')]/ul/li/a"));
			
			for(WebElement link:followUs)
			{
				Thread.sleep(1000);
				link.click();
				if("https://demowebshop.tricentis.com/news/rss/1".equals(driver.getCurrentUrl()))
				{
					driver.navigate().back();
				}
			}
			
			String parentDWS = null;
			int row = 0;
			
		 Set<String> ids = driver.getWindowHandles();
			for (String i : ids) {		
				driver.switchTo().window(i);
				
				if("https://demowebshop.tricentis.com/".equals(driver.getCurrentUrl())) {
					parentDWS = i;
				}
				
				if("https://www.facebook.com/nopCommerce".equalsIgnoreCase(driver.getCurrentUrl()))
				{
					driver.findElement(By.xpath("//span[text()='Create new account']")).click();
					
					Set<String> ids1 = driver.getWindowHandles();
					for (String i2 : ids1) {
						
						driver.switchTo().window(i2);
						if ("https://www.facebook.com/reg/?next=%2FnopCommerce".equals(driver.getCurrentUrl())) {
							driver.findElement(By.name("firstname")).sendKeys(ExcelUtility.getData("DWS_FB", row++, 0));
						    driver.findElement(By.name("lastname")).sendKeys(ExcelUtility.getData("DWS_FB", row++, 0));
						    driver.findElement(By.name("reg_email__")).sendKeys(ExcelUtility.getData("DWS_FB", row++, 0));
						    driver.findElement(By.name("reg_passwd__")).sendKeys(ExcelUtility.getData("DWS_FB", row++, 0));
						    Thread.sleep(2000);
						    
						    WebElement Dd = driver.findElement(By.name("birthday_day"));
							Select date = new Select(Dd);
							String d= String.valueOf((int)Double.parseDouble(ExcelUtility.getData("DWS_FB", row++, 0)));
							date.selectByVisibleText(d);
							
							WebElement Mm = driver.findElement(By.id("month"));
						    Select month = new Select(Mm);
						    int a = (int)Double.parseDouble(ExcelUtility.getData("DWS_FB", row++, 0));
						    System.out.println(a);
						    month.selectByIndex(a);
						         
						    WebElement yyyy = driver.findElement(By.id("year"));
						    Select year =new Select(yyyy);
						    System.out.println(ExcelUtility.getData("DWS_FB", row, 0));
						    String yy = String.valueOf((int)Double.parseDouble(ExcelUtility.getData("DWS_FB", row++, 0)));
						    year.selectByValue(yy);
						     
						    Thread.sleep(2000);
						    driver.findElement(By.xpath("//input[@value='2']")).click();
					}
				}
				
			}
				driver.switchTo().window(parentDWS);
		}	
	}else {
		System.out.println("You are not in DWS landing page");
	}
 }
}
