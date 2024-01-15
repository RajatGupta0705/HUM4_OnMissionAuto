Feature: Checkout Page validation

  Background: User Login
    Given Open the "SauceLabDemo" site in QA environment in "Chrome" browser
    When Provide username and password with "valid" criteria in "chrome" browser and login to the site
    Then Product page should be displayed
    When User adds the products into Cart
    And User clicks on cart icon

  Scenario: Checkout page
    When User clicks on Checkout button
    Then User should get redirected to Checkout page

  Scenario: Fill the user details on Checkout page
    When User clicks on Checkout button
    Given User should get redirected to Checkout page
    When User should enter all the user details
    And User clicks on Continue button
    Then User should get redirected to Checkout Overview page

