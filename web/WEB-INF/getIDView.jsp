<%--
  Created by IntelliJ IDEA.
  User: owner_
  Date: 2016-02-21
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    if ((Boolean) request.getAttribute("isNewUser?")) {

%>
    <h3>Welcome new User!</h3>
<%
}
%>

<form action="Controller" method="post">
    <label for="studentID">Your ID: </label>
    <input type="text" name="studentID" id="studentID" value="3040500">
    <input type="submit" value="go!">
</form>

</body>
</html>
