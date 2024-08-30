package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScript {
	
	//TESTCASE: To create Contact

	public static void main(String[] args) {
		//Step1:launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Step2:Login with valid credentials
		driver.get("http://localhost:8888/");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//step3: navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step;Create contact with look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step5:Create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("kiran ks");
		
		//Step6: save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String lastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(lastName.contains("kiran ks")) {
			System.out.println(lastName+"----passed");
		}else
		{
			System.out.println(lastName+"----failed");
		}
		
		//To Logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//To close Browser
		driver.quit();

	
	}

}
