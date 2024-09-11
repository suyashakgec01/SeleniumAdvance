package Programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadAllLinksFromWebsite {
	public static void main(String[] args) throws Throwable {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("https://www.amazon.in/");
		FileInputStream fis = new FileInputStream("./src/test/resources/AllLinks.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AllLinks.xlsx");
		int i = 0;
		List<WebElement> noOfLinks = wb.findElements(By.xpath("//a"));
		System.out.println(noOfLinks.size());
		for (WebElement link : noOfLinks) {
			String href = link.getAttribute("href");
			book.getSheet("Sheet1").createRow(i).createCell(0).setCellValue(href);
			System.out.println(href);
			i++;
		}
		book.write(fos);
		book.close();
		wb.close();
	}

}
