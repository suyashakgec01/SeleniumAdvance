package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement orgPlusIcon;

	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement createdOrgName;

	public WebElement getCreatedOrgName() {
		return createdOrgName;
	}

	public WebElement getOrgPlusIcon() {
		return orgPlusIcon;
	}

	public void clickOnCreateOrg() {
		orgPlusIcon.click();
	}

	public String validateOrganizationCreation(WebDriver driver) {
		String actualOrgName = createdOrgName.getText();
		return actualOrgName;
	}

}
