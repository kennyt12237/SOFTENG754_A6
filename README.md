# SOFTENG754_A6
SOFTENG754 Assignment 6 - Group 11 Wildcats

Travis-CI: [![Build Status](https://travis-ci.com/kennyt12237/SOFTENG754_A6.svg?token=mtqsBvbc9xThEpxPsTqd&branch=main)](https://github.com/kennyt12237/SOFTENG754_A6)

Group Members
---

| Name              | upi       |
| ----------------- | --------- |
| Charles Paterson  | cpat430   |
| Kenny Tang        | ktan601   |
| Daniel Dowling    | ddow731   |
| Solomon John      | sjoh694   |

## How to run

### The application

- Run `./gradlew bootrun` in the terminal
- Open a new chrome window (currently, only chrome browser compatibility)
- Navigate to `http://localhost:8080/login`
- From there you should be able to use the app.

### The modules

#### Authentication System - `http://localhost:8080/login`
- Any registered users in the system can login using the login button
with their credentials or they can log in with SSO.
- Once they have logged in, they will be redirected to the welcome page.
- From the welcome page, they can join a lecture that they are enrolled in. 

#### Interactive Tool/Card Game - `http://localhost:8080/CardGame`
- Currently just a single player, simplified version of the game 'last card'. Use the buttons on the screen
  to play, and click on the help icon to see the rules.
- The page currently includes two testing elements. One will add a specified card to your hand. The other will add
  the specified card to the 'top' of the deck (the card that is being displayed). To use these, you MUST follow the 
  format specified on the page. Specifically, Cards can only be generated by inputting into the suit field
  (0 for Diamonds, 1 for Hearts, 2 for Clubs and 3 for Spades) and the value field (0-12, with 0 being Ace and 
  13 being King). 
- At this stage, the start game button is not used for anything.

#### Lecturer Main Window - `http://localhost:8080/mainroom-lecturer-screen`
- This Screen Shows the controls available to The lecturer.
- The Lecturer Can Add Breakout rooms, Import Breakout Rooms, Enable Breakout Rooms, Add Topic to a Breakout room on this page. 
- If Breakout rooms are open, the lecturer is also able to see who is in the Breakout rooms and the main room
- The lecturer can also be notified of finished activities and invite requests to join a Breakout room 

#### Student Window - `http://localhost:8080/student-room?user=sat230`
- This Screen Shows the student's perspective of the main room and breakout room.
- The students are shown available breakout rooms once the lecturer Enables them.
- Breakout room be joined by pressing the Join button.
- Once In a Breakout Room, students have the option to notify the lecturer the activity is completed.
- Once In a Breakout Room, students can also invite the lecturer to join the Breakout Room. 

#### Question System: For Lecturer - `http://localhost:8080/lecturerScreen`
- A System for the lecturer to receive questions from students
- Currently, the lecturer has to press 'Receive Question' button to receive a question. Once pressed, the lecturer is alerted 
  on screen that they have received a question. 
- The lecturer then can view the question and can perform various actions. Actions include marking as read, flagging, deleting, 
  and storing the question in the form of a button. The lecturer will then be alerted for actions made, 
- When question is stored, the lecturer can view the questions by pressing the 'View Database' button. 

#### Question System: For Students - `http://localhost:8080/lecture`
- A System for the student to ask questions in a lecture
- Student can type questions into the text input and can mark question as urgent, then press 'Ask Question' to send an anonymous
  question on screen. 
- Once sent to the lecture screen, the question will be displayed as anonymous and student can upvote.

### The tests

- Run `./gradlew cucumber' in the terminal

### Note

Please note that between some step definitions, there are similar but not reused steps. The reason for this was so 
that we could modularise the code which would be easier for a new developer to work on.

It was also so that we could add tags to some test cases, because they wouldn't work otherwise. Due to some issues 
between using drivers that were called in different step definitions within separate classes.
This would often lead to a NullPointerException causing the tests to fail unnecessarily.

Some issues that may be faced with this is that when adding new features, there might be duplicate step
definitions which would need to be different to any of the existing user stories.
