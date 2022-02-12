package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AspireTest {
	
	WebDriver driver;
	PageObjects object;
	WebDriverWait wait;
	private String productName = "Aspire_Product_Test_1";
	private String productQuantity = "10";
	private String orderNumber = "";
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("-------------------------------------------------");
		System.out.println("Test Execution Started");
		System.out.println("-------------------------------------------------");
		ChromeOptions chromeOptions = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		System.out.println("Browser Launched");
	}
	
	@Test(priority = 0)
	public void loginApplication() {
		driver.get("https://aspireapp.odoo.com");
		object = new PageObjects(driver);
		object.username.sendKeys("user@aspireapp.com");
		System.out.println("LOG: Entered username");
		object.password.sendKeys("@sp1r3app");
		System.out.println("LOG: Entered password");
		object.LogIn.click();
		System.out.println("LOG: Clicked Login Button");
		wait.until(ExpectedConditions.visibilityOf(object.user));
		System.out.println("LOG: User has logged in");
	}
	
	@Test (priority = 1)
	public void createProduct() throws InterruptedException {
		object.inventory.click();
		System.out.println("LOG: Clicked Inventory link");
		object.products.click();
		object.productsSubLink.click();
		System.out.println("LOG: Clicked Product Link");
		object.create.click();
		System.out.println("LOG: Clicked Create button");
		object.productName.sendKeys(productName);
		System.out.println("LOG: Product Name Entered [" + productName + "]");
		object.save.click();
		Thread.sleep(5000);
		System.out.println("Click Save");
		object.updateQuantity.click();
		Thread.sleep(5000);
		object.create.click();
		System.out.println("Clicked create");
		Thread.sleep(5000);
		object.quantity.clear();
		object.quantity.sendKeys("100");
		System.out.println("LOG: Entered quantity [100]");
		object.save.click();
		System.out.println("Clicked save");
	}
	
	@Test (priority = 2)
	public void placeOrder() throws InterruptedException {
		object.homeMenu.click();
		System.out.println("LOG: Clicked Home Menu");
		object.manufacturing.click();
		System.out.println("LOG: Clicked Manufacturing");
		object.create.click();
		System.out.println("LOG: Clicked create");
		Thread.sleep(5000);
		object.productSearch.sendKeys(productName);
		System.out.println("LOG: Entered product name");
		Thread.sleep(2000);
		object.productSearch.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		object.productQuanity.sendKeys(productQuantity);
		System.out.println("LOG: Entered quanntity");
		Thread.sleep(5000);
		object.confirm.click();
		Thread.sleep(5000);
		object.markAsDone.click();
		Thread.sleep(5000);
		object.ok.click();
		Thread.sleep(5000);
		object.ok.click();
		orderNumber = object.orderNumber.getText();
		object.save.click();
	}

	@Test (priority = 3)
	public void verifyOrder() throws InterruptedException {
		object.homeMenu.click();
		System.out.println("LOG: Clicked Home Menu");
		object.manufacturing.click();
		System.out.println("LOG: Clicked Manufacturing");
		Thread.sleep(5000);
		object.remove.click();
		Thread.sleep(2000);
		object.searchOrder.sendKeys(orderNumber);
		Thread.sleep(2000);
		object.searchOrder.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		for(WebElement element: object.orderList) {
			if (element.getText().equalsIgnoreCase(orderNumber)) {
				element.click();
				break;
			}
		}
		System.out.println("LOG: Verifying Order Number: Expected [" + orderNumber + "] Actual [" + object.orderNumber.getText() +"]");
		System.out.println("LOG: Verifying Product ID: Expected [" + productName + "] Actual [" + object.productID.getText() +"]");
		System.out.println("LOG: Verifying Product Quatity: Expected [" + productQuantity + "] Actual [" + object.quantityProducing.getText() +"]");
	}
	
	@Test (priority = 4)
	public void logoutApplication() {
		System.out.println("LOG: Logging out application");
		wait.until(ExpectedConditions.visibilityOf(object.user));
		object.user.click();
		object.Logout.click();
		System.out.println("LOG: Clicked logout");
		wait.until(ExpectedConditions.visibilityOf(object.username));
		System.out.println("LOG: User has logged out");
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
		System.out.println("-------------------------------------------------");
		System.out.println("Test Execution Ended");
		System.out.println("-------------------------------------------------");
	}
}
