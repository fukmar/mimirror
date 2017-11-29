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
<title>Ver Mozos</title>

</head>
<body>


<%
if (request.getAttribute("mozos") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verMozos");
rd.forward(request, response);
}
List<MozoDTO> mozos = (List<MozoDTO>)request.getAttribute("mozos");
%>



	<table>
  <caption>Mozos</caption>
  <thead>
    <tr>
      <th scope="col">DNI</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">% Comisión</th>
      
    </tr>
  </thead>
  <tbody>
   <% for(MozoDTO mozo :  mozos) {%>
	
    <tr>
      <td scope="row" data-label="DNI"><%= mozo.getDni() %></td>
      <td data-label="Nombre"><%= mozo.getNombre() %></td>
      <td data-label="Apellido"><%= mozo.getApellido() %></td>
      <td data-label="% Comisión"><%= mozo.getProcentajeComision() %></td>
      </tr>
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>