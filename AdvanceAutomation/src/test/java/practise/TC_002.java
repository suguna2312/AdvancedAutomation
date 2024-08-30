package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_002 {
	// TESTCASE: To create Organization
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
		driver.findElement(By.name("accountname")).sendKeys("Capgemini10");

		// To click on assignedTo
		// not working//input[contains(text(),'Group')] or
		// "//td[contains(text(),'Assigned To')]"
		driver.findElement(By.xpath("//td[text()='Assigned To 			']/..//input[@value='T']")).click();

		// Save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// verify
		String organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (organization.contains("Capgemini10")) {
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
