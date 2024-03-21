package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class ProductInfoPage extends SeleniumUtility {//Rule 1 : create a separate POM class for every Web page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderText;
	
	//Rule 3 : Initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getProductHeaderText() {
		return productHeaderText;
	}
	
	//Rule 5 : Business Library
	/**
	 * This method will capture header text and return it to caller
	 * @return
	 */
	public String captureProductHeader()
	{
		return productHeaderText.getText();
	}
	
	

}
