<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:layout title="test">
    <jsp:attribute name="body">
        <form>
            <input type="hidden" name="hotelId" value="${hotelId}">
            <input type="hidden" name="roomId" value="${roomId}">
            <label for="roomNumber"><fmt:message key="room.form.number"/></label>
            <input name="roomNumber" class="form-control">
            <label for="capacity"><fmt:message key="room.form.capacity"/></label>
            <input name="capacity" class="form-control">
            <label for="price"><fmt:message key="room.form.price"/></label>
            <input name="price" class="form-control">
            <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/room/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>">
            <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/rooms/${hotelId}" class="btn btn-default" value="<fmt:message key="button.cancel"/>">
        </form>
    </jsp:attribute>
</tags:layout>