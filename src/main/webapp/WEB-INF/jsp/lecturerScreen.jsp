<html>

<head>
    <title>Lecturer Screen for SOFTENG 754</title>
</head>

<body>
<label id="message"> Lecturer Screen </label>
<p id="lecture-welcome">Welcome to SOFTENG 754</p>
<p style="color: #ff0000" id="error-message">${errorMessage}</p>

<p style="display:inline; color: #00FF00" name="questionReceivedText" id="questionReceivedText">${questionReceivedText}</p>
<p style="display:inline; color: #00FF00" name="isStoredText" id="isStoredText">${storedText}</p>
<p style="display:inline" name="dbQuestionsText" id="dbQuestionsText">${dbQuestionsText}</p>

<form action="/receiveQuestion" method="post">
    <input type="submit" id="receiveBtn" value="Receive Question"/>
</form>

<form style="display: inline" action="/viewQuestion" method="post">
    <input type="submit" id="viewBtn" value="View Question" ${questionText.length() > 0 ? 'hidden' : ''}/>
</form>

<form style="display: inline" action="/viewDatabase" method="post">
    <input type="submit" id="dbQuestionBtn" value="View Saved Questions" />
</form>

<p style="display:inline; color: #00FF00" name="isMarkedText" id="isMarkedText">${markText}</p>
<p style="display:inline; color: #00FF00" name="isFlaggedText" id="isFlaggedText">${flagText}</p>
<p name="questionText" id="questionText">${questionText}</p>

<form style="display: inline" action="/markQuestion" method="post">
    <input type="submit" id="markBtn" value="Mark Question" ${questionText.length() > 0 ? '' : 'hidden'}/>
</form>

<form style="display: inline" action="/flagQuestion" method="post">
    <input type="submit" id="flagBtn" value="Flag Question" ${questionText.length() > 0 ? '' : 'hidden'}/>
</form>

<form style="display: inline" action="/deleteQuestion" method="post">
    <input type="submit" id="deleteBtn" value="Delete Question" ${questionText.length() > 0 ? '' : 'hidden'}/>
</form>

<form style="display: inline" action="/storeQuestion" method="post">
    <input type="submit" id="storeBtn" value="Store Question" ${questionText.length() > 0 ? '' : 'hidden'}/>
</form>

</body>
</html>