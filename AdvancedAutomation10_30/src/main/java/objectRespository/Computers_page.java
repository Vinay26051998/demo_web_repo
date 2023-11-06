package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Computers_page {

	public Computers_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='/computers'])[1]")
	private WebElement computerslink;
	
	@FindBy(xpath = "(//a[@href='/desktops'])[1]")
	private WebElement desktoplink;
	
	@FindBy(xpath = "//a[contains(text(),'Build your own computer')]")
	private WebElement product1;
	
	@FindBy(xpath = "//input[@value='Add to compare list']")
	private WebElement comparebutton;
	
	@FindBy(xpath = "//a[text()='Desktop PC with CDRW']")
	private WebElement product2;
	
	@FindBy(xpath = "//input[@value='Remove']")
	private WebElement removebutton;

	public WebElement getComputerslink() {
		return computerslink;
	}

	public WebElement getDesktoplink() {
		return desktoplink;
	}

	public WebElement getProduct1() {
		return product1;
	}

	public WebElement getComparebutton() {
		return comparebutton;
	}

	public WebElement getProduct2() {
		return product2;
	}

	public WebElement getRemovebutton() {
		return removebutton;
	}
}



