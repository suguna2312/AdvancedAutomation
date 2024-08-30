package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactOrganizationLinkPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.genericUtilities.BaseClass;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class ToCreateContactWithOrgTest extends BaseClass {

	
	@Test(groups="Functional")
	
	public void toCreateContactWithorg_001() throws EncryptedDocumentException, IOException, InterruptedException {
			
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
	cp.getContactLookUpImage().click();
	CreateContactPage ccp=new CreateContactPage(driver);
	ExcelFileUtility eutil=new ExcelFileUtility();
	String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
	ccp.getLastname().sendKeys(LASTNAME);
	ccp.getOrganizationLookUpImageInCreateContact().click();
	ContactOrganizationLinkPage cop=new ContactOrganizationLinkPage(driver);
	WebDriverUtility wutil=new WebDriverUtility();
	wutil.toswitchWindow(driver, "Accounts");
	cop.getOrganizationNameLink().click();
	
	wutil.toswitchWindow(driver, "Contacts");
	//Assert.fail();
	ccp.getSaveButton().click();
	
	ContactInfoPage cip = new ContactInfoPage(driver);
	String lastname = cip.getHeaderElement().getText();
	Assert.assertTrue((lastname.contains(LASTNAME)));
	System.out.println(lastname+" with "+cop.getOrganizationNameLink().getText()+" Organization"+"--Passed");
	
	/*if (lastname.contains(LASTNAME)) {
		System.out.println(lastname + "--passed");
	} else {
		System.out.println(lastname + "--failed");
	}	*/	
		
	}	
}
