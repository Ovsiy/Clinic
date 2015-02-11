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
                <h3 class="panel-title">Login Form</h3>
            </div>
            <div class="panel-body">
            <form action="j_spring_security_check" method="post" role = "form">
                <fieldset>
                    <div class="form-group">
                        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                    </div>
                    <div class="form-group">
                        <label for="j_username">Username</label>
                        <input id="j_username" name="j_username" type="text" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="j_password">Password</label>
                        <input id="j_password" name="j_password" type="password" class="form-control"/>
                    </div>

                    <input type="submit" value="Login" class="btn btn-lg btn-success btn-block" />
                </fieldset>
            </form>
        </div>
        </div>
    </div>


</div>

</tiles:putAttribute>
</tiles:insertDefinition>