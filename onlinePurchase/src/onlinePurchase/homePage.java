package onlinePurchase;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class homePage {
	


    @BeforeMethod
	public void loadUrl() {
		 utils.driver = new ChromeDriver();
		 utils.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		 utils.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  	System.out.println(utils.driver.getTitle());

	
}
	
	@AfterTest
	public void closeWindow() {
		utils.driver.quit();
	}
	

	
	
	// add product to cart
	@Test(enabled=true)
	public void searchProduct() throws InterruptedException {
		

		String productNameInput = "carrot"; 	

		// Search for product
		utils.searchProduct(productNameInput);
		Thread.sleep(3000);
		
		// Add product to cart and assert the product is added as new item 
		utils.addtoCartAssert();
		
	
	  }
	


	// Verify product added to the cart
	@Test(enabled=false)
	public void checkout() throws InterruptedException {
		
		String productNameInput = "Carrot"; 	

		// Search for product
		utils.searchProduct(productNameInput);
		Thread.sleep(3000);
		
		// Add product to cart and assert the product is added as new item 
		utils.addtoCartAssert();

		
		// Click proceed to check out button
		utils.driver.findElement(eli.cartIcon).click();
		utils.driver.findElement(eli.proceedCheckout).click();
		Thread.sleep(3000);
		
		// split the text of the added item and verify it with the searched item
		String[] addedProduct = utils.driver.findElement(eli.addedItem).getText().split(" ");
		System.out.println(addedProduct[0]);
		
		Assert.assertEquals(addedProduct[0], productNameInput);
	}
	

		
		// Verify the promotion code is applied successfully using Explicit Wait
		@Test(enabled=false)
		public void verifyPromoCode() throws InterruptedException {
			String productNameInput = "Carrot"; 	

			// Search for product
			utils.searchProduct(productNameInput);
			Thread.sleep(3000);
			
			// Add product to cart and assert the product is added as new item 
			utils.addtoCartAssert();
			
			// Click proceed to check out button
			utils.driver.findElement(eli.cartIcon).click();
			utils.driver.findElement(eli.proceedCheckout).click();
			Thread.sleep(3000);
			
			// Type the promotion code in the text box and click apply button 
			utils.applyPromoCode();

			// Explicit Wait using WebDriverWait - Wait until the "applying" button gets invisible
			WebDriverWait wait = new WebDriverWait(utils.driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOf(utils.driver.findElement(eli.applyingButton)));
			
			// Assert the success message after applying the code
			wait.until(ExpectedConditions.visibilityOf(utils.driver.findElement(eli.promoCheckText)));
			Assert.assertTrue(utils.driver.findElement(eli.promoCheckText).getText().contains("Code applied ..!"));
			
			
		}
		
		// Place Order - Choosing dropdown and checkbox
				@Test(enabled=false)
				public void placeOrder() throws InterruptedException {
					String productNameInput = "Carrot"; 	

					// Search for product
					utils.searchProduct(productNameInput);
					Thread.sleep(3000);
					
					// Add product to cart and assert the product is added as new item 
					utils.addtoCartAssert();
					
					// Click proceed to check-out button
					utils.driver.findElement(eli.cartIcon).click();
					utils.driver.findElement(eli.proceedCheckout).click();
					Thread.sleep(3000);
					
					// Click place order button
					utils.driver.findElement(eli.placeOrderButton).click();

					// Confirm order by choosing country and terms and conditions
					utils.confirmOrder();

					
				}
				

					
				
				
				
				
	  }
	

	

	
	
	

