package Organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import ObjectRepository.CreateOrganizationsPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationsPage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	// Login to vtiger application->click on organizations link->click on create
	// organization lookup image->Enter organisation name,phone number and
	// email->click on save Btn->verify whether the organization is created in
	// Organization Information page and Logout from the application.

//	@Test(groups = "RegressionTest")
	@Test(retryAnalyzer = GenericUtilities.RetryImplementation.class)
	public void createOrganizationTest() throws Throwable {
//		WebDriver wd;
		ExcelUtility eU = new ExcelUtility();
//		FileUtility fU = new FileUtility();
		JavaUtility jU = new JavaUtility();
//		WebDriverUtility wDU = new WebDriverUtility();
//		String BROWSER = fU.getPropertiesData("browser");

//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			wd = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			wd = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			wd = new EdgeDriver();
//		} else {
//			wd = new ChromeDriver();
//		}
//		LoginPage lp = new LoginPage(wd);
		HomePage hp = new HomePage(wd);
		OrganizationsPage op = new OrganizationsPage(wd);
		CreateOrganizationsPage cop = new CreateOrganizationsPage(wd);

//		wd.manage().window().maximize();
//		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wDU.maximizeWindow(wd);
//		wDU.waitPageToLoad(wd);

		// reading data from properties file
//      //step1:-get the java representation object of the physical file
//		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");

//		// step2:-create an object to property class to load all the keys
//		Properties pro = new Properties();
//		pro.load(fis);

//		// step3:-read the value using getProperty()
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");

//		String URL = fU.getPropertiesData("url");
//		String USERNAME = fU.getPropertiesData("username");
//		String PASSWORD = fU.getPropertiesData("password");

//		wd.get(URL);
//		wd.findElement(By.name("user_name")).sendKeys(USERNAME);
//		wd.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		wd.findElement(By.id("submitButton")).click();

		// using getter methods
//		LoginPage login = new LoginPage(wd);
//		login.getUsernameTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();

		// using business logics

//		lp.loginToVtiger(USERNAME, PASSWORD);

		// click on organization link
//		wd.findElement(By.linkText("Organizations")).click();
		hp.getOrgLink().click();

		// Click on Lookup Image
//		wd.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		op.clickOnCreateOrg();

		// To Avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		int ranNum = jU.getRandomNum();

		// Create Organization Data
//		wd.findElement(By.name("accountname")).sendKeys(p.getProperty("organiztionName") + ranNum);
//		wd.findElement(By.id("phone")).sendKeys(p.getProperty("phoneNo"));
//		wd.findElement(By.id("email1")).sendKeys(p.getProperty("emailID"));

		// Create Organization Data using excel
		// To Read Org name from excel file
//		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fes);
//		Sheet s = wb.getSheet("Organization");
//		Row r = s.getRow(0);
//		Cell c = r.getCell(0);
//		wd.findElement(By.name("accountname")).sendKeys(c.getStringCellValue() + ranNum);
//
//		// To Read Org phoneNo from excel file
//		Row r1 = s.getRow(1);
//		Cell c1 = r1.getCell(0);
//		DataFormatter dataformat = new DataFormatter();
//		wd.findElement(By.id("phone")).sendKeys(dataformat.formatCellValue(c1));
//
//		// To Read Org emailID from excel file
//		Row r2 = s.getRow(2);
//		Cell c2 = r2.getCell(0);
//		wd.findElement(By.id("email1")).sendKeys(c2.getStringCellValue());

		String OrgName = eU.getExcelData("Organization", 0, 0) + ranNum;
		String phnNum = eU.getExcelDataUsingFormatter("Organization", 1, 0);
		String mailId = eU.getExcelDataUsingFormatter("Organization", 2, 0);

//		wd.findElement(By.name("accountname")).sendKeys(OrgName);
//		wd.findElement(By.id("phone")).sendKeys(phnNum);
//		wd.findElement(By.id("email1")).sendKeys(mailId);

		cop.enterOrgData(OrgName, phnNum, mailId);

		// To Click on Save Button
//		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cop.clickOnOrgSaveButton();

		String actualOrgName = op.validateOrganizationCreation(wd);
		Assert.assertEquals(actualOrgName, OrgName, "Organization Is not Created");

		// To LogOut From Application
		Thread.sleep(3000);
//		wd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		wd.findElement(By.linkText("Sign Out")).click();

//		home.logOutFromVtiger(wd);

//		hp.signOutFromVtiger();
//		wd.close();
	}
}
