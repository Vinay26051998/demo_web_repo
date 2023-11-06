package logIn;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Login_01_Test extends BaseClass{
	@Test(dataProvider = "data",dataProviderClass = ExcelUtility.class)
	public void Login_to_application_with_valid_credentials(String username,String password) {
		loginpage.getLoginlink().click();
		logger.log(Status.INFO, "User click on the login link");
		loginpage.getEmailTF().sendKeys(username);
		logger.log(Status.INFO, "User sends the credentials to email text field");
		loginpage.getPasswordTF().sendKeys(password);
		logger.log(Status.INFO, "User sends the credentials to password text field");
		loginpage.getLogin_button().click();
	}

}
