@AuthenticationSystem
Feature: Authentication System for joining lectures

  Background: Visiting the welcome page
    Given I visit the welcome "/welcome" page

  Scenario: Successfully joining a lecture
    Given I am authenticated
    And I am enrolled in the course
    When I press the Join Lecture button
    Then I should be redirected to the lecture

  Scenario Outline: Unsuccessfully joining a lecture
    Given My authentication status is <authenticated>
    And My enrolment status is <enrolled>
    When I press the Join Lecture button
    Then I should not be redirected to the lecture

    Examples:
    | authenticated | enrolled  |
    | "true"        | "false"   |
    | "false"       | "true"    |
    | "false"       | "false"   |