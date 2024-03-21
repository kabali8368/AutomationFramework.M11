package contactTests_TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactTest {

	public static void main(String[] args) throws IOException, InterruptedException {
	        	//Create objects for utility classes
				PropertyFileUtility pUtil = new PropertyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();
				SeleniumUtility sUtil = new SeleniumUtility();
				
				/* Read data common data - property file*/
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				/*Read Test data - Excel File*/
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
				
				//step 1 : Launch browser
						ChromeOptions option = new ChromeOptions();
						option.addArguments("--remote-allow-origins=*");
						WebDriver driver = new ChromeDriver(option);
						sUtil.maximizeWindow(driver);
						sUtil.addImplicitlyWait(driver);
						driver.get(URL);
						
						
						//step 2 : Login to application
						LoginPage lp = new LoginPage(driver);
						lp.loginToApp(USERNAME, PASSWORD);
						
						//step 3 : Navigate to contacts link
						HomePage hp = new HomePage(driver);
						hp.conactsLink();
						
						//step 4 : Click on create contacts look Up image
						ContactsPage cp = new ContactsPage(driver);
						cp.createContactLookUpImg();
						
						//step 5 : Create contact with mandatory information and save
						CreateNewContactPage cncp = new CreateNewContactPage(driver);
						cncp.createNewContact(LASTNAME);
						
						// step 6 : validate for the contact
						ContactInfoPage cip = new ContactInfoPage(driver);
						String contactHeader = cip.captureContactHeader();
						
						System.out.println(contactHeader);
						
						if(contactHeader.contains(LASTNAME))
						{
							System.out.println("Pass");
						}
						else
						{
							System.out.println("Fail");
						}
						
						// step 7 : Logout of application
						hp.logoutOfApp(driver);
						System.out.println("logout successfull");
						
						//step 8 : close the browser
						driver.quit();

	}

}
