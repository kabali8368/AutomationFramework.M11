package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {// Rule 1 : Create separate POM class for every Web Page
	
	// Rule 2 : Identify the web element using @FindBy
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	//Rule 3 : Create a constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Rule 4 : Provide Getters
	public WebElement getCreateContactImg() {
		return createContactLookUpImg;
	}
	
	//Rule 5 : Business Library - Generic methods related to project
	/**
	 * This method will click on contacts look up Image
	 */
	public void createContactLookUpImg()
	{
		createContactLookUpImg.click();
	}

}
