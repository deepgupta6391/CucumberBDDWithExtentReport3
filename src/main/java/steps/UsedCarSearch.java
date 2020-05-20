package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CarsGuideHomePage;
import pages.UsedCarsSearchPage;

public class UsedCarSearch {
	UsedCarsSearchPage usedCarSearchPage;
	CarsGuideHomePage homePage=new CarsGuideHomePage();

	@When("^click on Used link under Buy section$")
	public void click_on_Used_link_under_Buy_section() throws Throwable {
		usedCarSearchPage=homePage.clickOnUsedLink();
	}
	
	@And("^Select car brand as \"([^\"]*)\" from dropdown for used car search$")
	public void select_car_brand_as_from_dropdown_for_used_car_search(String carBrand) throws Throwable {
		usedCarSearchPage.selectCarMake(carBrand);
	}

	@And("^Select car model as \"([^\"]*)\" from dropdown for used car search$")
	public void select_car_model_as_from_dropdown_for_used_car_search(String carModel) throws Throwable {
		usedCarSearchPage.selectCarModel(carModel);
	}

	@And("^Select location as \"([^\"]*)\" from dropdown for used car search$")
	public void select_location_as_from_dropdown_for_used_car_search(String location) throws Throwable {
		usedCarSearchPage.selectLocation(location);
	}

	@And("^Select price as \"([^\"]*)\" from dropdown for used car search$")
	public void select_price_as_from_dropdown_for_used_car_search(String price) throws Throwable {
		usedCarSearchPage.selectPrice(price);
	}

	@Then("^click on \"([^\"]*)\" button for used car search$")
	public void click_on_button_for_used_car_search(String arg1) throws Throwable {
		usedCarSearchPage.clickOnFindMyNxtCarBtn();
	}
	
	@Then("^I should see list of used cars which was searched$")
	public void i_should_see_list_of_used_cars_which_was_searched() throws Throwable {
		System.out.println("List of used cars are displayed");
	}
}
