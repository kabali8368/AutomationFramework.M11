package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {//Rule 1 : create a separate POM class for every web page
	
	//Rule 2 : Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadsHeaderText;
	
	//Rule 3: Initialization
	public LeadsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Utilization
	public WebElement getLeadsHeaderText() {
		return leadsHeaderText;
	}
	
	
	//Rule 5 : Business Library
	/**
	 * This method will capture header text and return it to caller
	 * @return
	 */
	public String capatureLeadHeader()
	{
		return leadsHeaderText.getText();
	}

}
