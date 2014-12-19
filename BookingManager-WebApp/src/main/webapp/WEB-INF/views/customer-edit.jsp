<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jiří Kareš
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:layout title="test">
    <jsp:attribute name="body">
        <form>
            <input type="hidden" name="customerId" value="${customerId}">
            <label for="customerName"><fmt:message key="customer.form.name"/></label>
            <input name="customerName" class="form-control">
            <label for="customerAddress"><fmt:message key="customer.form.address"/></label>
            <input name="customerAddress" class="form-control">
            <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/customer/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>">
            <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/customers" class="btn btn-default" value="<fmt:message key="button.cancel"/>">
        </form>
    </jsp:attribute>
</tags:layout>