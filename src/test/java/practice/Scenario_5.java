package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario_5 {

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
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("kabalikabali");
		String pd = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(pd);
		if (pd.contains("kabalikabali"))
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
