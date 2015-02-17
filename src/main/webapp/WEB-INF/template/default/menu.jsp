<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a class="navbar-brand" href="<c:url value='/' />">Home</a>
    </div>

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li>
                    <a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="<c:url value="/logout"/> "><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
        </li>
    </ul>

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav in" id="side-menu">
                <li>
                    <a href="<c:url value='/' />" ><spring:message code="indexPage"/></a>
                </li>
                <li>
                    <a href="<c:url value='/doctors' />" ><spring:message code="doctors"/></a>
                </li>
                <li>
                    <a href="<c:url value='/patients' />" ><spring:message code="patients"/></a>
                </li>
                <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>--%>
                    <%--<ul class="nav nav-second-level collapse">--%>
                        <%--<li>--%>
                            <%--<a href="flot.html">Flot Charts</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="morris.html">Morris.js Charts</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<!-- /.nav-second-level -->--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="tables.html" class="active"><i class="fa fa-table fa-fw"></i> Tables</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>--%>
                    <%--<ul class="nav nav-second-level collapse">--%>
                        <%--<li>--%>
                            <%--<a href="panels-wells.html">Panels and Wells</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="buttons.html">Buttons</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="notifications.html">Notifications</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="typography.html">Typography</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="icons.html"> Icons</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="grid.html">Grid</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<!-- /.nav-second-level -->--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>--%>
                    <%--<ul class="nav nav-second-level collapse">--%>
                        <%--<li>--%>
                            <%--<a href="#">Second Level Item</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">Second Level Item</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">Third Level <span class="fa arrow"></span></a>--%>
                            <%--<ul class="nav nav-third-level collapse">--%>
                                <%--<li>--%>
                                    <%--<a href="#">Third Level Item</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">Third Level Item</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">Third Level Item</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">Third Level Item</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                            <%--<!-- /.nav-third-level -->--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<!-- /.nav-second-level -->--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>--%>
                    <%--<ul class="nav nav-second-level collapse">--%>
                        <%--<li>--%>
                            <%--<a href="blank.html">Blank Page</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="login.html">Login Page</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<!-- /.nav-second-level -->--%>
                <%--</li>--%>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
</nav>
