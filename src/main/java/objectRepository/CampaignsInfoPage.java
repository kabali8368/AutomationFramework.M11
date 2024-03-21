package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage {//Rule 1 : Create separate POM class for every Web Page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement campaignsHeaderText;
	
	//Rule 3 : Initialization
	public CampaignsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getCampaignsHeaderText() {
		return campaignsHeaderText;
	}
	
	
	//Rule 5 : Business library
	/**
	 * This method will capture text and return it to caller
	 * @return
	 */
	public String captureCampaignsHeader()
	{
		return campaignsHeaderText.getText();
	}
	
	

}
