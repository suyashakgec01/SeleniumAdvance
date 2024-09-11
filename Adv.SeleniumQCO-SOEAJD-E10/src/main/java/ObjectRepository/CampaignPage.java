package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaignPlusIcon;

	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement createdCampName;

	public WebElement getCreatedCampName() {
		return createdCampName;
	}

	public WebElement getCampaignPlusIcon() {
		return campaignPlusIcon;
	}

	public void clickOnCampaignPlusIcon() {
		campaignPlusIcon.click();
	}

	public String validateCampaignCreation(WebDriver driver) {
		String actualCampName = createdCampName.getText();
		return actualCampName;
	}

}
