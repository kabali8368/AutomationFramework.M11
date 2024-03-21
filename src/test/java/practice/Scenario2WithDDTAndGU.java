package practice;

import java.io.IOException; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewLeadPage;
import objectRepository.HomePage2345;
import objectRepository.LeadsInfoPage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;

public class Scenario2WithDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		//step 1 : Create objects for utility classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/* Read data common data - property file*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*Read Test data - Excel File*/
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 1, 2);
		String COMPANY = eUtil.readDataFromExcelFile("Leads", 1, 3);
		
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
		
		//step 3 : Navigate to leads link
		HomePage2345 hp = new HomePage2345(driver);
		hp.leadsLink();
		
		//step 4 : Click on create Leads look Up image
		LeadsPage ldp = new LeadsPage(driver);
		ldp.createLeadImg(driver);	
        
		
        //step 5 : Create lead with mandatory information and save
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		cnlp.createNewLead(LASTNAME, COMPANY);
		
		// step 6 : validate for the lead
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String leadHeader = lip.capatureLeadHeader();
		
		System.out.println(leadHeader);
		
		if (leadHeader.contains(LASTNAME))
				{
			System.out.println("Pass");
				}
		else 
		{
			System.out.println("Fail");
		}
		
		// step 7 : Logout of application
		hp.logOutOfApp(driver);
		
		System.out.println("Logout successfull");
		
		//step 8 : close the browser
		driver.quit();
		

	}

}
