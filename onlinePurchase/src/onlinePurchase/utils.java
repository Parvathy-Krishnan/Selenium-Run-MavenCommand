package onlinePurchase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

// For common methods
public class utils {
		
	public static WebDriver driver;


	// Load page and fetch page title
	public static void loadPage() {
	      driver = new ChromeDriver();
	      driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  	System.out.println(driver.getTitle());
	   }
	
	
	// Search for specific product
	public static void searchProduct(String productNameInput) {
	System.out.println(driver.findElements(eli.productList).get(0).getText());
	
	driver.findElement(eli.searchTextbox).sendKeys(productNameInput);
	driver.findElement(eli.searchButton).click();
	
}
	
	// Add product to Cart
	public static void addtoCartAssert() {
		driver.findElements(eli.addToCartButton).get(0).click();
		
		String itemCount = driver.findElement(eli.itemLabel).getText();
		String itemValue = String.valueOf(itemCount);
		System.out.println(itemValue);
		Assert.assertNotEquals(itemValue, "0");
	}
	
	// Apply Promotion code to get discount
	public static void applyPromoCode() {
		driver.findElement(eli.promoCode).sendKeys("rahulshettyacademy");
		driver.findElement(eli.promoApplyButton).click();
	}
	
	// Confirm the order by choosing country and accepting Terms and Conditions
	public static void confirmOrder() {
		// Choose the country from the country dropdown
		Select chooseCountry = new Select(driver.findElement(By.tagName("select")));
		chooseCountry.selectByValue("India");

		// Accept the Terms and Condition by clicking on the radio button 
		driver.findElement(eli.tcCheckbox).click();
		
		// Confirm the order placement
		driver.findElement(eli.proceedButton).click();
	}
	
	
	
	
	
	
	
}

