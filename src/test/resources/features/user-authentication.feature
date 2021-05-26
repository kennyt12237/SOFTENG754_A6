Feature: UserAuthentication

  Background: I have enrolled a couple students
    Given the students "cpat430" and "akha379" are enrolled with passwords "myPassword1"
    And I visit "/login"

  Scenario Outline: Successfully logging into the lecture system
    Given I have entered username <username> into the username field
    And I have entered password <password> into the password field
    When I press login button
    Then I should see the welcome page

    Examples:
      | username   | password      |
      | "cpat430"  | "myPassword1" |
      | "akha379"  | "myPassword1" |
      | "cpat430@aucklanduni.ac.nz" | "myPassword1" |

  Scenario Outline: Unsuccessfully logging into the lecture system.
    Given I have entered username <username> into the username field
    And I have entered password <password> into the password field
    When I press login button
    Then I should not see the welcome page
    And I should see an error message

    Examples:
      | username   | password      |
      | "sche779"  | "myPassword1" |
      | ""         | "myPassword1" |
      | "cpat430"  | ""            |
      | ""         | ""            |
