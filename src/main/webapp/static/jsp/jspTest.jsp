<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title> Tag Example</title>
</head>
<body>

<%
    String attr1 = (String) session.getAttribute("sessionKey");

    System.out.println(attr1);
%>

<p>
    <c:forEach var="address" items="${user.address}">
        <p>
            Item address: <c:out value="${address}"/>
        <p>
    </c:forEach>
</p>

</body>
</html>
