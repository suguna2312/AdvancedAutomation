package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.genericUtilities.BaseClass;
import vtiger.genericUtilities.ExcelFileUtility;

@Listeners(vtiger.genericUtilities.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {

	@Test(groups="Smoke")
	public void toCreateContact_001() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getContactLookUpImage().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		ccp.getLastname().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		Assert.fail();
		ContactInfoPage cip = new ContactInfoPage(driver);
		String lastname = cip.getHeaderElement().getText();
		Assert.assertTrue(lastname.contains(LASTNAME));
		System.out.println(lastname+" Contact created successfully");
		
		
		
		/*if (lastname.contains(LASTNAME)) {
			System.out.println(lastname + "--passed");
		} else {
			System.out.println(lastname + "--failed");
		}*/

	}

}
