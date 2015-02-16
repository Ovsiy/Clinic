<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>

<table class="tg">
  <tr>
    <tr>
      <td>${doctor.id}</td>
      <td>${doctor.profile.name}</td>
      <td>${doctor.profile.surname}</td>
      <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                          value="${doctor.profile.created_at}" /></td>
      <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                          value="${doctor.profile.updated_at}" /></td>
    </tr>

    <tr>Patients</tr>

    <tr>
        <c:forEach items="${doctor.patients}" var="patient">
            <td>
                ${patient.profile.name}
            </td>
            <td>
                    ${patient.profile.surname}
            </td>
        </c:forEach>
    </tr>
</table>

</body>
</html>
