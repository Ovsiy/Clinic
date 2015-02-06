<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title></title>
</head>
<body>
<form:form action="/register" commandName="user">
    <table>
        <tr>
            <td>
                Email
            </td>
            <td>
                <form:input path="email" />
            </td>
            <td>
                <form:errors path="email" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>
                Password
            </td>
            <td>
                <form:input path="password" />
            </td>
            <td>
                <form:errors path="password" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>
                Pass again
            </td>
            <td>
                <form:input path="password_again" />
            </td>
            <td>
                <form:errors cssClass="error" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Register me!"/>" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
