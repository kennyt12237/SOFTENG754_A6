Feature: UserAuthentication

  Background: I have enrolled a couple students
    Given the students "cpat430" and "akha379" are enrolled with passwords "myPassword1"

  Scenario Outline: Logging into the lecture system
    Given I have entered username <username> into the login page
    And I have entered password <password> into the login page
    When I press login
    Then My status in the system should be <status>

    Examples:
      | username   | password      | status   |
      | "cpat430"  | "myPassword1" | "true"   |
      | "akha379"  | "myPassword1" | "true"   |
      | "sche779"  | "myPassword1" | "false"  |
