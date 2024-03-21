package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage2345 extends SeleniumUtility{//Rule 1 : create Separate POM class for every web page
	
	//Rule 2 : Declaration
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreImg;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Rule 3 : Initialization
	public HomePage2345(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getMoreImg() {
		return moreImg;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	//Rule 5 : Business Library
	/**
	 * This method will click on leads link
	 */
	public void leadsLink()
	{
		leadsLink.click();
	}
	/**
	 * This method will click on campaigns link in more dropdown
	 * @param driver
	 * @throws InterruptedException
	 */
	public void campaignsLinkInMore(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, moreImg);
		Thread.sleep(1000);
		campaignsLink.click();
	}
	/**
	 * This method will click vendors link in more dropdown
	 * @param driver
	 * @throws InterruptedException
	 */
	public void vendorsLinkInMore(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, moreImg);
		Thread.sleep(1000);
		vendorsLink.click();
	}
	
	/**
	 * This method will click on products link
	 */
	public void productsLink()
	{
		productsLink.click();
	}
	
	public void logOutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
	}

}
