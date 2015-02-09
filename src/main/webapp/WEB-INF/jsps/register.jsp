<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="nonSecuredTemplate">
<tiles:putAttribute name="body">

    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Registration Form</h3>
                </div>
                <div class="panel-body">
                    <form:form action="/register" commandName="user" role="form">
                        <fieldset>
                            <div class="form-group">
                                <form:label path="email">Email</form:label>
                                <form:input cssClass="form-control" path="email" />
                                <form:errors path="email" cssClass="text-danger" />
                            </div>

                            <div class="form-group">
                                <form:label path="password">Password</form:label>
                                <form:password cssClass="form-control" path="password" />
                                <form:errors path="password" cssClass="text-danger" />
                            </div>

                            <div class="form-group">
                                <form:label path="password_again">Password again</form:label>
                                <form:password cssClass="form-control" path="password_again" />
                                <form:errors cssClass="text-danger" />
                            </div>

                            <input type="submit" value="Register me!" class="btn btn-lg btn-success btn-block" />
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</tiles:putAttribute>
</tiles:insertDefinition>