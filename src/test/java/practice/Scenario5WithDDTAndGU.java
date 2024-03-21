package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage2345;
import objectRepository.LoginPage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;

public class Scenario5WithDDTAndGU {

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
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Products",1, 2);
		
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
		hp.productsLink();
		
		//step 4 : Click on create Leads look Up image
		ProductsPage pp = new ProductsPage(driver);
		pp.createProductImg();
		
		//step 5 : Create lead with mandatory information and save
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.productName(PRODUCTNAME);
		
		// step 6 : validate for the lead
		ProductInfoPage pip = new ProductInfoPage(driver);
		String productHeader = pip.captureProductHeader();
		System.out.println(productHeader);
		
		if(productHeader.contains(PRODUCTNAME))
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
