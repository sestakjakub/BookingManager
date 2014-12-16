<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <div class="jumbotron">
            <h1><fmt:message key="index.welcome"/></h1>
            <p>
              <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/hotels" role="button"><fmt:message key="index.goto"/></a>
            </p>
        </div>
    </jsp:attribute>
</tags:layout>
