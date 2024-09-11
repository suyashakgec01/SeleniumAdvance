package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productPlusIcon;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;

	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement createdPrdName;

	public WebElement getCreatedPrdName() {
		return createdPrdName;
	}

	public WebElement getProductPlusIcon() {
		return productPlusIcon;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void clickOnPlusIcon() {
		productPlusIcon.click();
	}

	public void deleteProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + productName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}

	public void clickOnDeleteButton(WebDriverUtility webDriverUtility, WebDriver driver) throws Throwable {
		deleteButton.click();
		Thread.sleep(1000);
		webDriverUtility.alertAccept(driver);

	}

	public void validateProductDeletion(WebDriver driver, String productName) {
		List<WebElement> productList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag = false;
		for (WebElement prdName1 : productList) {
			String actData = prdName1.getText();
			System.out.println(actData);
			if (actData.equalsIgnoreCase(productName)) {
				flag = true;
				break;
			}
		}
		System.out.println(flag);
		if (!flag) {
			System.out.println("product data is deleted");
		} else {
			System.out.println("product data is not deleted");
		}
	}

	public String validateProductCreation(WebDriver driver) {
		String actualPrdName = createdPrdName.getText();
//		if (actualprdName.contains(productName)) {
//			System.out.println("Product is created");
//		} else {
//			System.out.println("Product is not created");
//		}
		return actualPrdName;
	}
}
