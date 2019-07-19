<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h3>Add Book</h3>
    <form:form modelAttribute="book" action="add" method="post">
        Title: <form:input path="title"></form:input><br/>
        ISBN: <form:input path="isbn"></form:input><br/>
        Author: <form:input path="author"></form:input><br/>
        Price: <form:input path="price"></form:input><br/>
        <br/>
        <input type="submit" name="Add Book" id="addBook">
    </form:form>
</body>
</html>