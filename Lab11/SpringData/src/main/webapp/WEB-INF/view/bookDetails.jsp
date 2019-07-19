<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
        <h3>Book Detail</h3>
        <table>
            <tr><td>Title: ${book.title}</td></tr>
            <tr><td>ISBN: ${book.isbn}</td></tr>
            <tr><td>Author: ${book.author}</td></tr>
            <tr><td>Price: ${book.price}</td></tr>
        </table>
        <form:form method="get" action="add">
            <input type="submit" value="Back">
        </form:form>
</body>
</html>