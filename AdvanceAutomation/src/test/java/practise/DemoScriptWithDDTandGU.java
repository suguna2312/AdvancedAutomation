package practise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.PropertyFileUtility;

public class DemoScriptWithDDTandGU {

	public static void main(String[] args) throws IOException {

		// To read data from property file
		PropertyFileUtility putil = new PropertyFileUtility();
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		// To read data from excel file
		ExcelFileUtility eutil = new ExcelFileUtility();
		String orgname = eutil.toReadDataFromExcelFile("Organization", 1, 2);

		// Scripts
		// Launch browser
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		//To login
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();

		// click on create Organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		// Save
		//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify
		String organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (organization.contains(orgname)) {
			System.out.println(organization + "---passed");
		} else {
			System.out.println(organization + "---failed");
		}

		// To Logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// To close
		driver.quit();

	}
}
