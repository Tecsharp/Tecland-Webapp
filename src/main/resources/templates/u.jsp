<%@page contentType="text/html; charset=UTF-8"
import="java.util.*, org.tecsharp.apiservlet.webapp.headers.models.*"%>
<%
Optional<String> username = (Optional<String>) request.getAttribute("username");
Usuario michel = (Usuario) request.getAttribute("michel");

//Usuario usuarioBusqueda = (Usuario) request.getAttribute("usuarioBusqueda");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%=michel.getUsername()%>

</body>
</html>