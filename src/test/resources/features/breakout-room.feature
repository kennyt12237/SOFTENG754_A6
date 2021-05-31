@BreakoutRoom
Feature:  Split students into smaller groups

  Background: I have a couple of students in the main room
    Given the Lecturer and students "cpat430" and "akha379" and "abc123"  and "sat230" and "has379" are in the mainroom

  Scenario Outline: Lecturer Opens Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Add button <num1> times
    Then I should see <num2> breakout rooms created

    Examples:
      | num1 | num2 |
      | 1    | 1    |
      | 2    | 2    |
      | 3    | 3    |

  Scenario: Lecturer Enables Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Enable button
    Then I should see "Breakout Rooms Enabled"

  Scenario Outline: Lecturer Enables Breakout Rooms
    Given I visit page "/student-room" as <student>
    And  Lecturer visit page "/mainroom-lecturer-screen"
    And There is a breakout room
    When the Lecturer presses the Enable button
    Then I should see breakout rooms open

    Examples:
      | student   |
      | "cpat430" |
      | "akha379" |

  Scenario: Lecturer Disables Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    When I press the Disable button
    Then I should see "Breakout Rooms Disabled"

  Scenario Outline: The Breakout Room Should Have a Topic Identifier
    Given I visit page "/mainroom-lecturer-screen"
    And There is a breakout room
    When I click on the Topic Link of the breakout room
    And Type in <topic name> as the topic name
    And press Add topic button.
    Then I should see <display name> as the topic name for that breakout room.

    Examples:
      | topic name       | display name     |
      | "SE754 Group 1"  | "SE754 Group 1"  |
      | "SE754 Group 11" | "SE754 Group 11" |

  Scenario: Lecturer Imports Groups From Canvas And Creates Breakout Rooms
    Given I visit page "/mainroom-lecturer-screen"
    And The Canvas Group contains 2 groups
    When I press the Import button
    Then I should see 2 breakout rooms created