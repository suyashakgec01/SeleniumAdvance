package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver wd;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void BS() {
		System.out.println("DataBase Connection open");
	}

	@BeforeTest(groups = { "SmokeTest", "RegressionTest" })
	public void BT() {
		System.out.println("Parallel execution");
	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
//	public void BC(String BROWSER) {
	public void BC() throws Throwable {
		FileUtility fileUtility = new FileUtility();
		String BROWSER = fileUtility.getPropertiesData("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			wd = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			wd = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			wd = new EdgeDriver();
		} else {
			wd = new ChromeDriver();
		}
		System.out.println("Browser launched");
	}

//	@Parameters({ "username", "password" })
	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
//	public void BM(String username, String password) throws Throwable {
	public void BM() throws Throwable {
		FileUtility fileUtility = new FileUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		LoginPage loginPage = new LoginPage(wd);

		webDriverUtility.maximizeWindow(wd);
		webDriverUtility.waitPageToLoad(wd);

		String URL = fileUtility.getPropertiesData("url");
		String username = fileUtility.getPropertiesData("username");
		String password = fileUtility.getPropertiesData("password");

		wd.get(URL);
		loginPage.loginToVtiger(username, password);
		System.out.println("Login To Application");
	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void AM() {
		HomePage homePage = new HomePage(wd);
		homePage.signOutFromVtiger();
		System.out.println("LOgout from Application");
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void AC() {
		wd.quit();
		System.out.println("close Browser");
	}

	@AfterTest(groups = { "SmokeTest", "RegressionTest" })
	public void AT() {
		System.out.println("Parallel execution done");
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void AS() {
		System.out.println("Close DataBase Connection");
	}

}
