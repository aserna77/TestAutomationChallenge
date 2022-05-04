package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

	public WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By addUserButton = By.id("btnAdd");
	private By searchSystemUser = By.id("searchSystemUser_userName");
	private By searchButton = By.id("searchBtn");
	private By successToastMessage = By.cssSelector(".message.success.fadable");
	
	public void addNewUser() {
		driver.findElement(addUserButton).click();
	}
	
	public void searchSystemUser(String systemUser) {
		driver.findElement(searchSystemUser).sendKeys(systemUser);
	}
	
	public void searchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void selectUserToBeEdited(String systemUser) {
		driver.findElement(By.xpath("//a[normalize-space()='" + systemUser + "']")).click();
	}
	
	public String getSuccessToastMessage() {
		return driver.findElement(successToastMessage).getText();
	}
}
