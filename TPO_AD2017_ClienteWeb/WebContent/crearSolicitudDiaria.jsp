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
<title>Crear Solicitud Diaria</title>

</head>
<body>


<%

List<SolicitudIndividualDTO> solicitudesIndividuales = (List<SolicitudIndividualDTO>)request.getAttribute("solicitudesIndividuales");
%>

<form action="/TPO_AD2017_ClienteWeb/Controller">

	<table>
  <caption>Elija las Solicitudes Individuales para Unir a la Diaria</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Cantidad</th>
      <th scope="col">Materia Prima</th>
      <th scope="col">Motivo</th>
      <th scope="col">Responsable</th>
      <th scope="col">Elegir</th>
      
      </tr>
  </thead>
  <tbody>
   <% for(SolicitudIndividualDTO soli :  solicitudesIndividuales) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= soli.getCodsolicitudIndividual() %></td>
      <td data-label="Cantidad"><%= soli.getCantidad() %></td>
      <td data-label="Materia Prima"><%= soli.getMateriaprima().getDescripcion() %></td>
      <td data-label="Motivo"><%= soli.getMotivo() %></td>
      <td data-label="Responsable"><%= soli.getResponsable() %></td>
       <td data-label="Elegir"><input type="checkbox" name="solicitudesElegidas[]" value=<%= soli.getCodsolicitudIndividual() %>>
      
      <br></td>
      </tr>
     <%} %>
    
   
  </tbody>


</table>

  <center>
  <br>
  
<button name="opcion" value="combinarSolicitudesIndividuales">Combinar en una Solicitud Diaria</button>

	</center></form>

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>