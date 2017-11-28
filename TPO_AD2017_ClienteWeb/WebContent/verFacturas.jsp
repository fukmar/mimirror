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
<title>Lista de todas las Facturas</title>

</head>
<body>


<%
if (request.getAttribute("facturas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verFacturas");
rd.forward(request, response);
}
List<FacturaDTO> facturas = (List<FacturaDTO>)request.getAttribute("facturas");
%>

<Select name = "Facturas">
<% for(FacturaDTO factura :  facturas) {%>
	<option value= <%= factura.getCodFactura()  %>><%=factura.toString()%></option> 
<%} %>
</select>

	<P>
	<p>
	 <a href="index.jsp" target="_self">volver</a> 
  
  
</body>
</html>