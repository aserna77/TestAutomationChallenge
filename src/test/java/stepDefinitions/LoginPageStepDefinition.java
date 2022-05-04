package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LoginPageStepDefinition {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
		
	}
	
	 @Given("^User is on OrangeHRM Landing page$")
	    public void user_is_on_orangehrm_landing_page() throws Throwable {
	        Assert.assertTrue(loginPage.getTitle().contains("OrangeHRM"));
	    }

	    @When("^User input the (.+) and (.+) into the corresponding fields$")
	    public void user_input_the_and_into_the_corresponding_fields(String username, String password) throws Throwable {
	       loginPage.sendUsername(username);
	       loginPage.sendPassword(password);
	    }

	    @Then("^User select the login button$")
	    public void user_select_the_login_button() throws Throwable {
	        loginPage.submit();
	    }

	    @Then("^Validate the OrangeHRM Home page title$")
	    public void validate_the_orangehrm_home_page_title() throws Throwable {
	    	homePage = testContextSetup.pageObjectManager.getHomePage();
	        Assert.assertTrue(homePage.getUserPanelText().contains("Welcome"));
	    }

}
