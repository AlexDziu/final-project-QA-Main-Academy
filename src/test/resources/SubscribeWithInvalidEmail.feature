Feature: Check that error Invalid email address

  Scenario: User introduces incorrect email
    Given I am on the demo.prestashop.com main page
    When I enter 'tttt@tt' email
    Then I check that error message 'This email address is already registered.' appears