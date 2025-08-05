package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParametersFromCmd {
	@Test
public void CmdParameters() {
	
	
	String URL=System.getProperty("url");
	String USERNAME=System.getProperty("username");
	String PASSWORD=System.getProperty("password");
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
//	driver.get(url);
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.id("username")).sendKeys(username);
//	driver.findElement(By.id("inputPassword	")).sendKeys(password);
//	
//	driver.findElement(By.xpath("//button[text()='Sign In']")).click();
}
}