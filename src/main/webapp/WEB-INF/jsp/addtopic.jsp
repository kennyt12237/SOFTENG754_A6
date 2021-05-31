<html>
<head>
    <title>Add topic</title>
</head>

<body>
    <p>Enter Topic Name</p>

    <form action="/addtopic" method="post">
         <input type="text" name="topicname" id="topicname" />
        <input type="hidden" id="roomid" name="roomid" value="${idnum}">
        <input type="submit" id="addtopicbtn" value="Add" />
    </form>

</body>

</html>