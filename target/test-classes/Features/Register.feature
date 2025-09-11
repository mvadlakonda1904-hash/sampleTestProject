Feature: User Registration on Demo Web Shop

  Scenario: Successful user registration
   	Given I am on the registration page
    When I select "Male" as gender
    And I enter "John" as first name
    And I enter "Doe" as last name
    And I enter "john.doe@example.com" as email
    And I enter "Password123!" as password
    And I enter "Password123!" as confirm password
    And I click the Register button
    Then I should see the registration confirmation message