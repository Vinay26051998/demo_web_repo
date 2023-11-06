package jewelry;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Jewelry_09_Test extends BaseClass{

	@Test
	public void Add_product_to_wishlist_and_check_it_is_added() throws Throwable {
		jewelrypage.getJewelrylink().click();
		logger.log(Status.INFO, "User clicked the jewelry link");
		jewelrypage.getJewelryitem().click();
		logger.log(Status.INFO, "User clicked the jewelry product");
		jewelrypage.getAddwishlistbutton().click();
		logger.log(Status.INFO, "User clicked the Add wishlist");
		Thread.sleep(3000);
		jewelrypage.getWishlistlink().click();
		logger.log(Status.INFO, "User clicked the wishlist link");
		if (jewelrypage.getJewelryitem().isDisplayed()) {
			System.out.println("The product is added to the wishlist");
		}
	}
}
