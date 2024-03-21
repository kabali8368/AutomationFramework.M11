package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {//Rule 1 : create a separate POM class for every Web Page
	
	//Rule 2 : identify the web element using @FindBy   // Declaration
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="company")
	private WebElement companyNameBtn;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Rule 3  : create a constructor           // Initialization
	public CreateNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Provide Getters      // Utilization 
	public WebElement getLastnameBtn() {
		return lastnameEdt;
	}

	public WebElement getCompanyNameBtn() {
		return companyNameBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Rule 5 : Business library - generic method related to project
	// Business Library
	/**
	 * This method will create new lead and save
	 * @param LASTNAME
	 * @param COMPANYNAME
	 */
	public void createNewLead(String LASTNAME , String COMPANYNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		companyNameBtn.sendKeys(COMPANYNAME);
		saveBtn.click();
	}

}
