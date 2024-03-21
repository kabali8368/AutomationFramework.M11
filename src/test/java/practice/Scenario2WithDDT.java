package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario2WithDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Leads").getRow(1).getCell(2).getStringCellValue();
		String COMPANY = wb.getSheet("Leads").getRow(1).getCell(3).getStringCellValue();
		
		//step 1 : Launch browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.name("company")).sendKeys(COMPANY);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String LeadHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(LeadHeader);
		
		if (LeadHeader.contains(LASTNAME))
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
