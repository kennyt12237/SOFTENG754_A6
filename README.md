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
