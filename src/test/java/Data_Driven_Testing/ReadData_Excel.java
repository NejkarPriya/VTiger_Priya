package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_Excel {
public static void main(String[] args) throws IOException {
	
	FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\Read Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	String email = sheet.getRow(0).getCell(0).toString();
	String passsword = sheet.getRow(0).getCell(1).toString();
	System.out.println(email);
	System.out.println(passsword);

}
}
