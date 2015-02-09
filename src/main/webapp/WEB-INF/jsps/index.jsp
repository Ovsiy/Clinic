<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Doctors List</h1>
    </div>
</div>

<div class = "row">
    <div class="col-lg-12">
        <a class="btn btn-default" href="<c:url value='/doctor/add' />" >Add Doctor</a>
    </div>
    <c:if test="${!empty listDoctors}">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="dataTable_wrapper">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Name</th>
                            <th width="120">Surname</th>
                            <th width="120">Email</th>
                            <th width="120">Created</th>
                            <th width="120">Updated</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listDoctors}" var="doctor">
                        <tr>
                            <td>${doctor.id}</td>
                            <td><a href="<c:url value='/doctor/${doctor.id}/show' />" >${doctor.name}</a></td>
                            <td>${doctor.surname}</td>
                            <td>${doctor.email}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                                                value="${doctor.created_at}" /></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                                                value="${doctor.updated_at}" /></td>
                            <td><a href="<c:url value='/doctor/${doctor.id}/edit' />" >Edit</a></td>
                            <td><a href="<c:url value='/doctor/${doctor.id}/remove' />" >Delete</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </c:if>
</div>

</tiles:putAttribute>
</tiles:insertDefinition>