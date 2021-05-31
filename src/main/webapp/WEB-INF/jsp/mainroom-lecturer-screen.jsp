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
      <p>  Breakout Room Settings : </p>
      <p></p>
    <form action="/mainroom-lecturer-screen" method="post">
        <input type="submit" id="addbtn" value="Add" />
    </form>

    <form action="/mainroom-lecturer-screen" method="get">
        <input type="submit" id="enablebtn" name="enablebk" value="Enable" />
        <input type="submit" id="disablebtn" name="disablebk" value="Disable" />
        <input type="submit" id="importcanvas" name="importcanvas" value="Import" />
        <input type="submit" id="reset" name="reset" value="Reset" />
    </form>

    <section id="sidebar">
        Main Room Users:
        <ul>
            <c:forEach items="${students}" var="student">
                <li>${student.userName}</li>
            </c:forEach>
        </ul>
    </section>

    <p id="breakoutstatus">${lblEnabled}</p>


    <c:forEach items="${breakoutRooms}" var="breakoutRoom">
    <section class="breakoutroom">
        <p>Breakout Room :
           <a class="topicbtn" href="addtopic?id=${breakoutRoom.id}" title="Link"> Topic:</a>
        </p>
        <p class="topic">
           ${breakoutRoom.topicName}
         </p>
          <c:if test="${breakoutRoom.activityStatus}">
                <a class="finishedbtn" href="mainroom-lecturer-screen?id=${breakoutRoom.id}" title="Link"> Finished:</a>
          </c:if>
          <c:if test="${breakoutRoom.inviteStatus}">
                  <a class="invitebtn" href="mainroom-lecturer-screen?joinid=${breakoutRoom.id}" title="Link"> join:</a>
          </c:if>
        <ul>
         <c:forEach items="${breakoutRoom.userSubGroup}" var="stud">
            <li class="mbkstudent">${stud.userName}</li>
         </c:forEach>
        </ul>
    </section>
    </c:forEach>

  </div>

</div>
</body>
</html>
