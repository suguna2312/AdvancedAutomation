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

public class ToCreateOrgWithIndustryTest extends BaseClass {
	
	@Test(groups="Integration")
public void toCreateOrgWithIndustry_001() throws EncryptedDocumentException, IOException {
	
	HomePage hp=new HomePage(driver);
	hp.getOrganizationLink().click();
	OrganizationPage op=new OrganizationPage(driver);
	op.getOrganizationLookUpImage().click();
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	ExcelFileUtility eutil=new ExcelFileUtility();
	Random r =new Random();
	int random = r.nextInt(1000);
	String ORGANIZATION = eutil.toReadDataFromExcelFile("Organization", 1, 2)+random;
	cop.getOrganizationName().sendKeys(ORGANIZATION);
	WebDriverUtility wutil=new WebDriverUtility();
	wutil.toHandleDropdown(cop.getIndustrySelect(),"Chemicals");
	cop.getSaveButtonn().click();
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String organization = oip.getHeaderElementOrganization().getText();
	Assert.assertTrue(organization.contains(ORGANIZATION));
	System.out.println(organization+" with Industry  "+oip.getIndustry().getText()+" --Passed");
	
}

}
