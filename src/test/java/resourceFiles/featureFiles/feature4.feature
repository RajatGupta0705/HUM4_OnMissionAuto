Feature: Thank you Page validation

  Background: User Login
    Given Open the "SauceLabDemo" site in QA environment in "Chrome" browser
    When Provide username and password with "valid" criteria in "chrome" browser and login to the site
    Then Product page should be displayed
    When User adds the products into Cart
    And User clicks on cart icon
    When User clicks on Checkout button
    And User should get redirected to Checkout page
    And User should enter all the user details
    And User clicks on Continue button
    Then User should get redirected to Checkout Overview page

  Scenario: Validate Thank you page
    When clicking on finish button
    Then order complete page should be displayed
    And Thank you message should be displayed
