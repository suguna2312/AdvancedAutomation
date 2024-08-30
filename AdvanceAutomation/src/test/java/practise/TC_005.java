package practise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_005 {
	

	public static void main(String[] args) throws InterruptedException {

		// step1:launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Step2:Login with valid credentials
		driver.get("http://localhost:8888/");
		String parentId = driver.getWindowHandle();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		// step3: navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// step;Create contact with look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step5:Create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Suguna");

		//driver.findElement(By.xpath("((//table[@class='small'])[4]//img)[1]")).click();
		driver.findElement(By.xpath("//input[@name='account_name']/..//img[@title='Select']")).click();

		Set<String> allWind = driver.getWindowHandles();
		allWind.remove(parentId);
		for (String id : allWind) {
			driver.switchTo().window(id);
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("KPMG")).click();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// To close Browser
		driver.quit();

	}

}
