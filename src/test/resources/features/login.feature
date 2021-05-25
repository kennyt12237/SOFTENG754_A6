Feature: login

Scenario: login
  Given I visit "/login"
  When I enter "test" as user name field
  And I enter "password" as password field
  And I press the submit button
  Then I should see the welcome page