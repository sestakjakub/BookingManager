<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:layout title="test">
    <jsp:attribute name="body">
<form role="form">
  <div class="form-group">
    <label>Room number</label>
    <input class="form-control" placeholder="Enter room number">
  </div>
  <div class="form-group">
    <label>Capacity</label>
    <input class="form-control" placeholder="Enter capacity">
  </div>
  <div class="form-group">
    <label>Price per night</label>
    <input class="form-control" placeholder="Enter price per night">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
    </jsp:attribute>
</tags:layout>