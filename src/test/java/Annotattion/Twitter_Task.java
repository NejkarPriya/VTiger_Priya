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

public class Twitter_Task extends FacebookDWS {
	@Test
	public void fillTwitter() 
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
			
			int row = 0;
			String dwsID = null;
			 Set<String> ids = driver.getWindowHandles();
			for (String i : ids) {
				
				if((driver.switchTo().window(i).getCurrentUrl()).equalsIgnoreCase("https://x.com/nopCommerce")) {
					driver.findElement(By.xpath("//span[text()='Create account']")).click();
					
					driver.findElement(By.name("name")).sendKeys(ExcelUtility.getData("DWS_TW", row++, 0));
					driver.findElement(By.name("phone_number")).sendKeys(ExcelUtility.getData("DWS_TW", row++, 0));
					
					Select month = new Select(driver.findElement(By.xpath("(//div[@aria-label=\"Date of birth\"])[2]/div[1]/select")));
					month.selectByVisibleText(ExcelUtility.getData("DWS_TW", row++, 0));
					
					Select day = new Select(driver.findElement(By.xpath("(//div[@aria-label=\"Date of birth\"])[2]/div[2]/select")));
					day.selectByValue(String.valueOf((int)Double.parseDouble(ExcelUtility.getData("DWS_TW", row++, 0))));
					
					Select year = new Select(driver.findElement(By.xpath("(//div[@aria-label=\"Date of birth\"])[2]/div[3]/select")));
					year.selectByVisibleText(String.valueOf((int)Double.parseDouble(ExcelUtility.getData("DWS_TW", row++, 0))));
					
					Thread.sleep(4000);
				}
				
				if((driver.getCurrentUrl()).equalsIgnoreCase("https://demowebshop.tricentis.com/"))
				{
					dwsID = i;
				}
			}
			
			driver.switchTo().window(dwsID);
			
		}
		else 
		{
			System.out.println("You are not in DWS landing page");
		}
	}
