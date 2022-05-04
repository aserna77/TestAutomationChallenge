package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewUserPage;
import utils.TestBase;
import utils.TestContextSetup;

public class AdminPageStepDefinition {

	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public Properties prop;
	LoginPage loginPage;
	TestBase testBase;
	HomePage homePage;
	AdminPage adminPage;
	NewUserPage newUserPage;
	
	public AdminPageStepDefinition(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
		this.adminPage = testContextSetup.pageObjectManager.getAdminPage();
		this.homePage = testContextSetup.pageObjectManager.getHomePage();
		this.newUserPage = testContextSetup.pageObjectManager.getNewUserPage();
		this.testBase = testContextSetup.pageObjectManager.getTestBase();
		prop = testBase.getProperties();
	}
	
	@Given("User is on Admin Landing Page")
	public void user_is_on_admin_landing_page() throws IOException {
		loginPage.sendUsername(prop.getProperty("username"));
	    loginPage.sendPassword(prop.getProperty("password"));
	    loginPage.submit();
	    homePage.selectAdminTab();
	    
	}

	@When("user select the add button")
	public void user_select_the_add_button() {
	    adminPage.addNewUser();
	}

	@Then("the add user page is open")
	public void the_add_user_page_is_open() {
	    Assert.assertTrue(newUserPage.getNewUserTitle().equalsIgnoreCase(prop.getProperty("newUserPageTitle")));
	}

	@Then("user fill all fields and save changes")
	public void user_fill_all_fields_and_save_changes() throws InterruptedException {
	    newUserPage.selectUserRole(prop.getProperty("userRole"));
	    newUserPage.setEmployeeName(prop.getProperty("employeeName"));
	    newUserPage.setSystemUserName(prop.getProperty("systemUserName"), prop.getProperty("counter"));
	    int counter = Integer.parseInt(prop.getProperty("counter"))+1;
	    testBase.setProperties("counter",Integer.toString(counter));
	    newUserPage.setSystemUserStatus(prop.getProperty("userStatus"));
	    newUserPage.setUserPassword(prop.getProperty("newpassword"));
	    Thread.sleep(3000);
	    newUserPage.saveChanges();
	}

	@Then("a successfully create message is display")
	public void a_successfully_create_message_is_display() throws InterruptedException {
	   Assert.assertTrue(adminPage.getSuccessToastMessage().equalsIgnoreCase(prop.getProperty("successToartMessage")));
	}
}
