package genericUtilities;

import java.util.Random;
/**
 * 
 * @author vinay
 *
 */
public class JavaUtility {
/**
 * This Method is developed to get the random number with in the given range
 * This method will take the parameter as the range in the form of integer
 * @param range
 * @return
 */
	public int getRandomNumber(int range) {
		Random r=new Random();

		return (r.nextInt(range));
	}
}
