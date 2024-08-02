package Task_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCard {
	public GiftCard(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	private @FindBy(xpath="(//a[contains(text(),'Gift Cards')])[1]")
	WebElement GiftCard;
	
	public void giftCard()
	{
		GiftCard.click(); 
	}
	
	private @FindBy(xpath = "(//input[@value='Add to cart'])[1]")
	WebElement AddtoCart1;
	public void cart1()
	{
		AddtoCart1.click();
	}
	
	private @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
	WebElement AddtoCart2;
	public void cart2()
	{
		AddtoCart2.click();
	}
	
	private @FindBy(xpath = "(//input[@value='Add to cart'])[3]")
	WebElement AddtoCart3;
	public void cart3()
	{
		AddtoCart3.click();
	}
	
	private @FindBy(xpath = "(//input[@value='Add to cart'])[4]")
	WebElement AddtoCart4;
	public void cart4()
	{
		AddtoCart4.click();
	}
	
	private @FindBy(id="giftcard_1_RecipientName")
	WebElement RecipientName;
	public void rName()
	{
		RecipientName.sendKeys("Gauri");;
	}
	
	private @FindBy(id="giftcard_1_RecipientEmail")
	WebElement recipientEmail;
	public void rEmail()
	{
		recipientEmail.sendKeys("gaurik@gmail.com");;
	}
	
	private @FindBy(id="giftcard_1_SenderName")
	WebElement SenderName;
	public void sName()
	{
		SenderName.sendKeys("Harshali");;
	}
	
	private @FindBy(id="giftcard_1_SenderEmail")
	WebElement senderEmail;
	public void sEmail()
	{
		senderEmail.sendKeys("harshalim@gmail.com");;
	}
	
	private @FindBy(id="giftcard_1_Message")
	WebElement GiftMsg;
	public void giftMsg()
	{
		GiftMsg.sendKeys("Happy Anniversary");;
	}
	
	private @FindBy(id="addtocart_1_EnteredQuantity")
	WebElement GiftQty;
	public void giftQty()
	{
		GiftQty.clear();
		GiftQty.sendKeys("4");
	}
	
	private @FindBy(xpath = "//input[@id='add-to-cart-button-1']")
	WebElement AddGiftToCart;
	public void addGift()
	{
		AddGiftToCart.click();
	}
	
	private @FindBy(className = "cart-label")
	WebElement cart_icon;
	
	public void cart()
	{
		cart_icon.click();
	}
	
	private @FindBy(xpath = "//input[@name='removefromcart']")
	WebElement RemoveFromCart;
	public void remove()
	{
		RemoveFromCart.click();
	}
	
	private @FindBy(xpath = "//input[@value='Update shopping cart']")
	WebElement UpdateCart;
	public void updateCart()
	{
		UpdateCart.click();
	}
	
	private @FindBy(id="termsofservice")
	WebElement AcceptTerms;
	public void accept()
	{
		AcceptTerms.click();
	}
	
	private @FindBy(id="checkout")
	WebElement ChekoutBtn;
	public void checkout()
	{
		ChekoutBtn.click();
	}

}
