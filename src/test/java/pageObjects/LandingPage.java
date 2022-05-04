package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchInput = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By linkOffersPage = By.linkText("Top Deals");
	private By incrementBtn = By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");

	public void searchItem(String name) {
		driver.findElement(searchInput).sendKeys(name);
	}

	public String getProductName() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(productName).getText().split("-")[0].trim();
	}

	public void selectTopDealsPage() {
		driver.findElement(linkOffersPage).click();
	}

	public String getTitlePage() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(incrementBtn).click();
			i--;
		}
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
