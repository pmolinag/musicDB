<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form th:action="@{/auth/signup}" th:object="${user}" method="post">
    <label><b>Name</b></label>
    <input type="text" th:field="*{nombre}"/>

    <label><b>Last name</b></label>
    <input type="text" th:field="*{apellido}"/>

    <label><b>Email</b></label>
    <input type="email" th:field="*{email}"/>

    <label><b>Username</b></label>
    <input type="text" th:field="*{username}"/>

    <label><b>Password</b></label>
    <input type="password" th:field="*{password}"/>

    <input type="submit" value="Sign up" />
</form>
</body>
</html>