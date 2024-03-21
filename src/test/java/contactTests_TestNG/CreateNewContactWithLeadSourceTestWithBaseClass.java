package contactTests_TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactWithLeadSourceTestWithBaseClass extends BaseClass{
	
	@Test (groups = "RegressionSuite")
	public void createContactWithLeadSource() throws IOException, InterruptedException {
		
		
		/*Read Test data - Excel File*/
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts", 4, 3);
				
				//step 3 : Navigate to contacts link
				HomePage hp = new HomePage(driver);
				hp.conactsLink();
				
				//step 4 : Click on create contacts look Up image
				ContactsPage cp = new ContactsPage(driver);
				cp.createContactLookUpImg();
				
				//step 5 : Create contact with mandatory information and save
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME, LEADSOURCE);
				
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
				

	}

}