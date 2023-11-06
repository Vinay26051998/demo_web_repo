package computers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Desktop_06_Test extends BaseClass{

	@Test
	public void Add_product_to_compare_and_remove_them() {
		WebElement computers = computerpage.getComputerslink();
		Actions action = webdriverUtility.actionsReference();
		action.moveToElement(computers).perform();
		computerpage.getDesktoplink().click();
		logger.log(Status.INFO, "User Navigate to the desktop module");
		computerpage.getProduct1().click();
		computerpage.getComparebutton().click();
		logger.log(Status.INFO, "User added product to compare list");
		driver.navigate().back();
		driver.navigate().back();
		computerpage.getProduct2().click();
		computerpage.getComparebutton().click();
		logger.log(Status.INFO, "User added product to compare list");
		computerpage.getRemovebutton().click();
		logger.log(Status.INFO, "User Removed product from the compare list");
		computerpage.getRemovebutton().click();
		logger.log(Status.INFO, "User Removed product from the compare list");
	}

}
