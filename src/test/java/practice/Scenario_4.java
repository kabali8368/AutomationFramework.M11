package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario_4 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.xpath("(//a[@href='index.php?module=Vendors&action=index'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys("kabalikabali");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String vd = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(vd);
		if(vd.contains("kabalikabali"))
		{
			System.out.println("Pass");
		}
		else
		{
		System.out.println("Fail");
		}
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out"));
		System.out.println("Logout successfull");
		
		driver.quit();
		

	}

}
