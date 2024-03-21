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

public class Scenario5WithDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p  = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String PRODUCTNAME = wb.getSheet("Products").getRow(1).getCell(2).getStringCellValue();
		
		//Login to application
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(PRODUCTNAME);
		String pd = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(pd);
		if (pd.contains(PRODUCTNAME))
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
