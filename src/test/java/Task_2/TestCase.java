package Task_2;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Annotattion.ExcelUtility;

public class TestCase {
	@Listeners(Task2.BasicListeners.class)
	public class Task1 extends BaseClassForLoginAndRegister{

		ExcelUtility eUtil = new ExcelUtility();
		@Test
		public void register() throws EncryptedDocumentException, IOException
		{
			int row = 0;
			assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
			
			Register reg = new Register(driver);
			reg.register();
			reg.genderM();
			reg.firstName(eUtil.getData("DWS_R", row++, 0));
			reg.lastName(eUtil.getData("DWS_R", row++, 0));
			reg.email(eUtil.getData("DWS_R", row++, 0));
			reg.pass(eUtil.getData("DWS_R", row++, 0));
			reg.confirmPassword(eUtil.getData("DWS_R", row++, 0));
			reg.registerBtn();
			
		}
}
}