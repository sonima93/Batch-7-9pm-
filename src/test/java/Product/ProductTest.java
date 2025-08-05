package Product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.ProductPage;

public class ProductTest extends BaseClass {
	@Test(groups="smoke")
	public void tocreateProductTest() throws EncryptedDocumentException, IOException, InterruptedException
	
	 {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ExcelFileUtility eutil=new ExcelFileUtility();
				JavaUtility jutil=new JavaUtility();
			
				ProductPage pp=new ProductPage(driver);
				
				String productname=eutil.toReadDataFromExcelfile("Product",1,1);
				 String quantity1=eutil.toReadDataFromExcelfile("Product",1,2);
				 String price1=eutil.toReadDataFromExcelfile("Product",1,3);
				 
				
		pp.getProductlink().click();
		pp.getAddProductBtn().click();
		pp.getProductNameTF().sendKeys(productname+jutil.togetRandomNumber());
		
		WebElement categorydropdown=pp.getProductCategoryTF();
		wutil. select(categorydropdown,3);
		WebElement quant=pp.getProductQuantityTF();
		quant.clear();
		quant.sendKeys(quantity1);
		WebElement Price=pp.getProductpriceTF();
		Price.clear();
		Price.sendKeys(price1);
		
		
		WebElement vendordropdown=pp.getVendorIdTF();
		wutil.select(vendordropdown,1);
		
		CampaignPage cp=new CampaignPage(driver);
		
		
		
		pp.getCreatProductBtn().click();
		
		  // pp.getProducttoastCloseBtn().click();
		cp.getClosemsg().click();
	       
	}

}
