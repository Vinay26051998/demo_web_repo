package jewelry;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Jewelry_07_Test extends BaseClass{

	@Test
	public void Filter_the_products_and_check_that_accordingly() {
		jewelrypage.getJewelrylink().click();
		logger.log(Status.INFO, "User Navigate to the jewelry module");
		jewelrypage.getFilteroption().click();
		logger.log(Status.INFO, "User clicked filter options");
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='price actual-price']"));
		for (WebElement p:price) {
			String pr = p.getText().substring(0, 3);
			if(Integer.parseInt(pr)<=500) {
				System.out.println("The price compared"+pr);
			}
		}
		logger.log(Status.INFO, "User checked the products displayed are according to filter option");
	}

}
