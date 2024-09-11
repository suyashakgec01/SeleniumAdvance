package Product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {

	// . Login to vtiger application->click on products link->click on create
	// product lookup image->Enter product name->click on save Btn->verify whether
	// the product is created in product Information page and Logout from the
	// application.
//	@Test(groups = { "SmokeTest", "RegressionTest" })
	@Test
	public void createProductTest() throws Throwable {
//		WebDriver wd = new ChromeDriver();

		ExcelUtility eU = new ExcelUtility();
//		FileUtility fU = new FileUtility();
		JavaUtility jU = new JavaUtility();
//		WebDriverUtility wDU = new WebDriverUtility();
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

		// To Avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		int ranNum = jU.getRandomNum();

		// Create Product Data
		String prdName = eU.getExcelData("Product", 0, 0) + ranNum;
//		wd.findElement(By.name("productname")).sendKeys(prdName);
		cpp.enterProductName(prdName);

		// To Click on Save Button
//		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cpp.clickOnProSaveButton();
		String actualprdName = pp.validateProductCreation(wd);
		Assert.assertEquals(actualprdName, prdName, "Product Is not Created"); // Hard Assertion
//		Assert.assertEquals(actualprdName, prdName); //Hard Assertion without any Fail Msg

		// Assert.assertEquals(actualprdName, prdName);
		// Assert.assertEquals(actualprdName, prdName+ranNum, "ScriptFailed");

		// Assert.assertEquals(actualprdName, prdName, "PrdPass");
		// Assert.assertEquals(false, true, "AssertFailed");

		// To LogOut From Application
		Thread.sleep(2000);
//		wd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		wd.findElement(By.linkText("Sign Out")).click();
//		hp.signOutFromVtiger();
//		wd.close();

	}
}
