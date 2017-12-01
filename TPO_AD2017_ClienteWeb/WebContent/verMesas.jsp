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
<title>Ver todas las Mesas</title>

</head>
<body>


<%
if (request.getAttribute("mesas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verMesas");
rd.forward(request, response);
}
List<MesaDTO> mesas = (List<MesaDTO>)request.getAttribute("mesas");
%>



	<table>
  <caption>Mesas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Capacidad</th>
      <th scope="col">Estado</th>
      <th scope="col">Sector</th>
        <th scope="col">Mozo</th>
    </tr>
  </thead>
  <tbody>
   <% for(MesaDTO mesa :  mesas) {%>
	<% if (mesa.getCombinada().equals(1)){ 
	%>
    <tr>
      <td scope="row" data-label="Código"><strong> COMB<%= mesa.getCodMesa() %></strong></td>
      <td data-label="Capacidad"><%= mesa.getCapacidad() %></td>
       <td data-label="Estado"><%= mesa.getEstado() %></td>
       <td data-label="Sector"><%= mesa.getSector().getDescripcion() %></td>
       <td data-label="Mozo"><%= mesa.getMozo().getApellido() %></td>
      
     </tr>
     <%} else {%>
     <tr>
      <td scope="row" data-label="Código"><%= mesa.getCodMesa() %></td>
      <td data-label="Capacidad"><%= mesa.getCapacidad() %></td>
       <td data-label="Estado"><%= mesa.getEstado() %></td>
       <td data-label="Sector"><%= mesa.getSector().getDescripcion() %></td>
       <td data-label="Mozo"><%= mesa.getMozo().getApellido() %></td>
      
     </tr>
     <%} %>
    
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>