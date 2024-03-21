package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {// Rule 1 : Create a separate POM class for every web page
	
	//Rule  2: Declaration
	@FindBy(xpath = "(//a[text()='Campaigns'])[1]")
	private WebElement campaignsLnk;
	
	//Rule 3 : Initialization
	public MorePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}
	
	
	//Rule 5 : Business Library
	/**
	 * This method will perform click operation on campaigns module
	 * @param driver
	 */
	public void campaignsLink(WebDriver driver)
	{
		campaignsLnk.click();
	}

}
