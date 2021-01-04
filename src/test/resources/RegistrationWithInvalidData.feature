Feature: Registration with invalid data

  Background: User enters data
    Given I am on the demo.prestashop.com main page
    When I click on Sign in button
    And I click on No account? Create one here link

  Scenario: Registration with invalid data
    Given I fill First name field with James8 and rest fields valid data
    And I check that First name higlighted in red
    Then I check that pop-up with text 'Invalid format.' appear under field

