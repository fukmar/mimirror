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
<title>Ver Comandas</title>

</head>
<body>


<%
if (request.getAttribute("comandas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verComandas");
rd.forward(request, response);
}
List<ComandaDTO> comandas = (List<ComandaDTO>)request.getAttribute("comandas");
%>


<form action="/TPO_AD2017_ClienteWeb/Controller">
	<table>
  <caption>Comandas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Estado</th>
      <th scope="col">Mesa</th>
      <th scope="col">Apellido del Mozo</th>
       <th scope="col">Ver Detalle</th>
    </tr>
  </thead>
  <tbody>
   <% for(ComandaDTO comanda :  comandas) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= comanda.getCodComanda() %></td>
      <td data-label="Estado"><%= comanda.getEstado() %></td>
      <td data-label="Mesa"><%= comanda.getMesa().getCodMesa() %></td>
      <td data-label="Apellido del Mozo"><%= comanda.getMozo().getApellido() %></td>
   	 <td data-label="Ver Detalles"><input type="radio" name="comandaelegida" value=<%= comanda.getCodComanda() %>>
     
      
      
      </tr>
     <%} %>
    
  </tbody>
</table>
	<center>
  <br>
<button name="opcion" value="verDetalleComanda">Mostrar Detalles</button>

	</center>
	
</form>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>