package genericUtilities;

import java.io.FileInputStream; 
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic related to excel file
 * @author kabali
 * 
 */
public class ExcelFileUtility {
	/**
	 * This method consists of excel file and return the value to caller
	 * @param SheetName
	 * @param rowNO
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String SheetName, int rowNO, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNO).getCell(cellNo).getStringCellValue();
		return value;
		
		
	}

}
