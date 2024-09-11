package DDT;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromPropertiesFile {
	public static void main(String[] args) throws Throwable {
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();

		// Normal Approach
//		cd.get("https://www.saucedemo.com/v1/");
//		cd.findElement(By.name("user-name")).sendKeys("standard_user");
//		cd.findElement(By.id("password")).sendKeys("secret_sauce");
//		cd.findElement(By.id("login-button")).click();



		// Step 1: Create a java representative object of the properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/ExternalResource.properties");

		// Step 2: Create a object of property class to load all keys
		Properties p = new Properties();
		p.load(fis);

		// Step 3: Read the value using getProperty() method
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		cd.get(URL);
		cd.findElement(By.name("user-name")).sendKeys(USERNAME);
		cd.findElement(By.id("password")).sendKeys(PASSWORD);
		cd.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		cd.close();
	}

}
