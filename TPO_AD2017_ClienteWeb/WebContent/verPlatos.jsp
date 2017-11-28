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
if (request.getAttribute("platos") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verPlatos");
rd.forward(request, response);
}
List<PlatoDTO> platos = (List<PlatoDTO>)request.getAttribute("platos");
%>

<Select name = "Platos">
<% for(PlatoDTO plato :  platos) {%>
	<option value= <%= plato.getCodigo() %>><%=plato.toString()%></option> 
<%} %>
</select>

	<P>
	<p>
	 <a href="index.jsp" target="_self">volver</a> 
  
  
</body>
</html>