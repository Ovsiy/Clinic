<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
<div class = "row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Add Doctor
            </div>
            <div class="panel-body">
                <div class="row">
                    <form:form action="/doctor/add" commandName="doctor" role="form">
                        <div class="col-lg-6">
                            <c:if test="${!empty doctor.profile.name}">
                                <%--<form:label path="id">ID</form:label>--%>
                                <%--<form:input path="id" readonly="true" disabled="true"  />--%>
                                <form:hidden path="id" />
                                <form:hidden path="profile.id" />
                            </c:if>
                            <div class="form-group">
                                <c:set var="nameErrors"><form:errors path="profile.name"/></c:set>
                                <form:label path="profile.name">Name</form:label>
                                <form:input path="profile.name" cssClass="form-control" />
                            </div>

                            <div class="form-group">
                                <c:set var="surnameErrors"><form:errors path="profile.surname"/></c:set>
                                <form:label path="profile.surname">Surname</form:label>
                                <form:input path="profile.surname" cssClass="form-control" />
                            </div>

                            <div class="form-group">
                                <c:set var="phoneErrors"><form:errors path="profile.phone"/></c:set>
                                <form:label path="profile.phone">Phone</form:label>
                                <form:input path="profile.phone" cssClass="form-control" />
                            </div>

                            <div class="form-group">
                                <c:set var="emailErrors"><form:errors path="profile.email"/></c:set>
                                <form:label path="profile.email">Email</form:label>
                                <form:input path="profile.email" cssClass="form-control" />
                            </div>

                            <input type="submit" value="<spring:message text="Add Doctor"/>" />
                        </div>
                        <div class="col-lg-6">

                            <c:set var="errors"><form:errors path="*"/></c:set>
                            <c:if test="${not empty errors}">
                                <h1>Oops, we have some errors</h1>
                                <div class="alert alert-danger">
                                        ${errors}
                                </div>
                            </c:if>

                            <%--If we need to display each error--%>

                            <%--<c:if test="${not empty nameErrors}">--%>
                                <%--<div class="alert alert-danger">--%>
                                <%--${nameErrors}--%>
                                <%--</div>--%>
                            <%--</c:if>--%>

                            <%--<c:if test="${not empty surnameErrors}">--%>
                                <%--<div class="alert alert-danger">--%>
                                    <%--${surnameErrors}--%>
                                <%--</div>--%>
                            <%--</c:if>--%>

                            <%--<c:if test="${not empty phoneErrors}">--%>
                                <%--<div class="alert alert-danger">--%>
                                    <%--${phoneErrors}--%>
                                <%--</div>--%>
                            <%--</c:if>--%>

                            <%--<c:if test="${not empty emailErrors}">--%>
                                <%--<div class="alert alert-danger">--%>
                                    <%--${emailErrors}--%>
                                <%--</div>--%>
                            <%--</c:if>--%>
                        </div>
                </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

</tiles:putAttribute>
</tiles:insertDefinition>