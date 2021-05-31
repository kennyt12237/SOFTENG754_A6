@CardGame
Feature: CardGame

  Background: I have entered the Card Game
    Given I visit a new page, "/CardGame"

  Scenario: Clicking the help icon
    When I click the help icon
    Then I should see the rules of the game

  Scenario: Seeing the top card of the deck
    Given I have clicked the start game button
    Then I should see a single card

  Scenario: Seeing your own hand
    Then I should see a hand of 7 cards


  Scenario: Drawing a card
    Given I have a hand of 7 cards
    When I have clicked the draw card button
    Then I should have a hand of 8 cards

  Scenario Outline: Placing a card
    Given I have a card with a value of <myValue> and a suit of <mySuit> in my hand
    And the top card has a value of <value> and suit of <suit>
    When I try to place the card
    Then the card should no longer be in my hand
    And the top card should have a value of <myValue> and a suit of <mySuit>
    Examples:
      |myValue|mySuit|value|suit|
      |"Queen"  |"Diamonds"|"Queen"|"Clubs"|
      |"10"     |"Spades"  |"Jack" |"Spade"|
      |"Ace"    |"Hearts"  |"Ace"  |"Hearts"|


  Scenario Outline: Attempting to place an invalid card
    Given I have a card with a value of <myValue> and a suit of <mySuit> in my hand
    And the top card has a value of <value> and suit of <suit>
    When I try to place the card
    Then the card should still be in my hand
    And the top card should have a value of <value> and a suit of <suit>
    And I can see an error message
    Examples:
      |myValue|mySuit|value|suit|
      |"Queen"|"Spades"  |"2"   |"Hearts"|
      |"8"    |"Diamonds"|"Jack"|"Clubs" |
      |"4"    |"Clubs"   |"King"|"Spades"|




