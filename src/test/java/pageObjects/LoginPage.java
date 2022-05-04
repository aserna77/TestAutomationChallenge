package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginButton = By.id("btnLogin");
	
	public void sendUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void sendPassword(String psw) {
		driver.findElement(password).sendKeys(psw);
	}
	
	public void submit() {
		driver.findElement(loginButton).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
