package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.LoginPage;

public class VtigerEx {
	// pull 1
	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://localhost:8888/");
//		wd.findElement(By.name("user_name")).sendKeys("admin");
//		wd.findElement(By.name("user_password")).sendKeys("admin");
//
//		WebElement loginButton = wd.findElement(By.id("submitButton"));
//		wd.navigate().refresh();
//		loginButton.click();

		LoginPage login = new LoginPage(wd);
		login.loginToVtiger("admin", "admin");
	}
}
