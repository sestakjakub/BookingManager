<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1>Name of hotel</h1>
        <h3><fmt:message key="room.list.list"/></h3>
        <div class="btn-group" role="group">
            <form>
                <input type="hidden" name="hotelId" value="${hotel.getId()}">
                <input type="hidden" name="roomId" value="0">
                <input formmethod="get" type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/room/edit" value="<fmt:message key="room.button.add"/>">
            </form>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="room.list.number"/></th>
                    <th><fmt:message key="room.list.capacity"/></th>
                    <th><fmt:message key="room.list.price"/></th>
                    <th><fmt:message key="room.list.bookings"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hotel.getRooms()}" var="room">
                <form>
                    <tr>
                        <td align="left">${room.getRoomNumber()}</td>
                        <td align="left">${room.getCapacity()}</td>
                        <td align="left">${room.getPrice()}</td>
                        <td align="right">
                            <input type="hidden" name="hotelId" value="${hotel.getId()}">
                            <input type="hidden" name="roomId" value="${room.getId()}">
                            <input formmethod="get" formaction="${pageContext.request.contextPath}/room-booking/${room.getId()}" class="btn btn-default" type="submit" value="<fmt:message key="room.button.bookings"/>">
                            <input formmethod="get" formaction="${pageContext.request.contextPath}/room/edit/${room.getId()}" class="btn btn-default" type="submit" value="<fmt:message key="button.edit"/>">
                            <input formmethod="post" formaction="${pageContext.request.contextPath}/room/delete/${room.getId()}" class="btn btn-danger" type="submit" value="<fmt:message key="button.delete"/>">
                        </td>
                </form>
            </tr>
        </c:forEach>
    </tbody>
</table>

</jsp:attribute>
</tags:layout>