package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPagetoLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	
	public void waitForVisibilityofElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchtoFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	public void switchtoFrame(WebDriver driver,WebElement frameele)
	{
		driver.switchTo().frame(frameele);
	}
	
	
	public void switchtoAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertAndgetText(WebDriver driver)
	{
		String text=driver.switchTo().alert().getText();
				
	}
	public void switchToAlertAndSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void select(WebElement element,int index )
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseHoverOnWebElement(WebDriver driver,WebElement Element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Element).perform();
	}
	public void clickOnWebElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	public void doubleClickOnWebElement(WebDriver driver,WebElement Element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(Element).click().perform();
	}
	public void rightClickOnWEbElement(WebDriver driver,WebElement element)
	{
	Actions act=new Actions(driver);
	act.contextClick(element).click().perform();
}
	public void passInput(WebDriver driver,WebElement element,String text)
	{
		Actions act=new Actions(driver);
		act.click(element).sendKeys(text).perform();
	}
	public void switchTowindow(WebDriver driver)
	{
		Set<String> allWindId=driver.getWindowHandles();
		for(String id:allWindId)
		{
			driver.switchTo().window(id);
		}
	}
	public void takescreenshot(WebDriver driver,String fileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./errorshots/"+fileName+".png");
		FileHandler.copy(temp,perm);		
	}
	public void toScrollBy(WebDriver driver,int x,int y)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
}
