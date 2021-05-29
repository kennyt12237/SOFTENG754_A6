<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Lecturer Screen</title>
<link href="css/mainroom.css" rel="stylesheet" type="text/css">
<script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>
</head>

<body>
	<div id="mainwrapper">

	  <div id="content">

		<section id="mainContent">
			<div id="bannerImage"><img src="images/AA.JPG" alt=""/></div>
		</section>

		<form method="post">
			<input type="submit" id="addbtn" value="Add" />
		</form>

		<section id="sidebar">
			Main Room Users:
			<ul>
				<c:forEach items="${students}" var="student">
					<li>${student.userName}</li>
				</c:forEach>
			</ul>
		</section>


		<c:forEach items="${breakoutRooms}" var="breakoutRoom">
			<section class="breakoutroom">
				Bk Room - <a href="addtopic" title="Link">Topic:</a>
		  </section>
		</c:forEach>

		</div>

	</div>
</body>
</html>
