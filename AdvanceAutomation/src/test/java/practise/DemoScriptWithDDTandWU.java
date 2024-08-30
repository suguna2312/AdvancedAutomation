package practise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class DemoScriptWithDDTandWU {
	
	public static void main(String[] args) throws IOException {
	
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//property file
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		//Excel File
		 String lastName = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
		//Script
		//Launch browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		wutil.toMaximize(driver);
		wutil.toWaitForElements(driver);
		
		//To Login
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//To Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Create contact with look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Enter mandatory details
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//Click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify
		String LASTNAME = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(LASTNAME.contains(lastName)) {
			System.out.println(LASTNAME+"---passed");
		}
		else {
			System.out.println(LASTNAME+"---failed");
		}
		
		//To logout
		WebElement logoutLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wutil.toMouseHover(driver, logoutLink);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//To Close
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			
		
	}

}
