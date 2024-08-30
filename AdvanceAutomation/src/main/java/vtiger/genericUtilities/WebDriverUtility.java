package vtiger.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This consist of methods related to Webdriver
 * 
 * @author Hp
 *
 */

public class WebDriverUtility {
	/**
	 * This method is used to Maximize browser
	 * 
	 * @param driver
	 */

	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize browser
	 * 
	 * @param driver
	 */

	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait until webelements are loaded in webpage(implicity wait)
	 * 
	 * @param driver
	 */
	public void toWaitForElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait till element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle dropdown using value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle dropdowm using Visibletext
	 * 
	 * @param text
	 * @param element
	 */
	public void toHandleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This method to used to switch driver control to frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch driver control using id or name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);

	}

	/**
	 * This method is used to switch control to frame using webelement address
	 * 
	 * @param driver
	 * @param element
	 */
	public void tohandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch back control from frame
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to perform double click on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	/**
	 * This method is used to perform right click on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to perform MouseHover on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform drag and drop on webelement
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */

	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}

	/**
	 * This method is used to handle Alert Popup by accepting it
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopUpByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to handle Alert Popup by Dismissing it
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopUpByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to handle Alert Popup and capture the alert message
	 * 
	 * @param driver
	 * @return
	 */
	public String toHandleAlertPopUpandCaptureMessage(WebDriver driver) {
		Alert alertPopup = driver.switchTo().alert();
		String alertMessage = alertPopup.getText();
		alertPopup.accept();
		return alertMessage;
	}

	/**
	 * This method is used to take Screenshot
	 * 
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public String toTakeScreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/" + screenshotname + ".jpeg");
		FileHandler.copy(temp, src);
		return src.getAbsolutePath();
	}

	/**
	 * This method is used to switch the driver control to particular window
	 * provided
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void toswitchWindow(WebDriver driver, String partialTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String ids : allWindowIDs) {
			String windowTitle = driver.switchTo().window(ids).getTitle();
			if (windowTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	public void toswitchWindowWithWebElementAddress(WebDriver driver, WebElement element, String partialHeader) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String ids : allWindowIDs) {
			driver.switchTo().window(ids);
			String text = element.getText();
			if (text.contains(partialHeader)) {
				break;
			}
		}
	}

}
