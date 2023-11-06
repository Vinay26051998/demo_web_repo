package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
/**
 * 
 * @author vinay
 *
 */
public class ExcelUtility implements IAutoConstents {

	/**
	 * This method is used to read the data from Excel file and it is used as the DataProviders
	 * @return
	 */
	@DataProvider(name = "data")
	public Object[][] readingTheDataFromExcel() {
		Workbook workbook = null; 
		File file=new File(EXCEL_FILE_PATH);
		try {
		workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj=new Object[rowcount][cellcount];
		for (int row=0;row<rowcount;row++) {
			Row actrow = sheet.getRow(row);
			for (int cell=0;cell<actrow.getPhysicalNumberOfCells();cell++) {
				obj[row][cell]=actrow.getCell(cell).toString();
			}
		}
		return obj;
	}
	
}
