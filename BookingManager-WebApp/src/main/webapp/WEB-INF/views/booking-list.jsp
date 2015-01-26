<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1><fmt:message key="booking.list.list"/></h1>
        <h2><fmt:message key="hotel.list.name"/>: ${room.getHotel().getName()}</h2>
        <h3><fmt:message key="room.list.number"/>: ${room.getRoomNumber()}</h3>
        <div class="btn-group" role="group">
            <form>
                <input type="hidden" name="roomId" value="${room.getId()}">
                <input type="hidden" name="bookingId" value="0">
                <input formmethod="get" type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/booking/edit" value="<fmt:message key="booking.button.create"/>">
            </form>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="booking.list.datefrom"/></th>
                    <th><fmt:message key="booking.list.dateto"/></th>
                    <th><fmt:message key="booking.list.customer"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${room.getBookings()}" var="booking">
                <form>
                    <tr>
                        <td>${booking.getStrDateFrom()}</td>
                        <td>${booking.getStrDateTo()}</td>
                        <td>${booking.getCustomer().getName()}</td>
                        <td>
                            <input type="hidden" name="roomId" value="${room.getId()}">
                            <input type="hidden" name="bookingId" value="${booking.getId()}">
                            <input formmethod="get" formaction="${pageContext.request.contextPath}/booking/edit" class="btn btn-default" type="submit" value="<fmt:message key="button.edit"/>">
                            <input formmethod="post" formaction="${pageContext.request.contextPath}/booking/delete/${booking.getId()}" class="btn btn-danger" type="submit" value="<fmt:message key="button.delete"/>">
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>
</jsp:attribute>
</tags:layout>