package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.PropertyFileUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Sce1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.conactsLink();
		
		/*  //Check on all the check boxes
		driver.findElement(By.name("selectall")).click();
		Thread.sleep(3000);
		System.out.println("Select all check box is successfull");
		*/
		/*// check on 5th checkbox
		driver.findElement(By.xpath("(//input[@name='selected_id'])[5]")).click();
		Thread.sleep(3000);
		System.out.println("Select 5th checkbox is successfull");
		*/
		/*// check the last checkbox
		driver.findElement(By.xpath("(//input[@name='selected_id'])[20]")).click();
		Thread.sleep(3000);
		System.out.println("Select last checkbox is successfull");
		*/
		
	    driver.findElement(By.xpath("(//input[@name='selected_id'])[17]")).click();
	 //   Thread.sleep(3000);
	//	String ele = driver.findElement(By.xpath("(//a[@title='Contacts'])[34]")).getText();
	    driver.findElement(By.xpath("(//a[@title='Contacts'])[34]")).click();
	    
	    
		List<WebElement> con = driver.findElements(By.xpath("//span[@class='dvHeaderText']"));
		for (WebElement ele : con)
		{
			String element = ele.getText();
			System.out.println(element);
		}
				
	//	Thread.sleep(3000);
	//	System.out.println(ele);
		
		
	//	driver.quit();
		
		

	}

}
