package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{//Rule 1 : Create separate POM class for every Web Page
	
	//Rule 2 : identify web elements by using @FindBy
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	
	// Rule 3 : Create  a Constructor
	public CreateNewContactPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

	//Rule 4 : Provide Getters
	public WebElement getLastName() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	//Rule 5 : Business Library - Generic method related to project
	/**
	 * This method will create new contact and save
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
		
	}
	/**
	 * This method will create new contact with leads source dropdown and save
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContact(String LASTNAME , String LEADSOURCE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropdown, LEADSOURCE);
		saveBtn.click();
	}

}
