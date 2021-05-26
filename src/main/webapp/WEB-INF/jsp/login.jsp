<html>

<head>
    <title>Online Lecture System</title>
</head>

<body>
    <p style="color: #ff0000" id="error-message">${errorMessage}</p>
    <h1>Online University of Auckland Lecture System</h1>
    <p>Insert username and password</p>
    <form method="post">
        Username/Email : <input type="text" name="username" id="username" />
        Password : <input type="password" name="password" id="password"/>
        <input type="submit" id="loginbtn" value="Login" />
    </form>
    <form action="/sso" method="post">
        <button id="ssobtn">Sign in with SSO</button>
    </form>

</body>

</html>