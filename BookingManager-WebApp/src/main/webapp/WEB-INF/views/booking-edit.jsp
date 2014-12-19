<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub, Jiří Kareš
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:layout title="test">
    <jsp:attribute name="body">
        <form>
            <input type="hidden" name="bookingId" value="${bookingId}">
            <input type="hidden" name="roomId" value="${roomId}">
            <label for="customerId"><fmt:message key="booking.form.customer"/></label>
            <input name="customerId" class="form-control">
            <label for="dateFrom"><fmt:message key="booking.form.from"/></label>
            <input name="dateFrom" class="form-control">
            <label for="dateTo"><fmt:message key="booking.form.to"/></label>
            <input name="dateTo" class="form-control">
            <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/booking/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>">
            <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/bookings/${roomId}" class="btn btn-default" value="<fmt:message key="button.cancel"/>">
        </form>
    </jsp:attribute>
</tags:layout>