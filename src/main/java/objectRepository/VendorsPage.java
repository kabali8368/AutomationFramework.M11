package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {// Rule 1 : Create separate POM class for every Web Page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createVendorLookUpImg;
	
	//Rule 3 : Initialization
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getCreateVendorLookUpImg() {
		return createVendorLookUpImg;
	}
	
	//Rule 5 : Business Library
	/**
	 * this method will click on vendor lookup img
	 */
	public void createVendorImg()
	{
		createVendorLookUpImg.click();
	}
	
	

}
