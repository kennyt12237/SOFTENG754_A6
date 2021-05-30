@breakout-room-activity
Feature:  Check In On Student Sub groups

  Background: I have a couple of students in the main room and the Lecturer
    Given the Lecturer and students "cpat430" and "akha379" and "abc123"  and "sat230" and "has379" are in the mainroom

  Scenario Outline: Lecturer Should be able to check users in main room and sub groups
    Given I visit page "/mainroom-lecturer-screen"
    And There is a breakout room
    When students <user> joins The breakout room
    Then I should be able to see <user> in the breakout room.

    Examples:
      | user   |
      | "cpat430" |
      | "akha379" |