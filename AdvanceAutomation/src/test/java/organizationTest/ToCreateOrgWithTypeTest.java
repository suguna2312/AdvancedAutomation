package organizationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.genericUtilities.BaseClass;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class ToCreateOrgWithTypeTest extends BaseClass {

	@Test(groups="System")
	public void toCreateOrgWithType_001() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrganizationLookUpImage().click();
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		Random r=new Random();
		int random = r.nextInt(1000);
		String ORGANIZATION = eutil.toReadDataFromExcelFile("Organization", 2, 2)+random;
		cop.getOrganizationName().sendKeys(ORGANIZATION);
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toHandleDropdown(cop.getIndustrySelect(), 10);
		wutil.toHandleDropdown("Customer", cop.getTypeSelect());
		cop.getSaveButtonn().click();
		Thread.sleep(2000);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String organization = oip.getHeaderElementOrganization().getText();
		Assert.assertTrue(organization.contains(ORGANIZATION));
		System.out.println(organization + " with Industry " + oip.getIndustry().getText() + " with Type " + oip.getType().getText() + " created and TestScript passed");
		

	}
}
