package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataToPropertiesFile {
	public static void main(String[] args) throws Throwable {
		// Writing Data to External resources ----> Properties Files

		// Step 1: Create a object of property class to load the values and create
		// fileInputStream object
		FileInputStream fis = new FileInputStream("./src/test/resources/ExternalResource.properties");
		Properties pro = new Properties();

		// Step 2: Write the value using setProperty() method
		pro.setProperty("url", "https://www.saucedemo.com/v1/");
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");

		// Step 3: Create a file output stream object and store it in that file
		FileOutputStream fos = new FileOutputStream("./src/test/resources/ExternalResource.properties");
		pro.store(fos, "Adding URL,Username,Password");

	}

}
