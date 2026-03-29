<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${param.win == 'true'}">
        <h2>Ты выжил</h2>
    </c:when>
    <c:otherwise>
        <h2>Ты погиб</h2>
    </c:otherwise>
</c:choose>

<form method="post">
    <button type="submit">Начать занаво</button>
</form>
