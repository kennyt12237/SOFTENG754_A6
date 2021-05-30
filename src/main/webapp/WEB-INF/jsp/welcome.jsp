<html>

<head>
<title>SE754 SpringBoot + JSP DEMO</title>
</head>

<body>
<label id="message">Welcome ${name}! </label>

<p style="color: #ff0000" id="error-message">${errorMessage}</p>

<div id="lectures">
    <div id="SOFTENG754">
        <label id="softeng-754">SOFTENG 754</label>
        <form action="/lecture" method="post">
            Authenticated? : <input type="checkbox" name="authenticated" id="authenticated"/>
            Enrolled? : <input type="checkbox" name="enrolled" id="enrolled"/>
            <button id="join-lecture-button">Join Lecture!</button>
        </form>

        <form action="/lecturerScreen" method="get">
            <input type="submit" value="I am lecturer" id="lecturerBtn"/>
        </form>
    </div>
</div>
</body>

</html>