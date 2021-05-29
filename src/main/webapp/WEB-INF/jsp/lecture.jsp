<html>

<head>
    <title>Lecture for SOFTENG 754</title>
</head>

<body>
<label id="message">Hi ${name}! </label>
<p id="lecture-welcome">Welcome to SOFTENG 754</p>
<p style="color: #ff0000" id="error-message">${errorMessage}</p>

<form action="/lectureQuestion" method="post">
    Enter Anonymous Question : <input type="text" name="question" id="question"/>
    Urgent? : <input type="checkbox" name="urgent" id="urgent"/>
    <input type="submit" id="askQuestionBtn" value="Ask Question"/>
</form>

<form action="/lectureUpvoteQuestion" method="post">
    <p style="display:inline" name="questionText" id="questionText">${questionText}</p>
    <p style="display:inline" name="upvote" id="upvote">${upvote}</p>
        <input type="submit" value="Upvote" ${questionText.length() > 0 ? '' : 'hidden'}/>
</form>

<form action="/lecturerScreen" method="get">
    <input type="submit" value="switchToLecturer" ${questionText.length() > 0 ? '' : 'hidden'}/>
</form>
</body>

</html>