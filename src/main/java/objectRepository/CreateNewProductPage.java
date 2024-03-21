package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {//Rule 1 : Create separate POM class for every Web Page
	
	//Rule 2 : Declaration
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Rule 3 : Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule 4 : Utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Rule 5 : Business Library
	/**
	 * This method will create new product and save
	 * @param PRODUCTNAME
	 */
	public void productName(String PRODUCTNAME)
	{
		productNameEdt.sendKeys(PRODUCTNAME);
		saveBtn.click();
	}
	
}
