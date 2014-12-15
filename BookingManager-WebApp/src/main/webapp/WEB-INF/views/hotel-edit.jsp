<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <form:form method="post" action="${pageContext.request.contextPath}/hotel/add" modelAttribute="hotel">
            <form:label path="name"><fmt:message key="hotel.list.name"/></form:label>
            <form:input path="name" class="form-control"/>
            <form:label path="address"><fmt:message key="hotel.list.address"/></form:label>
            <form:input path="address" class="form-control"/>
            <form:label path="phoneNumber"><fmt:message key="hotel.list.phone"/></form:label>
            <form:input path="phoneNumber" class="form-control"/>
            <button type="submit" class="btn btn-default"><fmt:message key="button.submit"/></button>
        </form:form>
    </jsp:attribute>
</tags:layout>