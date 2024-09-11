package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String getPropertiesData(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
