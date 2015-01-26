<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub, Jiří Kareš
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <div class="jumbotron">
            <form:errors path="*" cssClass="alert alert-danger"/>
            <form:form modelAttribute="bookingForm" commandName = "bookingForm">
                <form:hidden path="id"/>
                <form:hidden path="roomId"/>
                <form:hidden path="customerId"/>
                <div class="form-group">
                    <form:label path="dateFrom"><fmt:message key="booking.form.from"/></form:label>
                    <form:input path="dateFrom" type="date" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="dateTo"><fmt:message key="booking.form.to"/></form:label>
                    <form:input path="dateTo" type="date" class="form-control"/>
                </div>
                <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/booking/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>">
                <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/bookings/${roomId}" class="btn btn-default" value="<fmt:message key="button.cancel"/>">
            </form:form>
        </div>
    </jsp:attribute>
</tags:layout>