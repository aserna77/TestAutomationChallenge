package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkoutButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrderBtn =  By.xpath("//button[normalize-space()='Place Order']");

	public void CheckoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public Boolean VerifyPromoBtn() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
}
