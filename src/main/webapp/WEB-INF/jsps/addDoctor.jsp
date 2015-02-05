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
    <form:form action="/doctor/add" commandName="doctor">
        <table>
            <c:if test="${!empty doctor.name}">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    <form:input path="id" readonly="true"/>
                </td>
            </tr>
            </c:if>
            <tr>
                <td>
                    Name
                </td>
                <td>
                    <form:input path="name" />
                </td>
                <td>
                    <form:errors path="name" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>
                    Surname
                </td>
                <td>
                    <form:input path="surname" />
                </td>
                <td>
                    <form:errors path="surname" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>
                    Phone
                </td>
                <td>
                    <form:input path="phone" />
                </td>
                <td>
                    <form:errors path="phone" cssClass="error" />
                </td>
            </tr>
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
                <td colspan="2">
                    <input type="submit"
                           value="<spring:message text="Add Doctor"/>" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
