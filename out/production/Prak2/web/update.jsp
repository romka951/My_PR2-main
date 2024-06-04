<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование</title>
</head>
<body>
<h3>Изменить книгу</h3>
<form method="post">
    <input type="hidden" value="${book.id}" name="id" />
    <label>Название</label><br>
    <input name="title" value="${book.title}" /><br><br>
    <label>Автор</label><br>
    <input name="author" value="${book.author}" /><br><br>
    <input type="submit" value="Изменить" />
</form>
</body>
</html>
