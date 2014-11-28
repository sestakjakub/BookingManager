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
                <h1>List bookings of room:</h1>
                <h2>Name of hotel: Hotel1</h2>
                <h3>Number of room: 101</h3>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">Create new booking</button>
                    <button type="button" class="btn btn-default">Delete booking</button>
                    <button type="button" class="btn btn-default">Edit booking</button>
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
                        </tr>
                        <tr>
                            <td>2.1.2015</td>
                            <td>3.1.2015</td>
                            <td>Franta Novak</td>
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