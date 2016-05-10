<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Statistic File</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <h1>Statistic File</h1>
    <table border= "0" cellpadding="10"  align="center">
    <tr>
        <td>
         <table border= "0" cellpadding="10" bgcolor="#ffcc00" align="left"
           width="200px" height="150px">
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
                <%--<td>${statFile.kolrow}</td>--%>

            </tr>
        </c:forEach>
    </table>
        </td>

        <td valign="top">
            <form name="statFileCondition" method="get" action="statFileCondition.jsp">
                <p>Поиск статистики по параметрам:<br>
                    <input type="number" name="rowsNumber" min = "0" size="40">
                </p>
            </form>
            <hr>
            <hr>

            <form name="addFile" method="post" action="statFileCondition.jsp">
                <p>Введите название файла
                    <br/>
                    <input text name="fileName" size="40"></p>
                <br/>Введите текст
                <br/>
                <textarea name="text" cols="40" rows="3"></textarea>
                <br/>
                <br/><input type="submit" value="Обработать">
                <%--<p>Ввести текст для обработки:<br>--%>
                    <%--<input textarea name="comment" cols="70" rows="10"></textarea></p>--%>
                <%--<p><input type="submit" value="Отправить">--%>
            </form>

        </td>
    </tr>
     <tr>
            <td>

            </td>
     </tr>

    </table>

</div>
</body>
</html>