package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestBase;

public class PageObjectManager {

	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public AdminPage adminPage;
	public NewUserPage newUserPage;
	public TestBase testBase;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public HomePage getHomePage() {
		homePage = new HomePage(driver);
		return homePage;
	}
	
	public AdminPage getAdminPage() {
		adminPage = new AdminPage(driver);
		return adminPage;
	}
	
	public NewUserPage getNewUserPage() {
		newUserPage = new NewUserPage(driver);
		return newUserPage;
	}
	
	public TestBase getTestBase() {
		testBase = new TestBase();
		return testBase;
	}
	
}
