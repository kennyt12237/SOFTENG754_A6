@Question-System-For-Student
Feature: Question System for students during Lecture

  Background:
    Given Student visits "/login" and then logs in
    When Student writes question "Can you explain interactivity?"

  Scenario: Student asks anonymous question
    And Student presses ask question button
    Then Student should see anonymous question "Anonymous: Can you explain interactivity?"

    Scenario: Student marks question as urgent
      And Student checks the urgent checkbox
      And Student presses ask question button
      Then Student should see anonymous question "Anonymous: Can you explain interactivity? URGENT!!!"