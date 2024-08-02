package Task_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	public Register(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	private @FindBy(className = "ico-register")
	WebElement register_link;
	
	public void register()
	{
		register_link.click();
	}
	
	private @FindBy(id="gender-female")
	WebElement GenderF;
	
	public void genderF()
	{
		GenderF.click();
	}
	
	private @FindBy(id="gender-male")
	WebElement GenderM;
	
	public void genderM()
	{
		GenderM.click();
	}
	
	private @FindBy(id="FirstName")
	WebElement FirstName;
	
	public void firstName(String firstName)
	{
		FirstName.sendKeys(firstName);
	}
	
	private @FindBy(id="LastName")
	WebElement LastName;
	
	public void lastName(String lastName)
	{
		LastName.sendKeys(lastName);;
	}
	
	private @FindBy(id="Email")
	WebElement email;
	
	public void email(String mail)
	{
		email.sendKeys(mail);;
	}
	
	private @FindBy(id="Password")
	WebElement pass;
	
	public void pass(String password)
	{
		pass.sendKeys(password);;
	}
	
	private @FindBy(id = "ConfirmPassword")
	WebElement conPass;
	
	public void confirmPassword(String confirmPassword)
	{
		conPass.sendKeys(confirmPassword);
	}
	
	private @FindBy(id="register-button")
	WebElement RegisterBtn;
	
	public void registerBtn()
	{
		RegisterBtn.click();
	}
}
