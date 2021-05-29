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