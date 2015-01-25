<%-- 
    Document   : layout
    Created on : 28.11.2014
    Author     : Jiří Kareš
--%>

<!DOCTYPE html>
<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="${pageContext.request.locale}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title><fmt:message key="app.title"/></title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

        <!-- Custom styles for this template -->
        <link href="http://getbootstrap.com/examples/starter-template/starter-template.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/"><fmt:message key="app.title"/></a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
                            <li><a href="${pageContext.request.contextPath}/"><fmt:message key="menu.home"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/hotels"><fmt:message key="menu.hotels"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li><a href="${pageContext.request.contextPath}/customers"><fmt:message key="menu.customers"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
                        <li><a href="<c:url value="/j_spring_security_logout" />"><fmt:message key="menu.logout"/>(<sec:authentication property="principal.username"/>)</a></li>
                        </sec:authorize>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div id="content">
            <div class="container">
                <div class="starter-template">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success"><c:out value="${message}"/></div>
                    </c:if>
                    <jsp:invoke fragment="body"/>
                </div>
            </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>
