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
    <h1>Statistic File</h1>

   <table border= "1" cellpadding="10" bgcolor="#ffcc00" align="center"
                       width="200px" height="150px">
            <th>ID</th>
            <th>Name</th>
            <th>MAX</th>
            <th>MIN</th>
            <th>AVER</th>
            <th>LENGHT</th>

            <c:forEach var="statFileCondition" items="${listFileCondition}" varStatus="status">
                <tr>
                    <td>${statFileCondition.id}</td>
                    <td>${statFileCondition.name}</td>
                    <td>${statFileCondition.maxf}</td>
                    <td>${statFileCondition.minf}</td>
                    <td>${statFileCondition.averf}</td>
                    <td>${statFileCondition.lenghtfile}</td>

                </tr>
            </c:forEach>



    </table>

</div>
</body>
</html>