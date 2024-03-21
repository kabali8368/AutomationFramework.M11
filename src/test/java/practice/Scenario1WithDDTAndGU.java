package practice;

import java.io.FileInputStream; 
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
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
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		 
		//step 1 : Create objects for utility classes
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
		//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//		driver.findElement(By.id("submitButton")).click();
				
				LoginPage lp = new LoginPage(driver);
				
				lp.loginToApp(USERNAME, PASSWORD);
				
		//		lp.getUserNameEdt().sendKeys(USERNAME);
		//		lp.getPasswordEdt().sendKeys(PASSWORD);
		//		lp.getLoginBtn().click();
				
				//step 3 : Navigate to contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//step 4 : Click on create contacts look Up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//step 5 : Create contact with mandatory information and save
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				// step 6 : validate for the contact
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
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
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				sUtil.mouseOverAction(driver, ele);
				
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successfull");
				
				//step 8 : close the browser
				driver.quit();
	}

}
