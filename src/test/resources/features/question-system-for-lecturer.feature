@QuestionSystemForLecturer
Feature: Question System For Lecturer during Lecture

  Background:
    Given lecturer visits "/login" and then logs in
    And Lecturer receives question "Can you explain interactivity?"
    When Lecturer presses view question button

  Scenario: Lecturer receives anonymous question
    Then Lecturer sees anonymous question as "Anonymous: Can you explain interactivity?"

  Scenario: Lecturer marks question read
    And Lecturer presses mark button
    Then Lecturer sees anonymous question as "Anonymous: Can you explain interactivity?"
    And Lecturer sees question mark alert "Marked"

  Scenario: Lecturer flags question
    And Lecturer presses the flag button
    Then Lecturer sees anonymous question as "Anonymous: Can you explain interactivity?"
    And Lecturer sees question flag alert "Flagged"

  Scenario: Lecturer deletes question
    And Lecturer presses the delete button
    Then Lecturer sees anonymous question as ""

  Scenario: Lecturer flags and deletes question
    And Lecturer presses the flag button
    Then Lecturer sees anonymous question as "Anonymous: Can you explain it again?"
    And Lecturer sees question flag alert "Flagged"
    When Lecturer presses the delete button
    Then Lecturer sees anonymous question as ""

  Scenario: Lecturer stores question
    And Lecturer presses the store button
    Then Lecturer sees anonymous question as "Anonymous: Can you explain it again?"
    And Lecturer sees question database alert "Stored"
    When Lecturer presses View Database
    Then Lecturer sees question in database "Anonymous: Can you explain it again?"