<%--isELIgnored should be set to false before Servlet 2.4 --%>
<%--more info https://docs.oracle.com/cd/E19575-01/819-3669/6n5sg7b35/index.html--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title> Tag Example</title>
</head>
<body>

<%
    String sessionAttribute = (String) session.getAttribute("sessionKey");
    String requestAttribute = (String) request.getAttribute("testKey");

    System.out.println("requestAttribute = " + requestAttribute);
    System.out.println("sessionAttribute = " + sessionAttribute);

    // any Java code can be written between these tags
%>

<p>
    Request attribute: ${testKey}
    Request attribute: ${employee.address}
</p>

<p>
    <c:forEach var="address" items="${employee.address}">
        <p>
            Item address: <c:out value="${address}"/>
        <p>
    </c:forEach>
</p>

</body>
</html>
