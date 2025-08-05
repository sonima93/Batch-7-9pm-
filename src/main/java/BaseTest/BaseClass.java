package BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public PropertiesFileUtility putil=new PropertiesFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	@BeforeSuite(groups= {"smoke","regression"})
	public void beforeSuite()
	{
		System.out.println("DBconnectivity open");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void beforeClass() throws IOException
	{
		//String BROWSER=browser;
	String BROWSER=putil.togetDataFromPropertiesFile("Browser");
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
		sdriver=driver;
		System.out.println("launchng Browser");
		wutil.waitForPagetoLoad(driver);
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups= {"smoke","regression"})
public void beforeMethod() throws IOException
{
		String URL=putil.togetDataFromPropertiesFile("Url");
		String USERNAME=putil.togetDataFromPropertiesFile("Username");
		String PASSWORD=putil.togetDataFromPropertiesFile("Password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		
		lp.getLoginBtn().click();
		System.out.println("login");
}

	@AfterMethod(groups= {"smoke","regression"})
	public void afterMethod()
	{
		HomePage hp=new HomePage(driver);
		WebElement ele=hp.getUserIcon();
        wutil.mouseHoverOnWebElement(driver,ele);
		
		WebElement logout=hp.getLogBtnBtn();
		wutil.clickOnWebElement(driver,logout);
		System.out.println("logout");
	}
	@AfterClass(groups= {"smoke","regression"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("closing browser");
	}
	@AfterSuite(groups= {"smoke","regression"})
	public void afterSuite()
	{
		System.out.println("DB close");
	}
}
