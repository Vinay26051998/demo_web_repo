package books;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListernersUtility;
@Listeners(ITestListernersUtility.class)
public class DWS_Books_04_Test extends BaseClass{

	@Test
	public void Add_a_book_to_the_cart() throws Throwable {
		bookspage.getBookslink().click();
		logger.log(Status.INFO, "User navigate to books link");
		bookspage.getAddtocartinbooks().click();
		logger.log(Status.INFO, "User Add book to cart successfully");
		Thread.sleep(5000);
		bookspage.getShoppingcartlink().click();
		if (welcomepage.getCheckoutbutton().isDisplayed()) {
			System.out.println("The Book is added to the cart");
		}
	}

}
