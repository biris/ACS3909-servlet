<%--
  Created by IntelliJ IDEA.
  User: owner_
  Date: 2016-02-04
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%-- TODO: add some kind of logic to show cheked and unchecked --%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select View</title>
</head>
<body>

<%@ page import="project.Student" %>
<%@ page import="project.State" %>

<fieldset class="wrapper">

    <%--<jsp:useBean id="bean" type="project.State" scope="request"/>--%>

        <legend>Hello Student <strong><%= ((State) request.getAttribute("state")).getName()%></strong></legend>
        <%--<legend>Hello Student <jsp:getProperty name="bean" property="name"/></legend>--%>
    <form action="Controller" method="post">
        <%!
            String isChecked(State state, Student std) {
             return state.getSelctedStudents().contains(std.getStudentID()) ? "checked" : "";

            }
        %>
            <p> <%=((State)request.getAttribute("state")).getStudentID()%></p>
        <%

        State state = (State) request.getAttribute("state");

        for (Student student: state.getFilteredStudents()) {

        %>
    <div class="line" draggable="true">
        <input type="checkbox" name="selected" id="A2" value=<%= student.getStudentID()%>  <%= isChecked(state, student)%> />
        <label for="A2"><%= student.getStudentID()%> <%= student.getName()%>  </label>
    </div>

        <%

        }
    %>
        <input type="submit" name="submit" value="submit" />
    </form>
</fieldset>

<style>
    .wrapper {
        background-color: #cccccc;
        width: 500px;
        flex-direction: column;
        flex-wrap: wrap;
        justify-content: center;
        align-content: center;
        margin: 0 auto;
    }
    [draggable] {
        user-select: none;
    }

    .line {
        height: 25px;
        width: 200px;
        border: 2px solid #666666;
        background-color: gainsboro;
        margin: 2px;
        padding: 1px;
        border-radius: 10px;
        box-shadow: inset 0 0 3px #000;
        text-align: left;
        cursor: move;
    }

    .line.over {
        border: 2px dashed #000;
    }

</style>

<script>
    function handleDragStart(e) {
        this.style.opacity = '0.4';  // this / e.target is the source node.
    }

    function handleDragOver(e) {
        if (e.preventDefault) {
            e.preventDefault(); // Necessary. Allows us to drop.
        }

        e.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.

        return false;
    }

    var dragSrcEl = null;

    function handleDragStart(e) {
        // Target (this) element is the source node.
        this.style.opacity = '0.4';

        dragSrcEl = this;

        e.dataTransfer.effectAllowed = 'move';
        e.dataTransfer.setData('text/html', this.innerHTML);
    }

    function handleDragEnter(e) {
        // this / e.target is the current hover target.
        this.classList.add('over');
    }
    function handleDragLeave(e) {
        this.classList.remove('over');  // this / e.target is previous target element.
    }

    function handleDrop(e) {

        if (e.stopPropagation) {
            e.stopPropagation(); // Stops some browsers from redirecting.
        }

        // Don't do anything if dropping the same column we're dragging.
        if (dragSrcEl != this) {
            // Set the source column's HTML to the HTML of the column we dropped on.
            dragSrcEl.innerHTML = this.innerHTML;
            this.innerHTML = e.dataTransfer.getData('text/html');
        }
        return false;
    }

        function handleDragEnd(e) {
            // this/e.target is the source node.
            this.style.opacity = '1';
            [].forEach.call(lines, function (line) {
                line.classList.remove('over');
            });
        }


    var lines = document.querySelectorAll('.line');
    [].forEach.call(lines, function(line) {
        line.addEventListener('dragstart', handleDragStart, false);
        line.addEventListener('dragenter', handleDragEnter, false);
        line.addEventListener('dragover', handleDragOver, false);
        line.addEventListener('dragleave', handleDragLeave, false);
        line.addEventListener('drop', handleDrop, false);
        line.addEventListener('dragend', handleDragEnd, false);
    });

</script>



    <jsp:include page="whoSelcted.jsp" />

</body>
</html>
