<html>

<head>
    <title>SE754 SpringBoot + JSP DEMO</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Online classroom</h1>
    <h2>Insert username and password</h2>
    <form method="post">
        Name : <input type="text" name="name" id="name" />
        Password : <input type="password" name="password" id="password"/>
        <input type="submit" id="loginbtn" value="Login" />
    </form>
    <button>Sign in with SSO</button>

</body>

</html>