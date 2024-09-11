package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelFile {
	public static void main(String[] args) throws Throwable {

		// Step 1: Path represtation of the Excel File
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Downloads\\TestData.xlsx");

		// Step 2: Keeping the Excel File in Read mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: Get the control of Sheet1
		Sheet s = wb.getSheet("Sheet1");

		// Step 4: Take Control of Row
		Row r = s.createRow(7);

		// Step 5: Take Control of Column
		Cell c = r.createCell(5);

		// Step 6: Insert the String value for that cell
		c.setCellValue("Qspiders");

		// Step 7: Keeping the Excel File in Write mode
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();

	}

}
