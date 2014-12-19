<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1><fmt:message key="hotel.list.list"/></h1>
        <div class="btn-group" role="group">
            <form action="${pageContext.request.contextPath}/hotel/edit">
                <input formmethod="get" class="btn btn-primary" type="submit" value="<fmt:message key="hotel.button.create"/>">
            </form>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="hotel.list.name"/></th>
                    <th><fmt:message key="hotel.list.address"/></th>
                    <th><fmt:message key="hotel.list.phone"/></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hotels}" var="hotel">
                <form>
                    <tr>
                        <td align="left">${hotel.getName()}</td>
                        <td align="left">${hotel.getAddress()}</td>
                        <td align="left">${hotel.getPhoneNumber()}</td>
                        <td align="right">
                            <input type="hidden" name="hotelId" value="${hotel.getId()}">
                            <input formmethod="get" formaction="${pageContext.request.contextPath}/rooms" class="btn btn-default" type="submit" value="<fmt:message key="hotel.button.rooms"/>">
                            <input formmethod="get" formaction="${pageContext.request.contextPath}/hotel/edit" class="btn btn-default" type="submit" value="<fmt:message key="button.edit"/>">
                            <input formmethod="post" formaction="${pageContext.request.contextPath}/hotel/delete" class="btn btn-danger" type="submit" value="<fmt:message key="button.delete"/>">
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>
</jsp:attribute>
</tags:layout>