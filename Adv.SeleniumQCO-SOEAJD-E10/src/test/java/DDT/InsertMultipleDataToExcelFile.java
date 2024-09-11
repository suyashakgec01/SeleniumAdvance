package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataToExcelFile {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet1");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		List<WebElement> noOfLinks = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < noOfLinks.size(); i++) {
			Row r = s.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(noOfLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AllLinks.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();
	}
}
