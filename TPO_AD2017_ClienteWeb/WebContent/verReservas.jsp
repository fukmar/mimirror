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
<title>Platos Disponibles</title>

</head>
<body>


<%

List<ReservaDTO> reservas = (List<ReservaDTO>)request.getAttribute("reservas");
%>

<Select name = "Reservas">
<% for(ReservaDTO reserva :  reservas) {%>
	<option value= <%= reserva.getNombre()  %>><%= reserva.toString()%></option> 
<%} %>
</select>

	<P>
	<p>
	 <a href="index.jsp" target="_self">volver</a> 
  
  
</body>
</html>