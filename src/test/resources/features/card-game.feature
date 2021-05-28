@card-game
Feature: CardGame

  Scenario: Successfully entering the game
    Given I visit "/BreakoutRoom"
    And I am in the correct group
    When I press the join CardGame button
    Then I should be redirected to the Card Game.






