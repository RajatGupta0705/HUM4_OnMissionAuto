Feature: Open URL and Login

  Scenario: User Login
  @Given Open the "SauceLabDemo" site in "QA" environment in "Chrome" browser
  @And Provide username and password
  @When Click on login button
  @Then Product page should be displayed

  Scenario: Add products in the Cart
  @Given User should be on Product page
  @And Product list should be displayed
  @When User adds the products into Cart
  @Then Cart count should get increase

  Scenario: Cart details verification
  @When User adds the products into Cart
  @When User clicks on cart icon
  @And User is redirected to cart page
  @Then List of items should be displayed
  @And Each item should be a clickable link
  @And Product price against each items should be displayed
  @And Remove button against each items should be displayed



