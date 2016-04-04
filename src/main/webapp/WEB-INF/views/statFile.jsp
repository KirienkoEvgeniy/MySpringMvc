<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact Manager Home</title>
</head>
<body>
<div align="center">
    <h1>Statistic List</h1>
    <table border= "1" cellpadding="10" bgcolor="#ffcc00" align="center"
           width="150px" height="150px">
        <th>ID</th>
        <th>Name</th>
        <th>MAX</th>
        <th>MIN</th>
        <th>AVER</th>
        <th>LENGHT</th>

        <c:forEach var="statFile" items="${listFile}" varStatus="status">
            <tr>
                <td>${statFile.id}</td>
                <td>${statFile.name}</td>
                <td>${statFile.maxf}</td>
                <td>${statFile.minf}</td>
                <td>${statFile.averf}</td>
                <td>${statFile.lenghtfile}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>