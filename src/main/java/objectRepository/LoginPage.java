package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1 : Create separate POM Class for every Web Page
	
	//Rule 2: identify the web elements using @FindBY
	@FindBy(name="user_name") 
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3 : Create a constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Provide Getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5  :  Business Library - Generic methods related to project
	/**
	 * This method will perform Login Operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
