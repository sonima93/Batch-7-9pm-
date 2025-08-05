package TestNgPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvCount {

	
	@Test(invocationCount =10,threadPoolSize=2)
	public void login() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
}
