<%-- 
  Author: Yee H. Wong
  CLID: yxw0087
  Class: CMPS 360
  Project: 4
  Due Date: 12/6/14
  Description: User interface for the database server.
--%>

<%-- 
     To delete all tables, recreate all tables and populate all tables 
     with testing data, run MakeDB.java

     To create a database in Linux/OSX: run Project4/socketdb/linuxcreate
     To create a database in Windows: run Project4\socketdb\windowscreate.bat
     To start the socket server in Linux/OSX: run Project4/socketdb/linuxstart
     To start the socket server in Windows: run Project4\socketdb\windowstart.bat
     To stop the socket server in Linux/OSX: CTRL C
     To stop the socket server in Windows: close the window
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="password" scope="session" class="socketmckoidb.myDB"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Interface</title>
    </head>
    <body>
        <% if(password.checkPass(request.getParameter("password"))) {%>
            <form action="second.jsp" method="post">
                <div>To list all student ids and student names, enter 1.</div>
                <div>To list all courses, enter 2.</div>
                <div>To list all majors, enter 3.</div>
                <div>To list all students in a particular major, enter 4.</div>
                <div>To list all students in a particular course, enter 5.</div>
                <div>To list the schedule of a particular student, enter 6.</div>
                <div>To list the name, address and major of a particular student, enter 7.</div>
                <div>To add a new student to database, enter 8.</div>
                <div>To add a new course to database, enter 9.</div>
                <div>To add a new major to database, enter 10.</div>
                <div>To enroll a new student to a course in the database, enter 11.</div>
                <div>To exit, enter 0.</div>
                <input type="text" name="response" size="20"/>
                <input type="submit" value="Submit"/>
            </form>
        <% } else {%>
            <form action="index.html" method="post">
                <div>Wrong password.</div>
                <input type="submit" value="Back"/>
            </form>
        <% }%>
    </body>
</html>
