package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.GHYT15.GenericUtility.BaseClass;
import com.crm.GHYT15.POMrepository.ContactInformationPage;
import com.crm.GHYT15.POMrepository.CreateContactPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.contactPage;

public class ContactTest extends BaseClass{
	
	@Test(groups = "regressionTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		System.out.println("Create contact");
		HomePage hp=new HomePage(driver);
		CreateContactPage ccp=new CreateContactPage(driver);
        
        String lastname = eu.getExcelData("Sheet1", 1, 3)+ju.getrandomNymber();
		String contactname = eu.getExcelData("Sheet1", 1, 3);
		
	    hp.clickcontactModule();
		
	    ccp.ClickOnCreatecontactIMG();
		
        ccp.LastNameComp(lastname);
        ccp.ClickOnsaveButton();
         
        ContactInformationPage ci=new ContactInformationPage(driver);
        String text = ci.GetTheTextinContactInformation();

		//System.out.println(text);
		String expectResult = contactname;

		Assert.assertTrue(text.contains(expectResult));
//		if(text.contains(expectResult)) {
//			System.out.println("matching successfull");	
//		}
//		else {
//			System.out.println("Not matching");
//		}	
	}
	
	@Test(groups = "smokeTest")
	public void createAndDeletetheContactTest() throws EncryptedDocumentException, IOException {
		System.out.println("Create And Delete the Contact");
		
		String lastname = eu.getExcelData("Sheet1", 1, 3)+ju.getrandomNymber();
		String AlertText = eu.getExcelData("Sheet2", 1, 4);
		String textToConfirmcontact = eu.getExcelData("Sheet2", 4, 2);
		HomePage hp=new HomePage(driver);
		hp.clickcontactModule();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.ClickOnCreatecontactIMG();
		
		ccp.LastNameComp(lastname);
        ccp.ClickOnsaveButton();

		
        ContactInformationPage ci=new ContactInformationPage(driver);
        ci.ClickOnDeleteButton();
		 
		wu.swithToAlertWindowAndAccpect(driver, AlertText);//Alert popup
		
		contactPage cp=new contactPage(driver);
				
		cp.WritesearchComp(lastname);
		
		cp.ClickonListBoxDropdown();
		cp.ClickOnSearchNOwButton();
		
		String text = cp.StriGetTextToConfirm();
		
		String expectResult = textToConfirmcontact;
		
		Assert.assertTrue(text.contains(expectResult));
//		if(text.contains(expectResult)) {
//			System.out.println("Contact Deletion successfull");	
//		}
//		else {
//			System.out.println("Contact Deletion Failed");
//		}
	}

}
