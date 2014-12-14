<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title><h1>this is test</h1></title>
</head>
<body>
<h2>hello: <%=request.getAttribute("test")%></h2>
<h1>${test}</h1>
</body>
</html>
