package logIn;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Register_02_Test extends BaseClass{

	@Test(groups = "FT")
	public void Register_to_the_application_with_Valid_details() {
		registerpage.getRegisterlink().click();
		logger.log(Status.INFO, "User click on the Register link");
		registerpage.getMalebutton().click();
		registerpage.getFirstNameTF().sendKeys("Vinay");
		logger.log(Status.INFO, "User sends details to firstName");
		registerpage.getLastNameTF().sendKeys("D R");
		logger.log(Status.INFO, "User sends details to lastName");
		registerpage.getEmailTF().sendKeys("vinaydr26@gmail.com");
		logger.log(Status.INFO, "User sends details to email");
		registerpage.getPasswordTF().sendKeys("12345");
		registerpage.getConfirmPwdTF().sendKeys("12345");
		logger.log(Status.INFO, "User sends details to password");
		registerpage.getRegisterbutton().click();
	}
}
