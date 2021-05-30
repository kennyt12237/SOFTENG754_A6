@breakout-room
Feature:  Split students into smaller groups

  Background: I have a couple of students in the main room
    Given the students "cpat430" and "akha379" and "abc123" are in the mainroom

  Scenario Outline: Lecturer Opens Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Add button <num1> times
    Then I should see <num2> breakout rooms created

    Examples:
      | num1 | num2 |
      | 1    | 1    |
      | 1    | 2    |
      | 1    | 3    |

  Scenario: Lecturer Enables Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Enable button
    Then I should see "Breakout Rooms Enabled"

  Scenario: Lecturer Disables Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Disable button
    Then I should see "Breakout Rooms Disabled"

  Scenario Outline: The Breakout Room Should Have a Topic Identifier
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Add button
    And I click on the Topic Link of the breakout room
    And Type in <topic name> as the topic name
    And press Add topic button.
    Then I should see <display name> as the topic name for that breakout room.

    Examples:
      | topic name       | display name     |
      | "SE754 Group 1"  | "SE754 Group 1"  |
      | "SE754 Group 11" | "SE754 Group 11" |