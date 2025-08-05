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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeProgram {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
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
		Random random=new Random();
		int randomcount=random.nextInt(1000);
		System.out.println(randomcount);
//		WebDriver driver=new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://49.249.28.218:8098/ ");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.id("username")).sendKeys("rmgyantra");
//		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
//		
//		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Campaign.xlsx");
		 Workbook wb=WorkbookFactory.create(fis1);
		 Sheet sh=wb.getSheet("Campaign");
		 Row r=sh.getRow(1);
		 String Campname=r.getCell(2).getStringCellValue();
		 String target=r.getCell(3).getStringCellValue();
		 System.out.println(Campname);
	
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(Campname+randomcount);
		driver.findElement(By.name("targetSize")).sendKeys(target);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		
		
	WebElement toastmsg=driver.findElement(By.xpath("//div[@role='alert']"));
	
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg=toastmsg.getText();
		
		if(msg.contains(Campname))
		{
			System.out.println("Campaign Created");
		}
		else
		{
			System.out.println("Campaign Not Created");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		WebElement icon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act=new Actions(driver);
		act.moveToElement(icon).perform();
		WebElement logout=driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		act.moveToElement(logout).click().perform();
		driver.quit();
		

	}

}
