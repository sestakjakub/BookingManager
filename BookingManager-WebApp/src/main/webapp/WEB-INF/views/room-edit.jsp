<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <form:errors path="*" cssClass="alert alert-danger"/>
        <form:form modelAttribute="roomForm" commandName = "roomForm">
            <form:hidden path="id"/>
            <form:hidden path="hotelId"/>
            <form:label path="number"><fmt:message key="room.form.number"/></form:label>
            <form:input path="number" class="form-control"/>
            <form:label path="capacity"><fmt:message key="room.form.capacity"/></form:label>
            <form:input path="capacity" class="form-control"/>
            <form:label path="price"><fmt:message key="room.form.price"/></form:label>
            <form:input path="price" class="form-control"/>
            <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/room/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>">
            <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/rooms/${hotelId}" class="btn btn-default" value="<fmt:message key="button.cancel"/>">
        </form:form>
    </jsp:attribute>
</tags:layout>