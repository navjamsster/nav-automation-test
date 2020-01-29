package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageElement {

	WebDriver driver = null;
	By search_box = By.name("q");
	By search_btn = By.name("btnK");

	public GoogleSearchPageElement(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextinSearchBox(String text) {
		this.driver.findElement(search_box).sendKeys(text);
	}

	public void clickOnButton() {
		this.driver.findElement(search_btn).sendKeys(Keys.RETURN);
	}
}
