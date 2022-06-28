<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "A better greetingx!" %>
</h1>

<br/>
<a href="hello-servlet">Hello Servlet</a>

<br/>

<a href="${pageContext.request.contextPath}/form.jsp">Form Servlet</a>
<br/>


<%--add resources link--%>
<a href="https://docs.oracle.com/cd/E13222_01/wls/docs92/webapp/configureservlet.html">Servlet Resources can be found
    here</a>
<br/>
<a href="https://www.atomickotlin.com/">Kotlin Resources can be found here</a>
<br/>


</body>
</html>