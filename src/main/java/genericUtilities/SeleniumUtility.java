package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic related to Selenium web driver
 * @author kabali
 */
public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait for 10 seconds
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for web element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle drop-down by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop-down by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element , String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle drop-down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text , WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will perform mouse hovering action on a web element
	 * @param element
	 * @param driver
	 */
	public void mouseOverAction(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method  will perform right click operation 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click operation
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver, WebElement element)
	{
	Actions act  = new Actions(driver);
	act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void mouseOverAction(WebDriver driver , WebElement src , WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will switch to frame based on Index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver , int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will switch to Frame based on name or ID
	 * @param driver
	 * @param index
	 */
	public void switchToFrames(WebDriver driver , String frameNameOrID)
	{
		driver.switchTo().frame(frameNameOrID);
	}
	
	/**
	 * This method will frame based on frame webElement
	 * @param driver
	 * @param default content
	 */
	public void switchToFrames(WebDriver driver , WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	
	/**
	 * This method will accept the alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
	  driver.switchTo().alert().accept();	
	}
	
	/**
	 * This method will  dismiss the alert pop-up
	 * @param driver
	 * @param element
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();	
	}
	
	/**
	 * This method will send data into alert pop-up
	 * @param driver
	 * @param element
	 */
	public void sendAlertText(WebDriver driver , String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture the alert text and return value to caller
	 * @param driver
	 * @param element
	 * @return 
	 */
	public String getTextAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will Scroll up the page by 500 units
	 * @param driver
	 */
	public void scrollUpActions(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);" , "");
	}
	
	/**
	 * This method will scroll down the page by 500 units
	 * @param driver
	 */
	public void scrollDownActions(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);" , "");
	}
	
	/**
	 * This method will capture the screen shot and store it in required
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver , String ScreenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+ScreenshotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //Used in extent reports
	}

}
