package genericUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author vinay
 *
 */
public class WebDriverUtility {

	WebDriver driver;
	JavascriptExecutor js;
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor) this.driver;
	}

	/**
	 * This method is used to click on the element by using javascript executor
	 * @param element
	 */
	public void clickingTheWebElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method is used to enter or send the data by using javascript executor
	 * @param element
	 * @param data
	 */
	public void enteringTheDataIntoElement(WebElement element, String data) {
		js.executeScript("arguments[0].value='"+data+"'", element);
	}

	/**
	 * This method is used to give the explicitly wait to the script
	 * This method will return the WebDriverWait Reference
	 * @param time to wait
	 * @return
	 */
	public WebDriverWait explicitWaitReference(int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait;
	}

	/**
	 * Use the actions method by this method
	 * @return action reference
	 */
	public Actions actionsReference() {
		Actions action =new Actions(driver);
		return action;
	}

	/**
	 * This method is used to Handle the DropDown
	 * @param element
	 * @param Value
	 */
	public void handlingTheDropDown(WebElement element, String Value) {
		Select select=new Select(element);
		try {
			select.selectByVisibleText(Value);
		}
		catch(Exception e) {
			try {
				select.selectByValue(Value);
			}
			catch(Exception a) {
				select.selectByIndex(Integer.parseInt(Value));
			}
		}
	}

	/**
	 * This method is used to scroll To Action
	 * @param x
	 * @param y
	 */
	public void scrollToAction(int x, int y) {
		js.executeScript("scrollTo("+x+","+y+");");
	}

	/**
	 * This method is used to scroll By Action
	 * @param x
	 * @param y
	 */
	public void scrollByAction(int x,int y) {
		js.executeScript("scrollBy("+x+","+y+");");
	}

	/**
	 * This method is used Scroll to view the element
	 * If the status is true then element which to be scrolled is reaches to the top
	 * If the status is false then element which to be scrolled is reaches to the bottom
	 * @param element
	 * @param status
	 */
	public void scrollIntoViewAction(WebElement element, boolean status) {
		js.executeScript("arguments[0].scrollIntoView("+status+");", element);
	}

	/**
	 * This method is used to switching to frame by using index as a parameter
	 * @param index
	 */
	public void switchingToframe(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switching to frame by using name/id as String Parameter
	 * @param name
	 */
	public void switchingToframe(String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * This method is used to switching to frame by using WebElement as a parameter
	 * @param element
	 */
	public void switchingToframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch back to main Window
	 */
	public void switchingBackToMainWindow() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to switching to alert pop-up by using this method we can use methods
	 * @return
	 */
	public Alert returnAlertReference() {
		return driver.switchTo().alert();
	}

	/**
	 * This method is used to Switch to any child Window
	 * @param allwindowID
	 * @param parentID
	 * @param expectedtitle
	 */
	public void switchingToTheChilWindow(Set<String> allwindowID,String parentID,String expectedtitle) {
		allwindowID.remove(parentID);
		for (String ID:allwindowID) {
			driver.switchTo().window(ID);
			if (expectedtitle.equalsIgnoreCase(driver.getTitle())) {
				break;
			}
		}
	}

	/**
	 * THis method is used to Switch the window control to Parent Window
	 * @param ParentID
	 */
	public void switchingBackToMainWindow(String ParentID) {
		driver.switchTo().window(ParentID);
	}
}
