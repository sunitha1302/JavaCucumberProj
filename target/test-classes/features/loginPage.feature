Feature: Login Functionality

  Scenario: login successfully with valid credentials
    Given User navigates to the login page
    When User enters valid credentials "standard_user" and "secret_sauce"
    Then User should be redirected to the inventory
