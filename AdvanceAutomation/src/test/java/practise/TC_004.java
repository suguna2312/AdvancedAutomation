package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_004 {

	public static void main(String[] args) {

		// To launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// To Login application with valid credentials
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		// Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();

		// click on create Organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("EnergyIndustry1");

		// Select "Chemicals" in industry dropdown
		WebElement industryDropdown = driver.findElement(By.name("industry"));
		Select industrySelect = new Select(industryDropdown);
		industrySelect.selectByValue("Energy");

		WebElement typeDropdown = driver.findElement(By.name("accounttype"));
		Select typeSelect = new Select(typeDropdown);
		typeSelect.selectByValue("Customer");
		// To Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify organization and industry and type selection and creation
		// organization webelement addr
		String organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		// industry webelement addr
		String industry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();

		// type webelement addr
		String type = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();

		//Verifying 
		if (organization.contains("EnergyIndustry1")) {
			if (industry.contains("Energy")) {
				if (type.contains("Customer")) {
					System.out.println(organization + " " + industry + " " + type + " created and TestScript passed");
				} else {
					System.out.println(type + " type selection---failed");
				}
			} else {
				System.out.println(industry + " industry creation---failed");
			}
		} else {
			System.out.println(organization + " creation---failed");
		}

		// To Logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// To close Browser
		driver.quit();

	}

}
