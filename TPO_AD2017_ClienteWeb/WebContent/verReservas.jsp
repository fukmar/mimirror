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
<title>Reservas</title>

</head>
<body>


<%
if (request.getAttribute("reservas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verReservas");
rd.forward(request, response);
}
List<ReservaDTO> reservas = (List<ReservaDTO>)request.getAttribute("reservas");
%>



	<table>
  <caption>Reservas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Fecha y Hora</th>
      <th scope="col">A nombre de</th>
      <th scope="col">Cantidad Personas</th>
    </tr>
  </thead>
  <tbody>
   <% for(ReservaDTO reserva :  reservas) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= reserva.getCodReserva() %></td>
      <td data-label="Fecha y Hora"><%= reserva.getFechayHora() %></td>
      <td data-label="A nombre de"><%= reserva.getNombre() %></td>
      <td data-label="Cantidad Personas"><%= reserva.getCantidadComensales() %></td>
     </tr>
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>