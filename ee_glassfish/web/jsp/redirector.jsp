<%--
  Created by IntelliJ IDEA.
  User: Эм
  Date: 11.06.2016
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search engine chooser</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/redir">
    <label>
        <input type="radio" name="url" value="http://www.google.com">
        Google
    </label><br>
    <label>
        <input type="radio" name="url" value="http://www.msn.com">
        Msn
    </label><br>
    <label>
        <input type="radio" name="url" value="http://www.yahoo.com">
        Yahoo!
    </label><br>
    <input type="submit" value="Выбрать">
</form>
</body>
</html>
