Feature:  Split students into smaller groups

  Background: I have a couple of students in the main room
    Given the students "cpat430" and "akha379" and "abc123" are in the mainroom

  Scenario Outline: Lecturer Opens Breakout Rooms
    Given I visit "/mainroom-lecturer-screen"
    When I press the AddBreakoutRoom button <num1> times
    Then I should see <num2> breakout rooms created

    Examples:
      | num1 | num2 |
      | 1    | 1    |
      | 2    | 2    |
      | 3    | 3    |