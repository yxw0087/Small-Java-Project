<%-- 
  Author: Yee H. Wong
  CLID: yxw0087
  Class: CMPS 360
  Project: 4
  Due Date: 12/6/14
  Description: User interface for the database server.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Students</title>
    </head>
    <body>
        <%@ page import="socketmckoidb.myDB" %>
        <% myDB db = new myDB();
        String[] temp = new String[20];
        temp = db.showCourseStudents(Integer.parseInt(request.getParameter("id")));
        for(int i=0; temp[i] != null; i++){
        out.print(temp[i] + "<br>");
        }%>
    </body>
</html>
