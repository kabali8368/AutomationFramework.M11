package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewCampaignPage {//Rule 1 :Create separate POM class for every Web Page
	
	//Rule 2 : Declaration
	@FindBy(name="campaignname")
	private WebElement campaignNameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Rule 3 : Initialization
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Rule 5: Business Library
	/**
	 * This method will create new campaign and save
	 * @param CAMPAIGNNAME
	 */
	public void createNewcampaign(String CAMPAIGNNAME )
	{
		campaignNameEdt.sendKeys(CAMPAIGNNAME);
		saveBtn.click();
	}
	

}
