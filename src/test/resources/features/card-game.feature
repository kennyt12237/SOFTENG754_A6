@card-game
Feature: CardGame

  Background: I have entered the Card Game
    Given I visit a new page, "/CardGame"

  #Scenario: Starting a game with 10 other players
  #  Given there are 10 other students in the CardGame with me
  #  When I press the start-game button
 #   Then I should see a hand of 7 cards

  Scenario: Clicking the help icon
    When I click the help icon
    Then I should see the rules of the game

    #Might remove the start game button
  Scenario: Seeing the top card of the deck
    Given I have clicked the start game button
    Then I should see a single card

    Scenario: Seeing your own hand
      Then I should see a hand of 7 cards


    Scenario: Drawing a card
      Given I have a hand of 7 cards
      When I have clicked the draw card button
      Then I should have a hand of 8 cards


