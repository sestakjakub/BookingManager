<%-- 
    Document   : edit-hotel
    Created on : 28.11.2014, 18:42:53
    Author     : Jiří Kareš
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <form:form modelAttribute="customerForm" commandName = "customerForm">
            <form:hidden path="id"/>
            <form:label path="name"><fmt:message key="customer.form.name"/></form:label>
            <form:input path="name" class="form-control"/>
            <form:label path="address"><fmt:message key="customer.form.address"/></form:label>
            <form:input path="address" class="form-control"/>
            <form:label path="username"><fmt:message key="customer.form.username"/></form:label>
            <form:input path="username" class="form-control"/>
            <form:label path="password"><fmt:message key="customer.form.password"/></form:label>
            <form:password path="password" class="form-control"/>
            <input type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/customer/edit/submit" class="btn btn-default" value="<fmt:message key="button.submit"/>">
            <input type="submit" formmethod="get" formaction="${pageContext.request.contextPath}/" class="btn btn-default" value="<fmt:message key="button.cancel"/>">
        </form:form>
    </jsp:attribute>
</tags:layout>