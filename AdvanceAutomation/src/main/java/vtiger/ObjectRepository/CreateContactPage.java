package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement organizationLookUpImageInCreateContact;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getOrganizationLookUpImageInCreateContact() {
		return organizationLookUpImageInCreateContact;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	

}
