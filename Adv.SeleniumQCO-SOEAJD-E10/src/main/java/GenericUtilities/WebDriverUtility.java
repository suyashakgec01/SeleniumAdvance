package GenericUtilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	/**
	 * This method is used to maximize the window/webpage
	 * 
	 * @param driver
	 * @author Shobha
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the window/webpage
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to FullScreen the window/webpage
	 * 
	 * @param driver
	 */
	public void FullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	/**
	 * This method is used to wait element to get loaded in window/webpage
	 * 
	 * @param driver
	 */
	public void waitPageToLoad(WebDriver driver)

	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used for switching windows/tabs
	 * 
	 * @param driver
	 * @param title
	 */
	public void switchingWindows(WebDriver driver, String title) {
		Set<String> allWin = driver.getWindowHandles(); // win1,win2

		Iterator<String> it = allWin.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();

			if (currentTitle.contains(title)) {
				break;
			}
		}
	}

	public void moveToElementAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
