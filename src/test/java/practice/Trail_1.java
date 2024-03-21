package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Trail_1 {

	@Test
	public void CreateContactWithLeadSource() throws InterruptedException, IOException {
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
				//		driver.findElement(By.linkText("Contacts")).click();
						
						HomePage hp = new HomePage(driver);
						hp.conactsLink();
						
						//step 4 : Click on create contacts look Up image
				//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
						
						ContactsPage cp = new ContactsPage(driver);
						cp.createContactLookUpImg();
						
						//step 5 : Create contact with mandatory information and save
				//		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
						
						CreateNewContactPage cnp = new CreateNewContactPage(driver);
						cnp.createNewContact(LASTNAME);
						
						
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
				//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
						
				//		sUtil.mouseOverAction(driver, ele);
						
				//		Thread.sleep(1000);
				//		driver.findElement(By.linkText("Sign Out")).click();
				//		System.out.println("logout successfull");
						
						hp.logoutOfApp(driver);
						
						 System.out.println("logout successfull");
						
						//step 8 : close the browser
						driver.quit();

	}

}
