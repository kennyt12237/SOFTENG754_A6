<html>

<head>
    <title>SE754 SpringBoot + JSP DEMO</title>
</head>

<body>
<label id="message">Welcome ${name}! </label>
<p id="sso-welcome-text">Thank you for signing in through SSO</p>
<form action="/sso" method="get">
    <button id="redirect-button">Click here to be redirected to the lecture page</button>
</form>

</body>

</html>