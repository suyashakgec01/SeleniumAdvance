package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement productNameTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement proSaveButton;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getProSaveButton() {
		return proSaveButton;
	}

	public void enterProductName(String prdName) {
		productNameTextField.sendKeys(prdName);
	}

	public void clickOnProSaveButton() {
		proSaveButton.click();
	}

}
