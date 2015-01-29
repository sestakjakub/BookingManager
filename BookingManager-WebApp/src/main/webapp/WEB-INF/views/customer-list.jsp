<%-- 
    Document   : hotels
    Created on : 27.11.2014, 23:23:27
    Author     : Jiří Kareš
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <h1><fmt:message key="customer.list.list"/></h1>
        <div class="btn-group" role="group">
            <form action="${pageContext.request.contextPath}/customer/edit">
                <input type="hidden" name="customerId" value="0">
<!--                <input formmethod="get" class="btn btn-primary" type="submit" value="<fmt:message key="customer.button.create"/>">-->
            </form>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="customer.list.id"/></th>
                    <th><fmt:message key="customer.list.name"/></th>
                    <th><fmt:message key="customer.list.address"/></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customers}" var="customer">
                <form>
                    <tr>
                        <td align="left">${customer.getId()}</td>
                        <td align="left">${customer.getName()}</td>
                        <td align="left">${customer.getAddress()}</td>
                        <td align="right">
                            <input type="hidden" name="customerId" value="${customer.getId()}">
                            <input formmethod="get" formaction="${pageContext.request.contextPath}/customer/edit/${customer.getId()}" class="btn btn-default" type="submit" value="<fmt:message key="button.edit"/>">
                            <input formmethod="post" formaction="${pageContext.request.contextPath}/customer/delete/${customer.getId()}" class="btn btn-danger" type="submit" value="<fmt:message key="button.delete"/>">
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>
</jsp:attribute>
</tags:layout>