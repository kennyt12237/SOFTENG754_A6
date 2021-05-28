@card-game
Feature: CardGame

  Background: I have entered the Card Game
    Given I visit "/CardGame"

  Scenario: Starting a game with 10 other players
    Given there are 10 other students in the CardGame with me
    When I press the start-game button
    Then I should see a hand of 7 cards







