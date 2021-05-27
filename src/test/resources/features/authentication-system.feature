@authentication-system
Feature: Authentication System

  Scenario: Joining a lecture
    Given I visit "/welcome"
    And I am authenticated
    And I am enrolled in the course
    When I press the Join Lecture button
    Then I should be redirected to the lecture

