Feature: Check that error Invalid email address

  Scenario: User introduces incorrect email
    Given I am on the demo.prestashop.com main page
    When I enter 'email@1' email
    Then I see error message 'This email address is already registered.' appears