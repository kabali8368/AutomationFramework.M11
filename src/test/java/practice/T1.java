package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

	}

}
