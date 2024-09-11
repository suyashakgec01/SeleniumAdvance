package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * Utility To read Data from excel
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 * @author Suyash
	 */
	public String getExcelData(String SheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		// step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fes);
		// step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet(SheetName);
		// step4:-taking Control of the rows
		Row row = sheet.getRow(rowNum);
		// step5:-taking Control of the cell
		Cell cell = row.getCell(celNum);
		String excelData = cell.getStringCellValue();
		return excelData;

	}

	public String getExcelDataUsingFormatter(String SheetName, int rowNum, int celNum) throws Throwable, IOException {
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(celNum);
		DataFormatter dataformat = new DataFormatter();
		String excelData = dataformat.formatCellValue(cell);
		return excelData;
	}

	public Object[][] getDataPrviderData(String SheetName) throws Throwable {
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(SheetName);
		int lastRowNumber = sheet.getLastRowNum()+1;
		int lastCellNumber = sheet.getRow(0).getLastCellNum();
		Object[][] objArr = new Object[lastRowNumber][lastCellNumber];
		for (int i = 0; i < lastRowNumber; i++) {
			for (int j = 0; j < lastCellNumber; j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
	}
}
