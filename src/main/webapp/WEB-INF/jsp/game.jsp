<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Игрок: ${sessionScope.game.username}</p>
<p>Ходов: ${sessionScope.game.steps}</p>

<h3>${scene.question}</h3>

<form method="post">
    <c:forEach var="step" items="${scene.steps}">
        <button name="step" value="${step.id}">
                ${step.text}
        </button>
        <br/><br/>
    </c:forEach>
</form>
