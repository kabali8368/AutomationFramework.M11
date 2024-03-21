package practice;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario_1 {

	public static void main(String[] args) throws InterruptedException {
		
		//step 1 : Launch browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http:localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//step 2 : Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3 : Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step 4 : Click on create contacts look Up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 5 : Create contact with mandatory information and save
		driver.findElement(By.name("lastname")).sendKeys("kabalikabali1");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		// step 6 : validate for the contact
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		
		if(contactHeader.contains("kabalikabali1"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		// step 7 : Logout of application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfull");
		
		//step 8 : close the browser
		driver.quit();
		
		
	}

}
