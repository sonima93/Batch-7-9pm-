package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Products")
	private WebElement Productlink;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProductBtn;
	
	@FindBy(name="productName")
	private WebElement productNameTF;
	
	@FindBy(name="productCategory")
	private WebElement productCategoryTF;
	
	@FindBy(name="quantity")
	private WebElement productQuantityTF;
	
	@FindBy(name="price")
	private WebElement productpriceTF;
	
	
	@FindBy(name="vendorId")
	private WebElement vendorIdTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement creatProductBtn;
	
	@FindBy(xpath="//button[@class='Toastify__close-button Toastify__close-button--success']")
	private WebElement producttoastCloseBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductlink() {
		return Productlink;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getProductCategoryTF() {
		return productCategoryTF;
	}

	public WebElement getProductQuantityTF() {
		return productQuantityTF;
	}

	public WebElement getProductpriceTF() {
		return productpriceTF;
	}

	public WebElement getVendorIdTF() {
		return vendorIdTF;
	}

	public WebElement getCreatProductBtn() {
		return creatProductBtn;
	}

	public WebElement getProducttoastCloseBtn() {
		return producttoastCloseBtn;
	}

	
	
}
