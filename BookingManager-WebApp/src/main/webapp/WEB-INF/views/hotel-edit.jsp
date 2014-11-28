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
    <label><fmt:message key="hotel.list.name"/></label>
    <input class="form-control" placeholder="<fmt:message key="hotel.form.name"/>">
  </div>
  <div class="form-group">
    <label><fmt:message key="hotel.list.address"/></label>
    <input class="form-control" placeholder="<fmt:message key="hotel.form.address"/>">
  </div>
  <div class="form-group">
    <label><fmt:message key="hotel.list.phone"/></label>
    <input class="form-control" placeholder="<fmt:message key="hotel.form.phone"/>">
  </div>
  <button type="submit" class="btn btn-default"><fmt:message key="button.submit"/></button>
</form>
    </jsp:attribute>
</tags:layout>