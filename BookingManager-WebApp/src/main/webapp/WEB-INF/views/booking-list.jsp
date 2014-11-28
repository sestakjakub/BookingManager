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
        <h2><fmt:message key="hotel.list.name"/>: Hotel1</h2>
        <h3><fmt:message key="room.list.number"/>: 101</h3>
        <div class="btn-group" role="group">
            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/room-booking/add/${room.getId()}"><fmt:message key="booking.button.add"/></a>
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
                <c:forEach items="${bookings}" var="booking">
                    <tr>
                        <td>${booking.getDateFrom()}</td>
                        <td>${booking.getDateTo()}</td>
                        <td>${booking.getCustomer()}</td>
                        <td><a class="btn btn-default" href="${pageContext.request.contextPath}/room-booking/edit/${booking.getId()}">Edit booking</a></td>
                        <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/room-booking/delete/${booking.getId()}">Delete booking</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</tags:layout>