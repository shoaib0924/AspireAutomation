package automation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	
	WebDriver driver;
	
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='login']")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	public WebElement LogIn;
	
	@FindBy(xpath="//a[@id='result_app_1']")
	public WebElement inventory;
	
	@FindBy(xpath="//a[@id='result_app_2']")
	public WebElement manufacturing;
	
	@FindBy(xpath="//button[@title='Products']")
	public WebElement products;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	public WebElement productsSubLink;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	public WebElement create;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement save;
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	public WebElement edit;
	
	@FindBy(xpath="//button[@name='action_confirm']")
	public WebElement confirm;
	
	@FindBy(xpath="//button[@name='button_mark_done'][4]")
	public WebElement markAsDone;
	
	@FindBy(xpath="//input[@id='o_field_input_11']")
	public WebElement productName;
	
	@FindBy(xpath="//button[@name='action_update_quantity_on_hand']")
	public WebElement updateQuantity;
	
	@FindBy(xpath="//input[@name='inventory_quantity']")
	public WebElement quantity;
	
	@FindBy(xpath="//a[@title='Home menu']")
	public WebElement homeMenu;
	
	@FindBy(xpath="//div[@name='product_id']/div/div/input")
	public WebElement productSearch;
	
	@FindBy(xpath="(//input[@name='product_qty'])[1]")
	public WebElement productQuanity;
	
	@FindBy(xpath="//footer/button[@class='btn btn-primary']")
	public WebElement ok;
	
	@FindBy(xpath="//i[@title='Remove']")
	public WebElement remove;
	
	@FindBy(xpath="//i[@title='Search...']")
	public WebElement search;
	
	@FindBy(xpath="//input[@title='Search for records']")
	public WebElement searchOrder;
	
	@FindBy(xpath="//div[@class='oe_kanban_details']/div/div[1]")
	public List<WebElement> searchedProduct;
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	public List<WebElement> orderList;
	
	@FindBy(xpath="//span[@placeholder='Manufacturing Reference']")
	public WebElement orderNumber;
	
	@FindBy(xpath="//a[@name='product_id']")
	public WebElement productID;
	
	@FindBy(xpath="//span[@name='qty_producing']")
	public WebElement quantityProducing;

	@FindBy(xpath="//img[@alt='User']")
	public WebElement user;
	
	@FindBy(xpath="//a[@data-menu='logout']")
	public WebElement Logout;
}
