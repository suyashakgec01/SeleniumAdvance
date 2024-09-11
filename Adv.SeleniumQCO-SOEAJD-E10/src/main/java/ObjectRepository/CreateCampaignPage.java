package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement plusSignToNavigateProductPage;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement campSaveButton;

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getPlusSignToNavigateProductPage() {
		return plusSignToNavigateProductPage;
	}

	public WebElement getCampSaveButton() {
		return campSaveButton;
	}

	public void enterCampName(String campName) {
		campaignNameTextField.sendKeys(campName);
	}

	public void clickProductPlusSign() {
		plusSignToNavigateProductPage.click();
	}

	public void clickOnCampSaveButton() {
		campSaveButton.click();
	}

}
