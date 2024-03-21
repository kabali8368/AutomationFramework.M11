package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of Basic configuration Annotations of TestNG
 * @author kabali
 */
public class BaseClass_ParallelExecution {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public WebDriver driver;
	
	@BeforeSuite (alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("==== DB Connection successfull =====");
	}
	
	@BeforeTest
	//@BeforeClass (alwaysRun = true)
	public void bcConfig() throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		System.out.println("==== Browser Launch successfull =====");
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("==== Login To Ap successfull =====");
	}
	
	@AfterMethod (alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("==== Logout To App successfull =====");
		
	}
	
	@AfterTest
	//@AfterClass (alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("==== Browser Closure successfull =====");
	}
	
	@AfterSuite (alwaysRun = true)
	public void asConfig()
	{
		System.out.println("==== DB Closure successfull =====");
	}

}
