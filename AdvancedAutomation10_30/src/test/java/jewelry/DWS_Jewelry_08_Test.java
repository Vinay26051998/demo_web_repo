package jewelry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Jewelry_08_Test extends BaseClass{

	@Test
	public void Email_a_friend_and_check_the_error_message() {
		jewelrypage.getJewelrylink().click();
		logger.log(Status.INFO, "User clicked the jewelry link");
		jewelrypage.getJewelryitem().click();
		logger.log(Status.INFO, "User clicked the jewelry product");
		jewelrypage.getEmailafriend().click();
		logger.log(Status.INFO, "User clicked the Email a friend button");
		jewelrypage.getFriendmail().sendKeys("asdfghjkl@gmail.com");
		logger.log(Status.INFO, "User entered the data into friend email textfeild");
		jewelrypage.getMymail().sendKeys("vinaydr580@gmail.com");
		logger.log(Status.INFO, "User entered the data into your email textfeild");
		jewelrypage.getSendemailbutton().click();
		logger.log(Status.INFO, "User clicked the send mail button");
		String expectedmsg="Only registered customers can use email a friend feature";
		WebElement errormsg = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/..//li"));
		if (errormsg.getText().equals(expectedmsg)) {
			System.out.println("The Test case is passed & Error message is displayed");
		}
	}
}
