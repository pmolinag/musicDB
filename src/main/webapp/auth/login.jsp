<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form:form method="post"
           action="${pageContext.request.contextPath}/auth/login-post" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Log in"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>