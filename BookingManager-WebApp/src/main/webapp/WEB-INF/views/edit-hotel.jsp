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
    <label>Name of hotel</label>
    <input class="form-control" placeholder="Enter name of hotel">
  </div>
  <div class="form-group">
    <label>Adress</label>
    <input class="form-control" placeholder="Enter address">
  </div>
  <div class="form-group">
    <label>Phone number</label>
    <input class="form-control" placeholder="Enter phone number">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
    </jsp:attribute>
</tags:layout>