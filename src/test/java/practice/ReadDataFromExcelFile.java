package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step 1 : Open the document in java readable in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		
		// step 2 : Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		// step 3 : Navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		// step 4 : Navigate to required row
		Row rw = sh.getRow(1);
		
		// step 5 : Navigate to required cell
		Cell cl = rw.getCell(2);
		
		// Step 6 : Capture the data inside the cell
		String value = cl.getStringCellValue();
		System.out.println(value);
	

	}

}
