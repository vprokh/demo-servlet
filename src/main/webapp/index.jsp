<html>
<head>
    <title>MyFirstServlet Demo</title>
</head>
<body>
<a href="/my-servlet">${testKey}</a>

<br/>

<form action="my-servlet" method="post">
    Width: <input type="text" size="5" name="width"/>
    &nbsp;&nbsp;
    Height <input type="text" size="5" name="height"/>
    &nbsp;&nbsp;
    <input type="submit" value="Calculate"/>
</form>
</body>
</html>