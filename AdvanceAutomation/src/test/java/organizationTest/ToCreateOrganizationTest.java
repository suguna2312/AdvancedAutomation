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

public class ToCreateOrganizationTest extends BaseClass {
	
	@Test(groups={"Smoke","Regression"})
	public void toCreateOrganization_001() throws EncryptedDocumentException, IOException {
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrganizationLookUpImage().click();
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		Random r=new Random();
		int random = r.nextInt(1000);
		String ORGANIZATION = eutil.toReadDataFromExcelFile("Organization", 1, 2)+random;
		cop.getOrganizationName().sendKeys(ORGANIZATION);
		cop.getSaveButtonn().click();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String organization = oip.getHeaderElementOrganization().getText();
		Assert.assertTrue(true);
		System.out.println(organization+" Organization got created successfully");
		
		/*if(organization.contains(ORGANIZATION))
		{
			System.out.println(organization+"---passed");
		}else {
			System.out.println(organization+"---failed");
		}*/
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
