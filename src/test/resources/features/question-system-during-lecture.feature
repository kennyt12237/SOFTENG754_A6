Feature: Lecturer Views Question

  Scenario: Lecturer receives anonymous question
    Given Lecturer should receive "Can you explain interactivity?"
    When Lecturer presses view question button
    Then Lecturer should view "Can you explain interactivity?"
    And Lecturer receives anonymous question as "true"

  Scenario: Lecturer marks question
    Given Lecturer views question "Can you explain interactivity?"
    When Lecturer presses the mark button
    Then Lecturer sees question "Can you explain interactivity?"
    And Lecturer sees question as marked "true"

  Scenario: Lecturer flags question
    Given Lecturer views question "Can you explain interactivity?"
    When Lecturer presses the flag button
    Then Lecturer sees question "Can you explain interactivity?"
    And Lecturer sees question as flagged "true"

  Scenario: Lecturer deletes question
    Given Lecturer views question "Can you explain interactivity?"
    When Lecturer presses the delete button
    Then Lecturer should not see the question "Can you explain interactivity?"


  Scenario: Lecturer flags and deletes question
    Given Lecturer views question "Can you explain interactivity?"
    When Lecturer presses the flag button
    Then Lecturer sees question "Can you explain interactivity?"
    And Lecturer sees question as flagged "true"
    When Lecturer presses the delete button
    Then Lecturer should not see the question "Can you explain interactivity?"

  Scenario: Lecturer stores question
    Given Lecturer views question "Can you explain interactivity?"
    When Lecturer presses the store button
    Then Lecturer sees question "Can you explain interactivity?"
    And Lecturer sees question as stored "true"
    When Lecturer opens Question Database
    Then Lecturer sees question "Can you explain interactivity?"

  Scenario: Lecturer flags question
    Given Lecturer views question "Can you explain interactivity?"
    When Lecturer presses the mark as read button
    Then Lecturer sees question "Can you explain interactivity?"
    And Lecturer sees question as marked "true"