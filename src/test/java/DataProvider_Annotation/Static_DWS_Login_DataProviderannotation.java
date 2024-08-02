package DataProvider_Annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Static_DWS_Login_DataProviderannotation {
	public class StoreData 
	{
	@DataProvider(name = "data")
	public Object [][] sender() throws IOException{
		Object[][] obj = new Object[2][2];// Static way
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\Read Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet("Sheet3");
		obj[0][0] = sheet.getRow(0).getCell(0).toString();
		obj[0][1] = sheet.getRow(0).getCell(1).toString();
		obj[1][0]=sheet.getRow(1).getCell(0).toString();
		obj [1][1] =sheet.getRow(1).getCell(1).toString();
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