package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.TestBase;

public class CarsGuideHomePage extends TestBase{
	
	
	@FindBy(xpath = "//a[contains(text(),'buy + sell')]")
	WebElement buySellLink;

	@FindBy(xpath = "//a[contains(text(),'Search Cars')]")
	WebElement searchCarsLink;

	@FindBy(xpath = "//a[@data-gtm-label='sub nav used cars search']")
	WebElement usedLink;

	@FindBy(xpath = "//a[@data-gtm-label='top nav car reviews']")
	WebElement reviewsLink;
	

	
	public CarsGuideHomePage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	
	public void moveToBuySellMenu() {
		
		new Actions(driver).moveToElement(buySellLink).perform();
	}

	public CarSearchPage clickOnSearchCarsLink() {
		searchCarsLink.click();
		return new CarSearchPage();
	}

	public UsedCarsSearchPage clickOnUsedLink() {
		usedLink.click();
		return new UsedCarsSearchPage();
	}
	
	public void clickOnSellMyCarLink() {
		
	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}
