Feature:  Split students into smaller groups

  Background: I have a couple of students in the main room
    Given the students "cpat430" and "akha379" and "abc123" are in the mainroom

  Scenario: Lecturer Opens Breakout Rooms
    Given I visit "/mainroom-lecturer-screen"
    When I press the AddBreakoutRoom button
    Then I should see a new breakout room created