@Used-Cars-Search
Feature: Acceptance testing to validate used car search page is working fine
  In order to validate that
  the used car search page is working fine
  we will do acceptance testing

  @Used-Cars-Search-Positive
  Scenario: Validate Used car search page
    Given I am on the Home Page of cars guide website having title "CarsGuide: Car Reviews - New & Used Car Sales"
    When I move to the main menu
      | Menu       |
      | buy + sell |
      | reviews    |
      | news       |
      | advice     |
    And click on Used link under Buy section
    And Select car brand as "Audi" from dropdown for used car search
    And Select car model as "A5" from dropdown for used car search
    And Select location as "VIC - Central Victoria" from dropdown for used car search
    And Select price as "$5,000" from dropdown for used car search
    Then click on "Find my next car" button for used car search
    Then I should see list of used cars which was searched
    And the page title should be "Used Audi A5 Under 5000 for Sale Central Victoria VIC | carsguide2222"

