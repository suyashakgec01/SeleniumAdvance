package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Products")
	private WebElement productLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(xpath = "//a[@name='Campaigns']")
	private WebElement campaignLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutButtton;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getSignOutButtton() {
		return signOutButtton;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void logOutFromVtiger(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(adminLink).perform();
		signOutButtton.click();
	}

	public void signOutFromVtiger()  {
		adminLink.click();
		signOutButtton.click();
	}

}
