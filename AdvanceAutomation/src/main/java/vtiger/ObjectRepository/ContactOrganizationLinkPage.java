package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactOrganizationLinkPage {
	
	public ContactOrganizationLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//td[text()='Organizations']")
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement organizationLinkHeader;
	
	@FindBy(linkText = "WIPRO")
	private WebElement organizationNameLink;

	public WebElement getOrganizationLinkHeader() {
		return organizationLinkHeader;
	}

	public WebElement getOrganizationNameLink() {
		return organizationNameLink;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
