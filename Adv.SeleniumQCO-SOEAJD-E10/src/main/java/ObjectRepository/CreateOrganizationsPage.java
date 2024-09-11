package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationsPage {
	public CreateOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(name = "accountname"), @FindBy(xpath = "//input[@name='accountname']") })
	private WebElement organizationName;

	@FindBy(id = "phone")
	private WebElement phnNum;

	@FindBy(id = "email1")
	private WebElement emailId;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement orgSaveButton;

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getOrgSaveButton() {
		return orgSaveButton;
	}

	public WebElement getPhnNum() {
		return phnNum;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public void enterOrgData(String OrgName, String phoneNum, String mailId) {
		organizationName.sendKeys(OrgName);
		phnNum.sendKeys(phoneNum);
		emailId.sendKeys(mailId);
	}

	public void clickOnOrgSaveButton() {
		orgSaveButton.click();
	}
}
