@Search-Cars
Feature: Acceptance testing to validate Search cars page is working fine
  In order to validate that
  the search cars page is working fine
  we will do acceptance testing

  @Search-Cars-Positive
  Scenario: Validate Search cars page
    Given I am on the Home Page of cars guide website having title "CarsGuide: Car Reviews - New & Used Car Sales"
    When I move to the main menu
      | Menu       |
      | buy + sell |
      | reviews    |
      | news       |
      | advice     |
    And click on Search Cars link under Buy section
    And Select car brand as "BMW" from dropdown
    And Select car model as "1 Series" from dropdown
    And Select location as "NSW - Hunter" from dropdown
    And Select price as "$7,500" from dropdown
    Then click on "Find my next car" button
    Then I should see list of serach cars
    And the page title should be "Bmw 1 Series Under 7500 for Sale Hunter NSW | carsguide222"
