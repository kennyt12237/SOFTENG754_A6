<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Room</title>
<link href="css/mainroom.css" rel="stylesheet" type="text/css">
<script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>
</head>

<body>
<div id="mainwrapper">

  <div id="content">

    <section id="mainContent">
        <div id="bannerImage"><img src="images/AA.JPG" alt=""/></div>
    </section>

    <section id="sidebar">
        Main Room Users:
        <ul>
            <c:forEach items="${students}" var="student">
                <li>${student.userName}</li>
            </c:forEach>
        </ul>
    </section>


<c:choose>
    <c:when test="${idnum==null}">

                <c:if test="${lblEnabled}">

                    <c:forEach items="${breakoutRooms}" var="breakoutRoom">
                    <section class="breakoutroom">
                        <p>Breakout Room :
                           <a class="joinbtn" href="student-room?id=${breakoutRoom.id}&user=${username}" title="Link"> Join:</a>
                        </p>
                        <p class="topic">
                           ${breakoutRoom.topicName}
                         </p>

                    </section>
                    </c:forEach>
                </c:if>

    </c:when>
    <c:otherwise>

                    <c:if test="${lblEnabled}">

                        <c:forEach items="${breakoutRooms}" var="breakoutRoom">
                        <c:if test="${idnum==breakoutRoom.id}">
                        <section class="breakoutroom">
                            <p>Breakout Room :

                                <form action="/student-room" method="post">

                                <input type="hidden" id="usernameid" name="usernameid" value="${username}">
                                        <input type="hidden" id="roomid" name="roomid" value="${breakoutRoom.id}">
                                        <input type="submit" id="finishbtn" name="finishbtn" value="Finish" />
                                    </form>
                            </p>
                            <p class="topic">
                               ${breakoutRoom.topicName}
                             </p>
                            <ul>
                             <c:forEach items="${breakoutRoom.userSubGroup}" var="stud">
                                <li >${stud.userName}</li>
                             </c:forEach>
                            </ul>
                        </section>
                        </c:if>
                        </c:forEach>
                    </c:if>


    </c:otherwise>
</c:choose>


  </div>

</div>
</body>
</html>
