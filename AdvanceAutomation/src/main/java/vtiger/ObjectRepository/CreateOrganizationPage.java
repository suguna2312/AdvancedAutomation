package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButtonn;
	
	@FindBy(name="industry")
	private WebElement industrySelect;
	
	@FindBy(name="accounttype")
	private WebElement typeSelect;
	
	

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getSaveButtonn() {
		return saveButtonn;
	}

	public WebElement getIndustrySelect() {
		return industrySelect;
	}

	public WebElement getTypeSelect() {
		return typeSelect;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
