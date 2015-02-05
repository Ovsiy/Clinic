<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title></title>
</head>
<body>

<table class="tg">
  <tr>
    <tr>
      <td>${doctor.id}</td>
      <td>${doctor.name}</td>
      <td>${doctor.surname}</td>
      <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                          value="${doctor.created_at}" /></td>
      <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                          value="${doctor.updated_at}" /></td>
    </tr>
</table>

</body>
</html>
