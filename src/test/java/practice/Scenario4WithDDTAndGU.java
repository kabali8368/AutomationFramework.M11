package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewVendorPage;
import objectRepository.HomePage2345;
import objectRepository.LoginPage;
import objectRepository.VendorsInfoPage;
import objectRepository.VendorsPage;

public class Scenario4WithDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		/*create an object for utility classes*/
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/*Read common data - property file*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/* Red Test data - Excel file*/
		String VENDORNAME = eUtil.readDataFromExcelFile("Vendors", 1, 2);
		
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
		
		//step 3 : Navigate to vendors link in more dropdown
		HomePage2345 hp = new HomePage2345(driver);
		hp.vendorsLinkInMore(driver);
		
		//step 4 : Click on create vendors look Up image
		VendorsPage vd = new VendorsPage(driver);
		vd.createVendorImg();
		
		//step 5 : Create vendors with mandatory information and save
		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.createNewVendorPage(VENDORNAME);
		
		//step 6 : validate for the vendors
		VendorsInfoPage vip = new VendorsInfoPage(driver);
		String vendorHeader =vip.captureHeaderText();
		System.out.println(vendorHeader);
		if(vendorHeader.contains(vendorHeader))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//step 7 : Logout of application
		hp.logOutOfApp(driver);
		System.out.println("Logout successfull");
		
		//step 8 : close the browser
		driver.quit();

	}

}
