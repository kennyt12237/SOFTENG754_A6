@QuestionSystemForStudent
Feature: Question System for students during Lecture

  Background:
    Given Student visits the site "/login"
    And Student logs in proceeding to lecture
    When Student writes question "Can you explain interactivity?"

  Scenario: Student asks anonymous question
    And Student presses ask question button
    Then Student should see anonymous question "Anonymous: Can you explain interactivity?"

  Scenario: Student marks question as urgent
    And Student checks the urgent checkbox
    And Student presses ask question button
    Then Student should see anonymous question "Anonymous: Can you explain interactivity? URGENT!!!"

  Scenario: Student upvote question
    And Student presses ask question button
    And Student upvote the question
    Then Student should see upvote count "1"