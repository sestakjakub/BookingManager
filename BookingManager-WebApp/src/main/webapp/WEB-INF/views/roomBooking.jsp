<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1>List bookings of room:</h1>
        <h2>Name of hotel: Hotel1</h2>
        <h3>Number of room: 101</h3>
        <div class="btn-group" role="group">
            <a type="button" class="btn btn-default">Create new booking</a>
            <a type="button" class="btn btn-default">Delete all bookings</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Date from</th>
                    <th>Date to</th>
                    <th>Customer</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1.1.2015</td>
                    <td>2.1.2015</td>
                    <td>Josef Novak</td>
                    <td><a class="btn btn-default">Edit booking</a></td>
                    <td><a class="btn btn-danger">Delete booking</a></td>
                </tr>
                <tr>
                    <td>2.1.2015</td>
                    <td>3.1.2015</td>
                    <td>Franta Novak</td>
                    <td><a class="btn btn-default">Edit booking</a></td>
                    <td><a class="btn btn-danger">Delete booking</a></td>
                </tr>

            </tbody>
        </table>
    </jsp:attribute>
</tags:layout>