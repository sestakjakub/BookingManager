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
        <h1>List of hotels:</h1>
        <div class="btn-group" role="group">
            <a type="button" class="btn btn-default">Create new hotel</a>
            <a type="button" class="btn btn-default">Delete all hotels</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Name of hotel</th>
                    <th>Adress</th>
                    <th>Phone number</th>
                    <th>Rooms</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${hotels}" var="hotel">
                <tr>
                    <td>${hotel.getName()}</td>
                    <td>${hotel.getAddress()}</td>
                    <td>${hotel.getPhoneNumber()}</td>
                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/rooms">Show rooms</a></td>
                    <td><a class="btn btn-default" href="${pageContext.request.contextPath}/edit-hotel">Edit hotel</a></td>
                    <td><a class="btn btn-danger">Delete hotel</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</tags:layout>