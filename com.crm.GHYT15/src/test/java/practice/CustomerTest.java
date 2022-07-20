package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.GHYT15.GenericUtility.BaseClass;
import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.POMrepository.CampaignInformationPage;
import com.crm.GHYT15.POMrepository.CampaignPage;
import com.crm.GHYT15.POMrepository.ContactInformationPage;
import com.crm.GHYT15.POMrepository.CreateContactPage;
import com.crm.GHYT15.POMrepository.CreateNewCampaignPage;
import com.crm.GHYT15.POMrepository.CreateNewProductPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;
import com.crm.GHYT15.POMrepository.ProductPage;
import com.crm.GHYT15.POMrepository.contactPage;

public class CustomerTest extends BaseClass {
	
	@Test
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

		String expectResult = contactname;
		if(text.contains(expectResult)) {
			System.out.println("matching successfull");	
		}
		else {
			System.out.println("Not matching");
		}	
	}
	
	
	@Test
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
		if(text.contains(expectResult)) {
			System.out.println("Contact Deletion successfull");	
		}
		else {
			System.out.println("Contact Deletion Failed");
		}
	}
	
	
	@Test
	public void CreateCampaignTest() throws EncryptedDocumentException, IOException {
		System.out.println("Create Campaign");
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CreateNewCampaignPage cnp=new CreateNewCampaignPage(driver);
		CampaignPage cp=new CampaignPage(driver);
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		
		String campname = eu.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		hp.ClickOnCampaignModule();
		
		cp.ClickOnCreateCampainimage();
		
		cnp.WriteCampaignNameInComp(campname);
		cnp.ClickOnSaveButton();
		
		String text = cip.GetTextFromCampaigninfPage();
		System.out.println("Actual Result:  "+text);

		if(text.contains(campname)) {
			System.out.println("====Result matching successfull====");	
		}
		else {
			System.out.println("--Result Not matching--");
		}
	}
	
	@Test
	public void createCampaignWithproductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("createCampaignWithproductTest");
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CreateNewCampaignPage cnc=new CreateNewCampaignPage(driver);
		CampaignPage cp=new CampaignPage(driver);
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		ProductPage pp=new ProductPage(driver);
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		
		String campname = eu.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		String prodname = eu.getExcelData("Sheet1", 1, 5)+ju.getrandomNymber();
		String prod = eu.getExcelData("Sheet1", 1, 6)+ju.getrandomNymber();
		String campnm = eu.getExcelData("Sheet2", 1, 1)+ju.getrandomNymber();
		String Campignname = eu.getExcelData("Sheet1", 1, 4);
		
		hp.ClickOnProductModule();
		pp.ClickOnCreateNewProductImage();
		
		cnp.writeProductNameInComp(prodname);
		cnp.ClickOnSaveButton();
		
		hp.ClickOnCampaignModule();
		
		cp.ClickOnCreateCampainimage();
		cnc.WriteCampaignNameInComp(campname);
		cnc.ClickOnProductLookUpIcon();
				
		cnp.SwitchToProductWindow(prod, prodname);
		
		cnp.SwitchToCreateNewCampaignWindow(campnm);
		
		cnc.ClickOnSaveButton();
		String text = cip.GetTextFromCampaigninfPage();
		System.out.println(text);
		
		if(text.contains(Campignname)) {
			System.out.println("Matching successfull");
		}
		else {
			System.out.println("Not Matching");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}