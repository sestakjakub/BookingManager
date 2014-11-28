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
        <div class="container">

            <div class="starter-template">
                <h1>List of hotels:</h1>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">Create new hotel</button>
                    <button type="button" class="btn btn-default">Delete hotel</button>
                    <button type="button" class="btn btn-default">Edit hotel</button>
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
                            <td>hotel 1</td>
                            <td>Botanicka, brno</td>
                            <td>123456</td>
                            <td><a href="${pageContext.request.contextPath}/hotel">link</a></td>
                        </tr>
                    </c:forEach>
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