package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.GHYT15.GenericUtility.BaseClass;
import com.crm.GHYT15.POMrepository.CampaignInformationPage;
import com.crm.GHYT15.POMrepository.CampaignPage;
import com.crm.GHYT15.POMrepository.CreateNewCampaignPage;
import com.crm.GHYT15.POMrepository.CreateNewProductPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;
import com.crm.GHYT15.POMrepository.ProductPage;

public class campaignTest extends BaseClass{
	
	
	
	@Test(groups = "smokeTest")
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

		Assert.assertTrue(text.contains(campname));

	}
	
	@Test(groups = "regressionTest")
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
		
		Assert.assertTrue(text.contains(Campignname));
//		if(text.contains(Campignname)) {
//			System.out.println("Matching successfull");
//		}
//		else {
//			System.out.println("Not Matching");
//		}
		
	}
	
}
