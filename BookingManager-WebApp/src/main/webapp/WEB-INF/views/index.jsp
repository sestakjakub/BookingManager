<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <div class="jumbotron">
        <p><fmt:message key="index.welcome"/> <sec:authentication property="principal.username"/>!</p>
        </div>
    </jsp:attribute>
</tags:layout>
