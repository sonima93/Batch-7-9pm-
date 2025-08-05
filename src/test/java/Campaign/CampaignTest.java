package Campaign;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
@Listeners(ListenerUtility.ListenerImplementation.class)
public class CampaignTest extends BaseClass{
	
		@Test (groups="smoke")
			public void toCreateCampaignWithMandatoryFieldsTest() throws IOException {
				// TODO Auto-generated method stub
			
				ExcelFileUtility eutil=new ExcelFileUtility();
				JavaUtility jutil=new JavaUtility();
				
				//create campaign
				 String Campname=eutil.toReadDataFromExcelfile("Campaign",1,2);
				 String target=eutil.toReadDataFromExcelfile("Campaign",1,3);
				 System.out.println(Campname);
				
				 HomePage hp=new HomePage(driver);
				 CampaignPage cp=new CampaignPage(driver);
				hp.getCreateCampBtn().click();
				cp.getCampaignNameTF().sendKeys(Campname);
				
				WebElement size=cp.getTargetTF();
				size.clear();
				size.sendKeys(target);
				
				
				
				
				cp.getCreateCampSubmitBtnTF().click();
				WebElement toastmsg=cp.getToastmsg();
				wutil.waitForVisibilityofElement(driver,toastmsg);
				String msg=toastmsg.getText();
				//Assert.assertEquals(msg,Campname);
				Assert.assertTrue(msg.contains(Campname));
		        
		         cp.getClosemsg().click();
		        
			}
		@Test(groups= {"smoke","regression"})
		public void tocreateCampaignWithExpectedDateTest() throws EncryptedDocumentException, IOException{
			
			ExcelFileUtility eutil=new ExcelFileUtility();
			JavaUtility jutil=new JavaUtility();
		
			
			
			//create campaign
			String Campname=eutil.toReadDataFromExcelfile("Campaign",1,2);
			 String target=eutil.toReadDataFromExcelfile("Campaign",1,3);
			 System.out.println(Campname);
			 HomePage hp=new HomePage(driver);
			 CampaignPage cp=new CampaignPage(driver);
			hp.getCreateCampBtn().click();
			cp.getCampaignNameTF().sendKeys(Campname+jutil.togetRandomNumber());
			cp.getStatusTF().sendKeys("active");
			WebElement size=cp.getTargetTF();
			size.clear();
			size.sendKeys(target);
			
			
			
			
			


			String daterequired=jutil.togetCurrentDate(30);




	WebElement expClosedate=driver.findElement(By.name("expectedCloseDate"));


	wutil.passInput(driver,expClosedate,daterequired);

	cp.getCreateCampSubmitBtnTF().click();
	WebElement toastmsg=cp.getToastmsg();

	wutil.waitForVisibilityofElement(driver,toastmsg);
	String msg=toastmsg.getText();
	Assert.assertTrue(msg.contains(Campname));
	 cp.getClosemsg().click();
	 
	}
		@Test(groups="regression")
		public void tocreateCampaignWithStatusTest() throws EncryptedDocumentException, IOException {
			// TODO Auto-generated method stub
			
			ExcelFileUtility eutil=new ExcelFileUtility();
			JavaUtility jutil=new JavaUtility();
			
			
			//create campaign
			String Campname=eutil.toReadDataFromExcelfile("Campaign",1,2);
			 String target=eutil.toReadDataFromExcelfile("Campaign",1,3);
			 System.out.println(Campname);
			 HomePage hp=new HomePage(driver);
			 CampaignPage cp=new CampaignPage(driver);
			hp.getCreateCampBtn().click();
			cp.getCampaignNameTF().sendKeys(Campname+jutil.togetRandomNumber());
			cp.getStatusTF().sendKeys("active");
			WebElement size=cp.getTargetTF();
			size.clear();
			size.sendKeys(target);
			
			
			
			//create campaign
			cp.getCreateCampSubmitBtnTF().click();
			WebElement toastmsg=cp.getToastmsg();
			wutil.waitForVisibilityofElement(driver,toastmsg);
			String msg=toastmsg.getText();
			Assert.assertTrue(msg.contains(Campname));
	        
	         cp.getClosemsg().click();
	        
		}

			
}
