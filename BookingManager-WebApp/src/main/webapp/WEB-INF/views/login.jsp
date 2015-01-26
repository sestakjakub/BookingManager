<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:layout title="test">
    <jsp:attribute name="body">
        <div class="jumbotron">
            <h3><fmt:message key="login.login"/></h3>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form class="form-horizontal" name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="username"><fmt:message key="login.username"/></label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" name="username" id="username" placeholder="Enter username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="password"><fmt:message key="login.password"/></label>
                    <div class="col-sm-4">
                        <input class="form-control" type="password" name="password" id="password" placeholder="Enter password">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>


            </form>
            <p><fmt:message key="login.dontuhaveacc"/> <a href ="<c:url value="/customer/register"><c:param name="customerId" value="0"/></c:url>"><fmt:message key="login.register"/></a></p>
            </div>
    </jsp:attribute>
</tags:layout>    