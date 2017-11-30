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



	<table>
  <caption>Platos</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col">Carta N*</th>
    </tr>
  </thead>
  <tbody>
   <% for(PlatoDTO plato :  platos) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= plato.getCodigo() %></td>
      <td data-label="Nombre"><%= plato.getNombre() %></td>
      <td data-label="Precio"><%= plato.getPrecio()  %></td>
      <td data-label="Carta N*"><%= plato.getCarta().getCodigoCarta() %></td>
     </tr>
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>