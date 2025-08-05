package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	WebDriver driver;
	public CampaignPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignNameTF;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignNameTF() {
		return campaignNameTF;
	}

	public WebElement getStatusTF() {
		return statusTF;
	}

	public WebElement getTargetTF() {
		return targetTF;
	}

	public WebElement getDateTF() {
		return dateTF;
	}

	public WebElement getCreateCampSubmitBtnTF() {
		return createCampSubmitBtnTF;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}

	public WebElement getClosemsg() {
		return closemsg;
	}

	@FindBy(name="campaignStatus")
	private WebElement statusTF;
	

	@FindBy(name="targetSize")
	private WebElement targetTF;
	
	@FindBy(name="expectedCloseDate")
	private WebElement dateTF;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createCampSubmitBtnTF;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastmsg;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closemsg;
}
