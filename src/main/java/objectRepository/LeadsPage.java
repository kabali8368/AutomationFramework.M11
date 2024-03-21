package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {//Rule 1 : create separate POM classes for every Web Page
	
	//Rule 2 : identify the web elements using @FindBy
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createLeadLookUpImg;
	
	//Rule 3 : create a constructor
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 : Provide Getters
	public WebElement getCreateLeadLookUpImg() {
		return createLeadLookUpImg;
	}
	
	//Rule 5 : Business class - Generic method related to project
	/**
	 * This method will click on lead look up Image
	 * @param driver
	 */
	public void createLeadImg(WebDriver driver)
	{
		createLeadLookUpImg.click();
	}

}
