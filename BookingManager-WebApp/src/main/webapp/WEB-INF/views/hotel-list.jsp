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
        <h1><fmt:message key="hotel.list.list"/></h1>
        <div class="btn-group" role="group">
            <form method="post" action="${pageContext.request.contextPath}/hotel/edit">
                <input class="btn btn-default" type="submit" value="<fmt:message key="hotel.button.add"/>">
            </form>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="hotel.list.name"/></th>
                    <th><fmt:message key="hotel.list.address"/></th>
                    <th><fmt:message key="hotel.list.phone"/></th>
                    <th><fmt:message key="hotel.list.rooms"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hotels}" var="hotel">
                    <tr>
                        <td>${hotel.getName()}</td>
                        <td>${hotel.getAddress()}</td>
                        <td>${hotel.getPhoneNumber()}</td>
                        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/rooms/${hotel.getId()}">Show rooms</a></td>
                        <td><a class="btn btn-default" href="${pageContext.request.contextPath}/hotel/edit/${hotel.getId()}">Edit hotel</a></td>
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/hotel/delete/${hotel.getId()}">
                                <input class="btn btn-danger" type="submit" value="Delete hotel">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</tags:layout>