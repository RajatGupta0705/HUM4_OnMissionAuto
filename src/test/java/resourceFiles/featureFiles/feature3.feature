Feature: Checkout Overview Page validation

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
  @smoketest
  Scenario: Validate checkout information on overview page
    When Items list is visible
    Then Cart count should be same as list item count
    And Payment information should be displayed
    And Shipping information should be displayed
  @regression
  Scenario: Validate Total Amount to be paid
    When Price total should be displayed
    Then validate total amount is calculated is correctly with tax
