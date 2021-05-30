@Question-System
Feature: Question System during Lecture

  Background:
    Given lecturer visits "/login" and then logs in
    And Lecturer receives question "Can you explain interactivity?"
    When Lecturer presses view question button

  Scenario: Lecturer receives anonymous question
    And Lecturer sees anonymous question as "Can you explain interactivity?"