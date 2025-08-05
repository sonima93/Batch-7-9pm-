package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8098/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("organizationName")).sendKeys("wipro");
		driver.findElement(By.name("title")).sendKeys("Lead");
		driver.findElement(By.name("contactName")).sendKeys("Johns1");
		driver.findElement(By.name("mobile")).sendKeys("85700000");
		driver.findElement(By.xpath("//*[name()='svg' and @class='svg-inline--fa fa-plus ']")).click();
		//driver.findElement(By.xpath("//button[@style=']")).click();
		String parentid=driver.getWindowHandle();
		Set<String> childid=driver.getWindowHandles();
		childid.remove(parentid);
		for(String id:childid)
		{
			driver.switchTo().window(id);
			WebElement sel=driver.findElement(By.id("search-criteria"));
			Select sele=new Select(sel);
			sele.selectByValue("campaignName");
			driver.findElement(By.id("search-input")).sendKeys("test112");
			driver.findElement(By.xpath("//button[text()='Select']")).click();
		}
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
	}

}
