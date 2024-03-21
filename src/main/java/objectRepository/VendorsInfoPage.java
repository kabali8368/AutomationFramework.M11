package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInfoPage {//Rule 1 :  create a separate POM class for every web page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorHeaderText;
	
	//Rule 3 : Initialization
	public VendorsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	//Rule 4 : Utilization
	public WebElement getVendorHeaderText() {
		return vendorHeaderText;
	}

	//Rule 5 : Business Library
	/**
	 * This method will capture vendor header text and return it to caller
	 * @return
	 */
	public String captureHeaderText()
	{
		return vendorHeaderText.getText();
	}
}
