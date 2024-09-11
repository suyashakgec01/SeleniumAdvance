package TestNGPractice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx3CreateOrg {

	@Test(dataProvider = "readData")
	public void CreateOrgModuleTest(String orgName, String phoneNum, String mailId) throws Throwable {
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://localhost:8888/");
		wd.findElement(By.name("user_name")).sendKeys("admin");
		wd.findElement(By.name("user_password")).sendKeys("admin");
		wd.findElement(By.id("submitButton")).click();
		wd.findElement(By.linkText("Organizations")).click();
		wd.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		wd.findElement(By.name("accountname")).sendKeys(orgName);
		wd.findElement(By.id("phone")).sendKeys(phoneNum);
		wd.findElement(By.id("email1")).sendKeys(mailId);
		wd.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		wd.findElement(By.linkText("Sign Out")).click();
		wd.close();
	}

	@DataProvider
	public Object[][] readData() {
		Object[][] objArr = new Object[2][3];
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		objArr[0][0] = "AAA" + ranNum;
		objArr[0][1] = "789456123";
		objArr[0][2] = "techpyramid@gmail.com";

		objArr[1][0] = "BBB" + ranNum;
		objArr[1][1] = "147852369";
		objArr[1][2] = "qspiders@gmail.com";

		return objArr;
	}

}
