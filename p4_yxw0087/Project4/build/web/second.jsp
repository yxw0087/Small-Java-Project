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
<jsp:useBean id="choice" scope="session" class="socketmckoidb.myDB"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Result</title>
    </head>
    <body>
        <%@ page import="socketmckoidb.myDB" %>
        <%myDB db = new myDB();
        if(db.connection != null){
        String r = request.getParameter("response");
        if(r.equals("1")) {
            String[] temp = new String[20];
            temp = db.showStudents();
            for(int i=0; temp[i] != null; i++){
            out.print(temp[i] + "<br>");
            }
        } else if(r.equals("2")) {
            String[] temp = new String[20];
            temp = db.showCourses();
            for(int i=0; temp[i] != null; i++){
            out.print(temp[i] + "<br>");
            }      
        } else if(r.equals("3")) {
            String[] temp = new String[20];
            temp = db.showMajors();
            for(int i=0; temp[i] != null; i++){
            out.print(temp[i] + "<br>");
            }        
        } else if(r.equals("4")) {%>
            <form action="showmajorstudent.jsp" method="post">
                <div>Enter a major id: <input type="text" name="id" size="20"/></div>                      
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("5")) {%>
            <form action="showcoursestudent.jsp" method="post">
                <div>Enter a course id: <input type="text" name="id" size="20"/></div>                      
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("6")) {%>
            <form action="showschedule.jsp" method="post">
                <div>Enter a student id: <input type="text" name="id" size="20"/></div>                      
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("7")) {%>
            <form action="showstudentinfo.jsp" method="post">
                <div>Enter a student id: <input type="text" name="id" size="20"/></div>                      
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("8")) {%>
            <form action="addstudent.jsp" method="post">
                <div>Enter a student id: <input type="text" name="id" size="20"/></div>
                <div>Enter a student name: <input type="text" name="name" size="20"/></div>
                <div>Enter a major id for this student: <input type="text" name="majorid" size="20"/></div>                
                <div>Enter a street name for the address of this student: <input type="text" name="street" size="20"/></div>
                <div>Enter a city name for the address of this student: <input type="text" name="city" size="20"/></div>
                <div>Enter a state name for the address of this student: <input type="text" name="state" size="20"/></div>
                <div>Enter a zip for the address of this student: <input type="text" name="zip" size="20"/></div>
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("9")) {%>
            <form action="addcourse.jsp" method="post">
                <div>Enter a course id: <input type="text" name="id" size="20"/></div>
                <div>Enter a course description: <input type="text" name="course" size="20"/></div>       
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("10")) {%>
            <form action="addmajor.jsp" method="post">
                <div>Enter a major id: <input type="text" name="id" size="20"/></div>
                <div>Enter a major description: <input type="text" name="course" size="20"/></div>       
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("11")) {%>
            <form action="enroll.jsp" method="post">
                <div>Enter a student id: <input type="text" name="id" size="20"/></div>
                <div>Enter a course id to enroll: <input type="text" name="course" size="20"/></div>       
                <input type="submit" value="Submit"/>
            </form>
        <% } else if(r.equals("0")) {%>
            <form action="index.html" method="post">
                <input type="submit" value="Exit"/>
            </form>
        <% } else {%>
            <form action="index.html" method="post">
                <div>Invalid Response.</div>
                <input type="submit" value="Back"/>
            </form>
        <%}
        } else {%>
            No connection established.
        <%}%>
        
    </body>
</html>
