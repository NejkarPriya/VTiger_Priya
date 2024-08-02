package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excelfile_shoppersstack_CreateAccount {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.shoppersstack.com/signup");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\Desktop\\Read Data.xlsx");
	Workbook workbook = WorkbookFactory.create(fileInputStream);

	 Sheet sheet = workbook.getSheet("Sheet2"); // To fetch data from excel

	ArrayList<String> arrayList = new ArrayList<String>();
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		arrayList.add(sheet.getRow(i).getCell(0).toString());
	}

	int i = 0;
//	driver.findElement(By.id("First Name")).sendKeys(arrayList.get(i++)) ;
//	driver.findElement(By.id("Last Name")).sendKeys(arrayList.get(i++)) ;
//	driver.findElement(By.id("Phone Number")).sendKeys(arrayList.get(i++)) ;
//	driver.findElement(By.id("Email Address")).sendKeys(arrayList.get(i++)) ;
//	driver.findElement(By.id("Password")).sendKeys(arrayList.get(i++)) ;
//	driver.findElement(By.id("Confirm Password")).sendKeys(arrayList.get(i++)) ;

	List<WebElement> elements = driver.findElements(By.xpath("//div/div/input"));
	for (WebElement webElement : elements) {
		webElement.sendKeys(arrayList.get(i++)) ;
	}

	driver.findElement(By.id(arrayList.get(i++))).click();
	driver.findElement(By.id("Terms and Conditions")).click();
	driver.findElement(By.id("Register")).click();	
	
	driver.quit();
}
}
