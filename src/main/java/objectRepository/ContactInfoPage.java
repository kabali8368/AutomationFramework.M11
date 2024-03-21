package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {//Rule 1 : Create separate POM class for every Web Page
	
	//Rule 2 : identify Web elements by using @FindBy
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Rule 3 : Create a constructor
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Provide Getters
	public WebElement getContactHeader() {
		return contactHeaderText;
	}
	
	//Rule 5 : Business Library - Generic method related to project
	/**
	 * This method will capture text and return it to caller
	 * @return
	 */
	public String captureContactHeader()
	{
		return contactHeaderText.getText();
	}
	
	
}
