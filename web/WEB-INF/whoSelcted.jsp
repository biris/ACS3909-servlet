<%@ page import="project.State" %>
<%@ page import="project.Student" %><%--
  Created by IntelliJ IDEA.
  User: owner_
  Date: 2016-02-28
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="wrapper2">
    <p>
        Who selected you is:
    </p>
<% for(Student std: ((State) request.getAttribute("state")).getWhoSelected()) {

%>
 <ul class=wrapper2">
        <li> <%= std.getName()%>, <%= std.getStudentID()%></li>
    </ul>

<%

}%>
</div>
<style>
    .wrapper2 {
        background-color: gray;
        width: 530px;
        margin: 0 auto;
    }

    li {
        list-style: square;
    }

</style>

