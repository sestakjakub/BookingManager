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

            <form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
                <table>
                    <tr>
                        <td><fmt:message key="login.username"/></td>
                        <td><input type='text' name='username' value=''></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="login.password"/></td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
                    </tr>
                </table>
            </form>
            <p><fmt:message key="login.dontuhaveacc"/> <a href="${pageContext.request.contextPath}/register"><fmt:message key="login.register"/></a></p>
        </div>
    </jsp:attribute>
</tags:layout>    