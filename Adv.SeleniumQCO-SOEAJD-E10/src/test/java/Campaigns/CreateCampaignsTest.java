package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateCampaignsTest extends BaseClass {
	// Login to vtiger application->mouseOverOn more Link->click on campaigns->click
	// on create campaign lookup image->Enter campaignName->click on save
	// Btn->verify whether the campaign is created in campaign Information page and
	// Logout from the application.

//	@Test(groups = "SmokeTest")
	@Test(retryAnalyzer = GenericUtilities.RetryImplementation.class)
	public void createCampaignsTest() throws Throwable {

//		WebDriver wd = new ChromeDriver();

		ExcelUtility eU = new ExcelUtility();
//		FileUtility fU = new FileUtility();
		JavaUtility jU = new JavaUtility();
//		WebDriverUtility wDU = new WebDriverUtility();
//		LoginPage lp = new LoginPage(wd);
		HomePage hp = new HomePage(wd);
		CampaignPage cp = new CampaignPage(wd);
		CreateCampaignPage ccp = new CreateCampaignPage(wd);

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

		// Click on Campaingns Link
//		Actions act = new Actions(wd);
//		act.moveToElement(wd.findElement(By.linkText("More"))).click().perform();
//		wd.findElement(By.xpath("//a[@name='Campaigns']")).click();
		hp.getMoreLink().click();
		hp.getCampaignLink().click();

		// Click on Create Campaign Lookup Image
//		wd.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		cp.clickOnCampaignPlusIcon();

		// To Avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		int ranNum = jU.getRandomNum();

		// Create Campaign Data
		String campName = eU.getExcelData("Campaign", 0, 0) + ranNum;
//		wd.findElement(By.name("campaignname")).sendKeys(campName);
		ccp.enterCampName(campName);

		// To Click on Save Button
//		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ccp.clickOnCampSaveButton();

		String actualCampName = cp.validateCampaignCreation(wd);
		Assert.assertEquals(actualCampName, campName, "Campaign Is not Created");

		// To LogOut From Application
		Thread.sleep(2000);
//		wd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		wd.findElement(By.linkText("Sign Out")).click();
//		hp.signOutFromVtiger();
//		wd.close();

	}

}
