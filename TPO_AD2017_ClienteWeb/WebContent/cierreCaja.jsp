<%@page import="interfazRemota.*"%>
<%@page import="bd.*"%>
<%@page import="dto.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<%@include file="./menu.jsp"%> <br><br>
<title>Cierra Caja</title>

</head>
<body>

<table>
<%
if (request.getAttribute("valorcomi") ==null || request.getAttribute("valortotal") ==null){
RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response);
}

%>

<br><br><br><br><br>

  <center>
      <h1>La Caja Facturó $<%=request.getAttribute("valortotal")%></h1>
      <h1>Para Mozos $<%=request.getAttribute("valorcomi")%></h1>
      <h1>Quedan $<%=request.getAttribute("valorfinal")%></h1><br>
  	<center>
  <img src="img/cash.png" alt="cash"></center>
 </center>
  
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  </table>
</body>
</html>