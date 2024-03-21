package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {//Rule 1 : Create  a separate POM class for every web page
	
	//Rule 2 : identify web elements by using @FindBY     // Declaration
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Rule 3 : Create a constructor    // Initialization
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : provide Getters    // Utilization
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Rule 5 : Business Library
	/**
	 * This method will create new vendor and save
	 * @param VENDORNAME
	 */
	public void createNewVendorPage(String VENDORNAME)
	{
		vendorNameEdt.sendKeys(VENDORNAME);
		saveBtn.click();
	}

}
