package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_popup {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/ ");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[3]")).click();
		
		// Task 1 
/*	//	driver.findElement(By.xpath("//div[@aria-label='Thu Apr 04 2024']")).click();
		
	// Task 2
		for (int i=1 ; i<=4; i++)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		driver.findElement(By.xpath("//div[@aria-label='Fri Aug 09 2024']")).click();

	*/
		// Task 3
		driver.findElement(By.xpath("//div[@aria-label='Sun Mar 03 2024']")).click();
		
		System.out.println("date select successfull");
	//	driver.quit();
	}

}
