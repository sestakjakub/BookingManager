<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub, Jiří Kareš
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout title="test">
    <jsp:attribute name="body">        
        <form:errors path="*" cssClass="alert alert-danger"/>
        <form:form modelAttribute="hotel" commandName = "hotel">
            <form:hidden path="id"/>
            <form:label path="name"><fmt:message key="hotel.list.name"/></form:label>
            <form:input path="name" class="form-control"/>
            <form:label path="address"><fmt:message key="hotel.list.address"/></form:label>
            <form:input path="address" class="form-control"/>
            <%--<form:errors path="address" cssClass="alert alert-danger"/>--%>
            <form:label path="phoneNumber"><fmt:message key="hotel.list.phone"/></form:label>
            <form:input path="phoneNumber" class="form-control"/>
            <%--<form:errors path="phoneNumber" cssClass="alert alert-danger"/>--%>
            <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/hotel/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>"/>
            <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/hotels" class="btn btn-default" value="<fmt:message key="button.cancel"/>"/>
        </form:form>
    </jsp:attribute>
</tags:layout>