<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <div class="jumbotron">
            <h1>Welcome to Booking Manager</h1>
            <p>
              <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/hotels" role="button">Go to list of hotels</a>
            </p>
        </div>
    </jsp:attribute>
</tags:layout>
