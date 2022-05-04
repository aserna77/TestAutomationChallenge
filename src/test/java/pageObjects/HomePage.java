package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;
	private By userPanel = By.id("welcome");
	private By adminTab = By.id("menu_admin_viewAdminModule");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUserPanelText() {
		return driver.findElement(userPanel).getText();
	}
	
	public void selectAdminTab() {
		driver.findElement(adminTab).click();
	}

}
