package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {// Rule 1 : Create separate POM Class for every Web Page
	
	//Rule 2: identify the web elements using @FindBY
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//Rule 3 : Create a constructor
	public HomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	

	//Rule 4 : Provide Getters
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdminImg() {
		return administratorImg;
	}

	public WebElement getSignOut() {
		return signoutLnk;
	}
	


	//Rule 5 : Business Library - Generic method related to project
	/**
	 * This method will click on contacts link
	 */
	public void conactsLink()
	{
		contactsLink.click();
	}
	
	/**
	 * This method will perform logout of application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
	}
	
	
}
