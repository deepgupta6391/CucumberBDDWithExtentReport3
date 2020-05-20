package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.TestBase;

public class UsedCarsSearchPage{
	
	@FindBy(xpath="//select[@id='makes']")
	WebElement selectCarBrand;
	
	@FindBy(xpath="//select[@id='models']")
	WebElement selectCarModel;
	
	@FindBy(xpath="//select[@id='locations']")
	WebElement selectLocation;
	
	@FindBy(id="priceTo")
	WebElement selectPrice;
	
	@FindBy(id="search-submit")
	WebElement findMyNxtCar;
	
	public UsedCarsSearchPage() {
		// TODO Auto-generated constructor stub
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(TestBase.driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public void selectCarMake(String carBrand) {
		new Select(selectCarBrand).selectByVisibleText(carBrand);
	}
	
	public void selectCarModel(String carModel) {
		new Select(selectCarModel).selectByVisibleText(carModel);
	}
	
	public void selectLocation(String location) {
		new Select(selectLocation).selectByVisibleText(location);
	}
	
	public void selectPrice(String price) {
		new Select(selectPrice).selectByVisibleText(price);
	}
	
	public void clickOnFindMyNxtCarBtn() {
		findMyNxtCar.click();
	}

}
