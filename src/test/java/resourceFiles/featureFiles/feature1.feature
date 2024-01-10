Feature: Login test

  Scenario: Do Login
    Given open login page
    When enter the credentials
    And hit login button
    Then product page should be displayed


