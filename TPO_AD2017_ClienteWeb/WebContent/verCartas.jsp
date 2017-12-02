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
<title>Ver Carta</title>

</head>
<body>


<%
if (request.getAttribute("cartas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verCartas");
rd.forward(request, response);
}
List<CartaDTO> cartas = (List<CartaDTO>)request.getAttribute("cartas");
%>


<form action="/TPO_AD2017_ClienteWeb/Controller">
	<table>
  <caption>Cartas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Temporada</th>
      <th scope="col">Vigencia</th>
       <th scope="col">Ver Detalle</th>
    </tr>
  </thead>
  <tbody>
   <% for(CartaDTO carta :  cartas) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= carta.getCodigoCarta() %></td>
      <td data-label="Temporada"><%= carta.getTemporada() %></td>
      <td data-label="Vigencia"><%= carta.getVigencia() %></td>
    	 <td data-label="Ver Detalle"><input type="radio" name="cartaelegida" value=<%= carta.getCodigoCarta() %>>
    
      </tr>
     <%} %>
    
  </tbody>
</table>
	<center>
  <br>
<button name="opcion" value="verDetalleCarta">Mostrar Detalles</button>

	</center>
	
</form>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>