<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <%--<script src="/assets/" type="text/javascript"></script>--%>
    <link href="<c:url value="/assets/sb_admin_2/bower_components/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/bower_components/metisMenu/dist/metisMenu.min.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/dist/css/sb-admin-2.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Default tiles template</title>
</head>

<body>
<div class="container">
    <tiles:insertAttribute name="body" />
</div>
</body>

</html>