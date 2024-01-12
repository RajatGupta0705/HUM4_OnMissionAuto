Feature: Open URL and Login

  Background: User Login
  Given Open the "SauceLabDemo" site in QA environment in "Chrome" browser
  When Provide username and password with "valid" criteria in "chrome" browser and login to the site
  Then Product page should be displayed

  @smoketest
  Scenario: Add products in the Cart
  Given Product page should be displayed
  And Product list should be displayed
  When User adds the products into Cart
  Then Cart count should get increase

  Scenario: Cart details verification
  When User adds the products into Cart
  When User clicks on cart icon
  And User is redirected to cart page
  Then count of cart items should be same as items added to the cart
  And Each item should be a clickable link
  And Product price against each items should be displayed
  And Remove button against each items should be displayed



