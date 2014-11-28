<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <div class="container">

            <div class="starter-template">
                <h1>Name of hotel</h1>
                <h3>List of rooms:</h3>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">Add room</button>
                    <button type="button" class="btn btn-default">Delete room</button>
                    <button type="button" class="btn btn-default">Edit room</button>
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
                            <td><a href="${pageContext.request.contextPath}/room">link to bookings</a></td>
                        </tr>
                        <tr>
                            <td>102</td>
                            <td>2</td>
                            <td>5000</td>
                            <td><a href="${pageContext.request.contextPath}/room">link to bookings</a></td>
                        </tr>

                    </tbody>
                </table>
            </div>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        
    </jsp:attribute>
</tags:layout>