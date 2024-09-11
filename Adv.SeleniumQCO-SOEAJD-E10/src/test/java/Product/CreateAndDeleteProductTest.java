package Product;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;

public class CreateAndDeleteProductTest extends BaseClass {

	@Test
	public void createAndDeleteProductTest() throws Throwable {

//		WebDriver wd = new ChromeDriver();

		ExcelUtility eU = new ExcelUtility();
//		FileUtility fU = new FileUtility();
		JavaUtility jU = new JavaUtility();
		WebDriverUtility wDU = new WebDriverUtility();
//		LoginPage lp = new LoginPage(wd);
		HomePage hp = new HomePage(wd);
		ProductPage pp = new ProductPage(wd);
		CreateProductPage cpp = new CreateProductPage(wd);

//		wd.manage().window().maximize();
//		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wDU.maximizeWindow(wd);
//		wDU.waitPageToLoad(wd);

		// reading data from properties file
//      //step1:-get the java representation object of the physical file
//		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
//
//		// step2:-create an object to property class to load all the keys
//		Properties pro = new Properties();
//		pro.load(fis);
//
//		// step3:-read the value using getProperty()
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");

//		String URL = fU.getPropertiesData("url");
//		String USERNAME = fU.getPropertiesData("username");
//		String PASSWORD = fU.getPropertiesData("password");
//
//		wd.get(URL);
//		wd.findElement(By.name("user_name")).sendKeys(USERNAME);
//		wd.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		wd.findElement(By.id("submitButton")).click();

		// using business logics
//		lp.loginToVtiger(USERNAME, PASSWORD);

		// Click on Products Link
//		wd.findElement(By.linkText("Products")).click();
		hp.getProductLink().click();

		// Click on Create Product Lookup Image
//		wd.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		pp.clickOnPlusIcon();

		// TO avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		int ranNum = jU.getRandomNum();

		// Reading Data from Excel
//		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
//		// step2:-keep excel file in read mode
//		Workbook book = WorkbookFactory.create(fes);
//		// step3:-taking Control of the excel sheet
//		Sheet sheet = book.getSheet("Product");
//		// step4:-taking Control of the rows
//		Row row = sheet.getRow(0);
//		// step5:-taking Control of the cell
//		Cell cel = row.getCell(0);
//
//		String prdName = cel.getStringCellValue() + ranNum;
		String prdName = eU.getExcelData("Product", 0, 0) + ranNum;

//		wd.findElement(By.name("productname")).sendKeys(prdName);
		cpp.enterProductName(prdName);

		// To Click on Save Button
//		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cpp.clickOnProSaveButton();

		// Navigating to product table
//		wd.findElement(By.linkText("Products")).click();
		hp.getProductLink().click();

		// driver.findElement(By.xpath("//table[@class='lvt
		// small']/tbody/tr//td//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();

		// Dynamic xpath
//		wd.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prdName
//				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		pp.deleteProduct(wd, prdName);

		// click on delete button
//		wd.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		// Hndling Alert popup(Accept)
//		wd.switchTo().alert().accept();

		pp.clickOnDeleteButton(wDU, wd);

//		Thread.sleep(2000);
//		List allNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody//tr//td[3])[position()>1]"));
//	    boolean flag = false;
//	
//	for (WebElement name : allNames)
//	{
//		String actData = name.getText();
//		if(actData.contains(prdName))
//		{
//			flag=true;
//			break;
//		}
//	}
//	if(flag)
//	{
//		System.out.println("product name is deleted");
//	}
//	else
//	{
//		System.out.println("product name is not deleted");
//	}

//		List<WebElement> productList = wd
//				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
//		System.out.println(productList.size());
//		boolean flag = false;
//
//		for (WebElement prdName1 : productList) {
//			String actualData = prdName1.getText();
//			System.out.println(actualData);
//			if (actualData.contains(prdName)) {
//				flag = true;
//				break;
//			}
//		}
//		if (flag) {
//			System.out.println("product data is not deleted");
//		} else {
//			System.out.println("product data is deleted");
//		}

		pp.validateProductDeletion(wd, prdName);

//		hp.signOutFromVtiger();
//		wd.quit();
	}

}