package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {//Rule : Create separate POM class for every Web Page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductsLookUpImg;
	
	//Rule 3 : Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule 4 : Provide Getters
	public WebElement getProductsLnk() {
		return createProductsLookUpImg;
	}
	
	// Rule 5 : Business Library
	/**
	 * This method will click on the products link
	 */
	public void createProductImg()
	{
		createProductsLookUpImg.click();
	}
	
	

}
