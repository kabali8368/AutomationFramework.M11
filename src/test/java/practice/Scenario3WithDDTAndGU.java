package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CampaignsInfoPage;
import objectRepository.CampaignsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.HomePage2345;
import objectRepository.LoginPage;

public class Scenario3WithDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Create an object for utility classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/* Read common data - property file */
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/* Read Test data - Excel file*/
		String CAMPAIGNNAME = eUtil.readDataFromExcelFile("Campaigns", 1 , 2);
		
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
		
		//step 3 : Navigate to campaigns link in more dropdown
		HomePage2345 hp = new HomePage2345(driver);
		hp.campaignsLinkInMore(driver);
		
		//step 4 : Click on create campaigns look Up image
		CampaignsPage cp = new CampaignsPage(driver);
		cp.createCampaignsImg();
		
		//step 5 : Create campaign with mandatory information and save
		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.createNewcampaign(CAMPAIGNNAME);
		
		// step 6 : validate for the campaign
		CampaignsInfoPage cip = new CampaignsInfoPage(driver);
		String contactHeader = cip.captureCampaignsHeader();
		
		System.out.println(contactHeader);
		if (contactHeader.contains(CAMPAIGNNAME))
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
