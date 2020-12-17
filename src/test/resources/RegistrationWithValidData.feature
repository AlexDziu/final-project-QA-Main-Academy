Feature: Registration with valid data

  Scenario: User registration
    Given I am on the demo.prestashop.com main page
    When I lick on Sign in button
    And I click on No account? Create one here link
    And I fill the form with valid data
    Then I check my name appear near cart button