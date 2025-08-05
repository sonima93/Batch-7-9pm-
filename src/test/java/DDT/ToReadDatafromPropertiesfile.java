package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToReadDatafromPropertiesfile {

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
		
	}

}
