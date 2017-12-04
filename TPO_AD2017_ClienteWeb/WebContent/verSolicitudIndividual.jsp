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
<title>Solicitudes Individuales</title>

</head>
<body>


<%
if (request.getAttribute("sols") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verSolicitudesIndividuales");
rd.forward(request, response);
}
List<SolicitudIndividualDTO> sols = (List<SolicitudIndividualDTO>)request.getAttribute("sols");
%>



	<table>
  <caption>Solicitudes Individuales</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Cantidad</th>
      <th scope="col">Unidad</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Responsable</th>
    </tr>
  </thead>
  <tbody>
   <% for(SolicitudIndividualDTO sol :  sols) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= sol.getCodsolicitudIndividual() %></td>
      <td data-label="Cantidad"><%= sol.getCantidad() %></td>
      <td data-label=Unidad><%= sol.getMateriaprima().getUnidadUso().getDescripcion() %></td>
      <td data-label="Despcripcion"><%= sol.getMateriaprima().getDescripcion() %></td>
      <td data-label="Responsable"><%= sol.getResponsable() %></td>
     </tr>
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>