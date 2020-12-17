Feature: Check that 'Українська' is present in dropdown

  Scenario:Check that 'Українська' language exist in dropdown
    Given I am on the demo.prestashop.com main page
    When I click on the list of languages
    And I see that 46 languages exists in Language dropdown in the top menu
    Then I see that 'Українська' language exist in dropdown
