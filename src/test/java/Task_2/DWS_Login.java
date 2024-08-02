package Task_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_Login {
	public DwsLogin (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "ico-login")
	private WebElement login_link;
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(name = "Password")
	private WebElement password;
	
	@FindBy(css = "input[value='Log in']")
	private WebElement loginBtn;

	public WebElement getLogin_link() {
		return login_link;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void login_link()
	{
		getLogin_link().click();
	}
	
	public void username(String email)
	{
		getEmail().sendKeys(email);
	}
	
	public void password(String password)
	{
		getPassword().sendKeys(password);
	}
	
	public void loginBtn()
	{
		getLoginBtn().click();
	}
}
