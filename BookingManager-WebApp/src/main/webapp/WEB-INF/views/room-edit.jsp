<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
<form role="form">
  <div class="form-group">
    <label><fmt:message key="room.list.number"/></label>
    <input class="form-control" placeholder="<fmt:message key="room.form.number"/>">
  </div>
  <div class="form-group">
    <label><fmt:message key="room.list.capacity"/></label>
    <input class="form-control" placeholder="<fmt:message key="room.form.capacity"/>">
  </div>
  <div class="form-group">
    <label><fmt:message key="room.list.price"/></label>
    <input class="form-control" placeholder="<fmt:message key="room.form.price"/>">
  </div>
  <button type="submit" class="btn btn-default"><fmt:message key="button.submit"/></button>
</form>
    </jsp:attribute>
</tags:layout>