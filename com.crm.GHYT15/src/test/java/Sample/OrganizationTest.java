package Sample;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GHYT15.GenericUtility.BaseClass;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;
import com.crm.GHYT15.POMrepository.CreateNewOrganizationPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;
import com.crm.GHYT15.POMrepository.OrganizationInformationPage;
import com.crm.GHYT15.POMrepository.OrganizationPage;

@Listeners (com.crm.GHYT15.GenericUtility.listnerImplimentation.class)
public class OrganizationTest extends BaseClass{
	
	@Test
	public void CreateNewOrganizationTest() throws EncryptedDocumentException, IOException {
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrganizationPage op=new OrganizationPage(driver);
		wu.waitForElementInDOM(driver);
		
		String Organizname = eu.getExcelData("Sheet1", 1, 7)+ju.getrandomNymber();
		String organiztionNameToConfirm = eu.getExcelData("Sheet1", 1, 7);

		hp.clickOrganizationModule();
		
		//failed intentionally
		//Assert.fail();
		op.ClickOnCreateOrganizationImage();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.WriteOrganizationNameComp(Organizname);
		cnop.ClickOnSaveButton();
	
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String text = oip.GetTheTextToVerify();
		String expectResult = organiztionNameToConfirm;
		
		Assert.assertTrue(text.contains(expectResult));
//		if(text.contains(expectResult)) {
//			System.out.println("matching successfull");	
//		}
//		else {
//			System.out.println("Not matching");
//		}	
	}
	
	
	
	

}
