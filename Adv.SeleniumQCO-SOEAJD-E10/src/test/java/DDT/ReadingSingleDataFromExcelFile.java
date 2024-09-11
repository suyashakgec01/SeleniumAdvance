package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingSingleDataFromExcelFile {
	public static void main(String[] args) throws Throwable {

		// Step 1: Path represtation of the Excel File
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Downloads\\TestData.xlsx");

		// Step 2: Keeping the Excel File in Read mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: Get the control of Sheet1
		Sheet s = wb.getSheet("Sheet1");

		// Step 4: Get the control of Row
		Row r = s.getRow(0);

		// Step 5: Get the control of Column
		Cell c = r.getCell(0);

		// Step 6: Get the String value from that cell
		String brand = c.getStringCellValue();
		wb.close();

		System.out.println(brand);

	}

}
