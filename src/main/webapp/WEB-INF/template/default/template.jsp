<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link href="<c:url value="/assets/sb_admin_2/bower_components/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/bower_components/metisMenu/dist/metisMenu.min.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/dist/css/timeline.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/dist/css/sb-admin-2.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/bower_components/morrisjs/morris.css" />" rel="stylesheet">
    <link href="<c:url value="/assets/sb_admin_2/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">

    <script src=<c:url value="/assets/sb_admin_2/bower_components/jquery/dist/jquery.min.js"/> type="text/javascript"></script>
    <script src=<c:url value="/assets/sb_admin_2/bower_components/bootstrap/dist/js/bootstrap.min.js"/> type="text/javascript"></script>
    <script src=<c:url value="/assets/sb_admin_2/dist/js/sb-admin-2.js"/> type="text/javascript"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Default tiles template</title>
</head>

<body>
    <div id="wrapper">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <div class="content">
            <div id="page-wrapper" style="min-height: 627px;">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
      <tiles:insertAttribute name="footer" />
    </div>
</body>

</html>
