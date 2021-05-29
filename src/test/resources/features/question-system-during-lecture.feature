@Question-System
Feature: Question System during Lecture

  Background:
    Given Lecturer receives question "Can you explain interactivity?"
    When Lecturer presses view question button

  Scenario: Lecturer receives anonymous question
    Then Lecturer should view "Can you explain interactivity?"
    And Lecturer receives anonymous question as "Can you explain interactivity?"