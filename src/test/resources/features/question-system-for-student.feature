@Question-System-For-Student
Feature: Question System for students during Lecture

  Background:
    Given Student visits "/login" and then logs in
    When Student asks question "Can you explain interactivity?"

  Scenario: Student asks anonymous question
    Then Student should see anonymous question "Anonymous: Can you explain interactivity?"