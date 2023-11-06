package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author vinay
 *
 */
public class PropertyUtility implements IAutoConstents
{
	/**
	 * This method is developed to read the data from the property file
	 * This method will take String as parameter what to fetch
	 * @param Key
	 * @return Value of the Key
	 */
	public String getDataFromPropertyFile(String Key) {
		FileInputStream fis = null;
		try {
			fis =new FileInputStream(PROPERTY_FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property.getProperty(Key);
	}

}
