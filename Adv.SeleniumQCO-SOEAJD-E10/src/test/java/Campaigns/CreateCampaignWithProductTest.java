package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.CampaignProductPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;

public class CreateCampaignWithProductTest extends BaseClass {
	// Login to vtiger application->mouseOverOn more Link->click on campaigns->click
	// on create campaign lookup image->Enter campaignName->Click on Product plus
	// img->Handle the PopUp->Product name should be added to campaign createpage->
	// click on save Btn->verify whether the campaign is created in campaign
	// Information page and Logout from the application.

	@Test
	public void createCampaignWithProductTest() throws Throwable {
//		WebDriver wd = new ChromeDriver();
//		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
//		Properties p = new Properties();
//		p.load(fis);
//		wd.get(p.getProperty("url"));
//		wd.manage().window().maximize();
//		// Login To Vtiger Application
//		wd.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
//		wd.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
//		wd.findElement(By.id("submitButton")).click();
//		// Click on Campaingns Link
//		Actions act = new Actions(wd);
//		act.moveToElement(wd.findElement(By.linkText("More"))).click().perform();
//		wd.findElement(By.xpath("//a[@name='Campaigns']")).click();
//		// Click on Create Campaign Lookup Image
//		wd.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//		// To Avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
//		// Create Campaign Data
//		wd.findElement(By.name("campaignname")).sendKeys(p.getProperty("campaignName") + ranNum);
//		// To Click on Save Button
//		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		// To LogOut From Application
//		Thread.sleep(2000);
//		wd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		wd.findElement(By.linkText("Sign Out")).click();
//		wd.close();

//		WebDriver wd = new ChromeDriver();

		ExcelUtility eU = new ExcelUtility();
//		FileUtility fU = new FileUtility();
		JavaUtility jU = new JavaUtility();
		WebDriverUtility wDU = new WebDriverUtility();
//		LoginPage lp = new LoginPage(wd);
		HomePage hp = new HomePage(wd);
		ProductPage pp = new ProductPage(wd);
		CreateProductPage cpp = new CreateProductPage(wd);
		CampaignPage cp = new CampaignPage(wd);
		CreateCampaignPage ccp = new CreateCampaignPage(wd);
		CampaignProductPage capp = new CampaignProductPage(wd);

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

		// To Avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		int ranNum = jU.getRandomNum();

//		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Product");
//		Row row = sheet.getRow(0);
//		Cell cel = row.getCell(0);
//		String prdName = cel.getStringCellValue() + ranNum;
//		System.out.println(prdName);
		String prdName = eU.getExcelData("Product", 0, 0) + ranNum;

		// Create Product Data
//	    wd.findElement(By.name("productname")).sendKeys(prdName);
		cpp.enterProductName(prdName);

		// To Click on Save Button
//				wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cpp.clickOnProSaveButton();

		// To create Campaign
//		WebElement link = wd.findElement(By.linkText("More"));
//		wDU.moveToElementAction(wd, link);
//		wd.findElement(By.linkText("Campaigns")).click();
		hp.getMoreLink().click();
		hp.getCampaignLink().click();

		// Click on Create Campaign Lookup Image
//		wd.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		cp.clickOnCampaignPlusIcon();

//		FileInputStream fes1 = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook book1 = WorkbookFactory.create(fes1);
//		Sheet sheet1 = book1.getSheet("Campaigns");
//		Row row1 = sheet1.getRow(0);
//		Cell cel1 = row1.getCell(0);
//		String campName = cel1.getStringCellValue() + ranNum;
//		System.out.println(campName);

		String campName = eU.getExcelData("Campaign", 0, 0) + ranNum;
//		wd.findElement(By.name("campaignname")).sendKeys(campName);
		ccp.enterCampName(campName);

		// Click on Create Product Lookup Image
//		wd.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		ccp.clickProductPlusSign();

//		Set<String> allWin = wd.getWindowHandles(); // win1,win2
//		Iterator<String> it = allWin.iterator();
//		while (it.hasNext()) {
//			String win = it.next();
//			wd.switchTo().window(win);
//			String currentTitle = wd.getTitle();
//
//			if (currentTitle.contains("Products&action")) {
//				break;
//			}
//		}

		wDU.switchingWindows(wd, "Products&action");

//		wd.findElement(By.name("search_text")).sendKeys(prdName);
//		wd.findElement(By.xpath("//input[@type=\"button\"]")).click();
//		wd.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		capp.enterProductName(prdName);
		capp.clickSearchPrdName();
		capp.chooseProduct(wd, prdName);

//		Set<String> allWin1 = wd.getWindowHandles(); // win1,win2
//		Iterator<String> it1 = allWin1.iterator();
//		while (it1.hasNext()) {
//			String win1 = it1.next();
//			wd.switchTo().window(win1);
//			String currentTitle = wd.getTitle();
//
//			if (currentTitle.contains("Campaigns&action")) {
//				break;
//			}
//		}

		wDU.switchingWindows(wd, "Campaigns&action");
		// To Click on Save Button
//		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ccp.clickOnCampSaveButton();

		String actualCampName = cp.validateCampaignCreation(wd);
		Assert.assertEquals(actualCampName, campName, "Campaign Is not Created");

		// To LogOut From Application
//		wd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		wd.findElement(By.linkText("Sign Out")).click();
		hp.signOutFromVtiger();
		wd.close();
	}
}
