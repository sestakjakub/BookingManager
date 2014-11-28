<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1>Name of hotel</h1>
        <h3>List of rooms:</h3>
        <div class="btn-group" role="group">
            <a type="button" class="btn btn-default">Add room</a>
            <a type="button" class="btn btn-default">Delete all rooms</a>
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
                <tr>
                    <td>101</td>
                    <td>4</td>
                    <td>1000</td>
                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/room">Show bookings</a></td>
                    <td><a class="btn btn-default">Edit room</a></td>
                    <td><a class="btn btn-danger">Delete room</a></td>
                </tr>
                </tr>
                <tr>
                    <td>102</td>
                    <td>2</td>
                    <td>5000</td>
                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/room">Show bookings</a></td>
                    <td><a class="btn btn-default">Edit room</a></td>
                    <td><a class="btn btn-danger">Delete room</a></td>
                </tr>

            </tbody>
        </table>
    </jsp:attribute>
</tags:layout>