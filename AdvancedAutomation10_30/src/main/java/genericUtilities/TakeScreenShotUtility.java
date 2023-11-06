package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**'
 * 
 * @author vinay
 *
 */
public class TakeScreenShotUtility {

	WebDriver driver;
	TakesScreenshot ss;
	public TakeScreenShotUtility(WebDriver driver) {
		this.driver=driver;
		ss=(TakesScreenshot) this.driver;
	}
	
	/**
	 * This Method is develpoed to take the screen shot of the Webpage or WebElement
	 * @param screenshotName
	 * @return path of the screenshot
	 */
	public String capturingScreenShot(String screenshotName) {
		File photo = ss.getScreenshotAs(OutputType.FILE);
		String time = LocalDateTime.now().toString().replace(':', '-');
		String directory = System.getProperty("user.dir");
		String path=""+directory+"./target/errorshots/"+screenshotName+" "+time+ "+.png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(photo, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
