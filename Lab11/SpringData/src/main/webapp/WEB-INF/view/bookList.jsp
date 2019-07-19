<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h3>Library</h3>
    <p>Console : ${message}</p>
    <table>
        <tr>
            <td>Title</td>
            <td>ISBN</td>
            <td>Author</td>
            <td>Price</td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
    <form:form method="get" action="add">
        <input type="submit" value="Back">
    </form:form>
</body>
</html>