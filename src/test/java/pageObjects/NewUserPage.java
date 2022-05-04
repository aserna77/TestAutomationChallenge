package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.TestBase;

public class NewUserPage {

	public WebDriver driver;
	public Properties prop;
	TestBase testBase;
	
	
	public NewUserPage(WebDriver driver){
		this.driver = driver;
	}
	
	By newUserPageHeading = By.id("UserHeading");
	By userRoleDropDown = By.id("systemUser_userType");
	By employeeName = By.id("systemUser_employeeName_empName");
	By userName = By.id("systemUser_userName");
	By userStatusDropDown = By.id("systemUser_status");
	By userPassword = By.id("systemUser_password");
	By confirmUserPassword = By.id("systemUser_confirmPassword");
	By saveButton = By.id("btnSave");
	
	public String getNewUserTitle() {
		return driver.findElement(newUserPageHeading).getText();
	}
	
	public void selectUserRole(String role) {
		Select userRole = new Select(driver.findElement(userRoleDropDown));
		userRole.selectByVisibleText(role);
	}
	
	public void setEmployeeName(String name) {
		driver.findElement(employeeName).sendKeys(name);
	}
	
	public void setSystemUserName(String user, String userCounter) {
		driver.findElement(userName).sendKeys(user+userCounter);
		
	}
	
	public void setSystemUserStatus(String status) {
		Select userStatus = new Select(driver.findElement(userStatusDropDown));
		userStatus.selectByVisibleText(status);
	}
	
	public void setUserPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
		driver.findElement(confirmUserPassword).sendKeys(password);
	}
	
	public void saveChanges() {
		driver.findElement(saveButton).click();
	}
}
