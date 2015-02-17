<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">

<c:if test="${not empty message}">
    <div class="row">
        <div class="col-lg-12">
            <div class="alert alert-success">
                    ${message}
            </div>
        </div>
    </div>
</c:if>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"><spring:message code="listDoctors"/></h1>
    </div>
</div>

<div class = "row">
    <div class="col-lg-12">
        <a class="btn btn-default" href="<c:url value='/doctor/add' />" ><spring:message code="addDoctor"/></a>
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
                            <th width="120"><spring:message code="name"/></th>
                            <th width="120"><spring:message code="surname"/></th>
                            <th width="120"><spring:message code="email"/></th>
                            <th width="120"><spring:message code="created"/></th>
                            <th width="120"><spring:message code="updated"/></th>
                            <th width="60"><spring:message code="edit"/></th>
                            <th width="60"><spring:message code="delete"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listDoctors}" var="doctor">
                        <tr>
                            <td>${doctor.id}</td>
                            <td><a href="<c:url value='/doctor/${doctor.id}/show' />" >${doctor.profile.name}</a></td>
                            <td>${doctor.profile.surname}</td>
                            <td>${doctor.profile.email}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                                                value="${doctor.profile.created_at}" /></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd H:m"
                                                value="${doctor.profile.updated_at}" /></td>
                            <td><a href="<c:url value='/doctor/${doctor.id}/edit' />" ><spring:message code="edit"/></a></td>
                            <td><a href="<c:url value='/doctor/${doctor.id}/remove' />" ><spring:message code="delete"/></a></td>
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