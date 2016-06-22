<%--
  Created by IntelliJ IDEA.
  User: Эм
  Date: 10.06.2016
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/FormHandler">
    <br>
    <label>Введите свой текст
        <input type="text" name="textInput"  required placeholder="Текст...">
    </label>
    <br>
    <label>
        <input type="checkbox" name="options" value="opt 1">
        Option 1
    </label>
    <br>
    <label>
        <input type="checkbox" name="options" value="opt 2">
        Option 2
    </label>
    <br>
    <label>
        <input type="checkbox" name="options" value="opt 3">
        Option 3
    </label>
    <br>
    <br>
    <input type="submit" value="Отправить">
</form>
</body>
</html>
