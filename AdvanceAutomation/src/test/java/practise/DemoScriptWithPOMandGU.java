package practise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class DemoScriptWithPOMandGU {
	
	
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
		 String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
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
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getContactLookUpImage().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastname().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String lastName = cip.getHeaderElement().getText();
		if(lastName.contains(LASTNAME)) {
			System.out.println(lastName+"--Passed");
		}else {
			System.out.println(lastName+"--failed");
		}
		
		wutil.toMouseHover(driver, hp.getLogoutLink());
		hp.getSignOutLink().click();
		driver.quit();
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
