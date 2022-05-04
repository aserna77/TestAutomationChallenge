package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage =  testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
       Assert.assertTrue(checkoutPage.VerifyPromoBtn());
       Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException {
		checkoutPage.CheckoutItems();
	}

}
