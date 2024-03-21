package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {//Rule 1 : Create a separate POM class for every web page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCampaignsLookUpImg;
	
	//Rule 3 : Initialization
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getCreateCampaignsLookUpImg() {
		return createCampaignsLookUpImg;
	}

	// Rule 5 : Business Library
	/**
	 * This method will click on campaigns look up image
	 */
	public void createCampaignsImg()
	{
		createCampaignsLookUpImg.click();
	}
	
	
}
