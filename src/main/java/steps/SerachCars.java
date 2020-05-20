package steps;



import java.util.List;

import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CarSearchPage;
import pages.CarsGuideHomePage;
import utilities.TestBase;

public class SerachCars {
	
	CarsGuideHomePage homePage;
	CarSearchPage searchCars;

	@Given("^I am on the Home Page of cars guide website having title \"([^\"]*)\"$")
	public void i_am_on_the_Home_Page_of_cars_guide_website_having_title(String title) throws Throwable {
		TestBase.driver.get("https://www.carsguide.com.au/");
		homePage=new CarsGuideHomePage(); 
		System.out.println("The page title is : "+homePage.verifyTitle());
		Assert.assertEquals(homePage.verifyTitle(), title);		
	}

	@When("^I move to the main menu$")
	public void i_move_to_the_main_menu(List<String> list) throws Throwable {
		String menu=list.get(1);
		System.out.println("Menu selected is "+menu);
		homePage.moveToBuySellMenu();
	}

	@And("^click on Search Cars link under Buy section$")
	public void click_on_Search_Cars_link_under_Buy_section() {
		searchCars=homePage.clickOnSearchCarsLink();
	}

	@And("^Select car brand as \"([^\"]*)\" from dropdown$")
	public void select_car_brand_as_from_dropdown(String carBrand) throws Throwable {
		searchCars.selectCarMake(carBrand);
	}

	@And("^Select car model as \"([^\"]*)\" from dropdown$")
	public void select_car_model_as_from_dropdown(String carModel) throws Throwable {
		searchCars.selectCarModel(carModel);
	}

	@And("^Select location as \"([^\"]*)\" from dropdown$")
	public void select_location_as_from_dropdown(String location) throws Throwable {
		searchCars.selectLocation(location);
	}

	@And("^Select price as \"([^\"]*)\" from dropdown$")
	public void select_price_as_from_dropdown(String price) throws Throwable {
		searchCars.selectPrice(price);
	}

	@Then("^click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
		searchCars.clickOnFindMyNxtCarBtn();
	}

	@Then("^I should see list of serach cars$")
	public void i_should_see_list_of_serach_cars() throws Throwable {
		System.out.println("Car list is displayed");
	}

	@And("^the page title should be \"([^\"]*)\"$")
	public void the_page_title_should_be(String title) throws Throwable {
		Assert.assertEquals(TestBase.driver.getTitle(), title);
	}

}
