package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignProductPage {

	public CampaignProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement productName;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement productSearch;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

	public void enterProductName(String prdName) {
		productName.sendKeys(prdName);
	}

	public void clickSearchPrdName() {
		productSearch.click();
	}

	public void chooseProduct(WebDriver driver, String prdName) {
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
	}

}
