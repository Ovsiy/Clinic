<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<head>
    <title></title>
</head>
<body>
<h3>Doctors List</h3>
<a href="<c:url value='/doctor/add' />" >Add Doctor</a>
<c:if test="${!empty listDoctors}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Surname</th>
            <th width="120">Created</th>
            <th width="120">Updated</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDoctors}" var="doctor">
            <tr>
                <td><a href="<c:url value='/doctor/${doctor.id}/show' />" >${doctor.name}</a></td>
                <td>${doctor.name}</td>
                <td>${doctor.surname}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                                    value="${doctor.created_at}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                                    value="${doctor.updated_at}" /></td>
                <td><a href="<c:url value='/doctor/${doctor.id}/edit' />" >Edit</a></td>
                <td><a href="<c:url value='/doctor/${doctor.id}/remove' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>