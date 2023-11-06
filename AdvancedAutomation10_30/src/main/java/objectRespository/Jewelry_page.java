package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Jewelry_page {
	
	public Jewelry_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/jewelry']")
	private WebElement jewelrylink;
	
	@FindBy(xpath = "//a[contains(@href,'tricentis.com/jewelry?price=0-500')]")
	private WebElement filteroption;
	
	@FindBy(xpath = "//a[text()='Black & White Diamond Heart']")
	private WebElement jewelryitem;
	
	@FindBy(xpath = "//input[@value='Email a friend']")
	private WebElement emailafriend;
	
	@FindBy(id = "FriendEmail")
	private WebElement friendmail;
	
	@FindBy(id = "YourEmailAddress")
	private WebElement mymail;
	
	@FindBy(name = "send-email")
	private WebElement sendemailbutton;
	
	@FindBy(xpath = "//input[contains(@id,'add-to-wishlist')]")
	private WebElement addwishlistbutton;

	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishlistlink;
	
	@FindBy(xpath = "//input[@name='removefromcart' and @type='checkbox']")
	private WebElement removecheck;
	
	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updateTheWishList;
	
	@FindBy(xpath = "//div[contains(text(),'is empty!')]")
	private WebElement message;

	public WebElement getJewelrylink() {
		return jewelrylink;
	}

	public WebElement getFilteroption() {
		return filteroption;
	}

	public WebElement getJewelryitem() {
		return jewelryitem;
	}

	public WebElement getEmailafriend() {
		return emailafriend;
	}

	public WebElement getFriendmail() {
		return friendmail;
	}

	public WebElement getMymail() {
		return mymail;
	}

	public WebElement getSendemailbutton() {
		return sendemailbutton;
	}

	public WebElement getAddwishlistbutton() {
		return addwishlistbutton;
	}

	public WebElement getWishlistlink() {
		return wishlistlink;
	}

	public WebElement getRemovecheck() {
		return removecheck;
	}

	public WebElement getUpdateTheWishList() {
		return updateTheWishList;
	}

	public WebElement getMessage() {
		return message;
	}
	
}
