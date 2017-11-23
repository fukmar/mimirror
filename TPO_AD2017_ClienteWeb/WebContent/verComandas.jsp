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
<title>Lista de todas las Comandas</title>

</head>
<body>


<%
if (request.getAttribute("comandas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verComandas");
rd.forward(request, response);
}
List<ComandaDTO> comandas = (List<ComandaDTO>)request.getAttribute("comandas");
%>

<Select name = "Comandas">
<% for(ComandaDTO comanda :  comandas) {%>
	<option value= <%= comanda.getCodComanda()  %>><%=comanda.toString()%></option> 
<%} %>
</select>

	<P>
	<p>
	 <a href="index.jsp" target="_self">volver</a> 
  
  
</body>
</html>