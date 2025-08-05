package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

public class CreateProduct {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create object of FIS
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
				
				//Object of properties file
				Properties prop=new Properties();
				
				//load all keys
				prop.load(fis);
				
				//get properties
				String BROWSER=prop.getProperty("Browser");
				String URL=prop.getProperty("Url");
				String USERNAME=prop.getProperty("Username");
				String PASSWORD=prop.getProperty("Password");
				
				System.out.println(BROWSER);
				System.out.println(URL);
				
				//Actual script
				WebDriver driver=null;
				if(BROWSER.equals("Edge"))
				{
					 driver=new EdgeDriver();
					
				}
				else if(BROWSER.equals("Firefox"))
				{
					 driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("Chrome"))
				{
					 driver=new ChromeDriver();
				}
				
				driver.manage().window().maximize();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.id("username")).sendKeys(USERNAME);
				driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
				
				driver.findElement(By.xpath("//button[text()='Sign In']")).click();
				
				
				
				
				
				
				
				
				FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Campaign.xlsx");
				 Workbook wb=WorkbookFactory.create(fis1);
				 Sheet sh=wb.getSheet("Product");
				 Row r=sh.getRow(1);
				 String productname=r.getCell(1).getStringCellValue();
				 String quantity=r.getCell(2).getStringCellValue();
				 String price=r.getCell(3).getStringCellValue();
				 System.out.println(productname);
				 
				 
				 Random ran=new Random();
				 int randomcount=ran.nextInt(500);
				
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		driver.findElement(By.name("productName")).sendKeys(productname+randomcount);
		
		WebElement categ=driver.findElement(By.name("productCategory"));
		Select sel=new Select(categ);
		sel.selectByValue("Electronics");
		
		WebElement quant=driver.findElement(By.name("quantity"));
		quant.clear();
		quant.sendKeys(quantity);
		WebElement Price=driver.findElement(By.name("price"));
		Price.clear();
		Price.sendKeys(price);
		
		
		WebElement vendor=driver.findElement(By.name("vendorId"));
		Select sele=new Select(vendor);
		sele.selectByValue("VID_001");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--success']")).click();
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(ele).perform();
		WebElement logout=driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		act.moveToElement(logout).click().perform();
	}

}
