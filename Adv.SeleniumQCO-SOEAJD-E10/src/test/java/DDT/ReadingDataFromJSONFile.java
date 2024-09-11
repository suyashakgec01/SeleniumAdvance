package DDT;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingDataFromJSONFile {
	public static void main(String[] args) throws Throwable {

		File jsonFile = new File("./src/test/resources/credentials.json");
		ObjectMapper om = new ObjectMapper();
		JsonNode jsonData = om.readTree(jsonFile);
		String URL = jsonData.get("url").asText();
		String USERNAME = jsonData.get("username").asText();
		String PASSWORD = jsonData.get("password").asText();
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get(URL);
		cd.findElement(By.name("user-name")).sendKeys(USERNAME);
		cd.findElement(By.id("password")).sendKeys(PASSWORD);
		cd.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		cd.close();
	}

}
