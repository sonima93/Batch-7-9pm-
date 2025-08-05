package ImplementationOfUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;

public class CreateCampaignWithStatus extends BaseClass{

	public void tocreateCampaignWithStatus() throws EncryptedDocumentException, IOException {
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
         if(msg.contains(Campname))
         {
        	 System.out.println("campaign created");
         }
         else
         {
        	 System.out.println("campaign not created");
         }
        
         cp.getClosemsg().click();
        
	}

		
		
		
		





}
