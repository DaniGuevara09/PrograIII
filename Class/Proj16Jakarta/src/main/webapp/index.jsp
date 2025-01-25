<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<div>
    <select>
        <%
            for (int i = 0; i <= 1000 ; i++) {
                out.print("<option>" + i + "</option>");
            }
        %>
    </select>
</div>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>