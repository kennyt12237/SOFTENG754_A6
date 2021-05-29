@Sso
Feature: SSO

  Background: I have enrolled a couple students
    Given I visit the login "/login" page for sso

  Scenario: Logging into the lecture system using SSO
    When I press the Sign in with SSO button
    Then I should see the SSO login page
    Then I can redirect to the welcome page