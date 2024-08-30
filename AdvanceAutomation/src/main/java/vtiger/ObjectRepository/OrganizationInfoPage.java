package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerElementOrganization;
	
	@FindBy(xpath="//span[@id='dtlview_Industry']")
	private WebElement industry;
	
	@FindBy(xpath="//span[@id='dtlview_Type']")
	private WebElement type;

	public WebElement getHeaderElementOrganization() {
		return headerElementOrganization;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}
}
