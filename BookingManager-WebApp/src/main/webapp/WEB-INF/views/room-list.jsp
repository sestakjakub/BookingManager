<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1>Name of hotel</h1>
        <h3>List of rooms:</h3>
        <div class="btn-group" role="group">
            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/room/add/${hotel.getId()}">Add room</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Room number</th>
                    <th>Capacity</th>
                    <th>Price per night</th>
                    <th>Bookings</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${rooms}" var="room">
                    <tr>
                        <td>${room.getRoomNumber()}</td>
                        <td>${room.getCapacity()}</td>
                        <td>${room.getPrice()}</td>
                        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/room-booking/${room.getId()}">Show bookings</a></td>
                        <td><a class="btn btn-default" href="${pageContext.request.contextPath}/room/edit/${room.getId()}">Edit room</a></td>
                        <td><a class="btn btn-danger">Delete room</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </jsp:attribute>
</tags:layout>