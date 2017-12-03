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
<title>Ver Mis Comandas</title>

</head>
<body>


<%
if (request.getAttribute("items") ==null){
RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response);
}
List<ItemComandaDTO> items = (List<ItemComandaDTO>)request.getAttribute("items");
%>



<form action="/TPO_AD2017_ClienteWeb/Controller">
	<table>
  <caption>Mis Comandas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Debo Preparar</th>
	 <th scope="col">Está Listo!</th>
      
    </tr>
  </thead>
  <tbody>
   <% for(ItemComandaDTO item :  items) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= item.getCoditemComanda() %></td>
      <td data-label="Debo Preparar"><%= item.getPlato().getNombre() %></td>
     <td data-label="Listo"><input type="radio" name="listo" value=<%= item.getCoditemComanda() %>>
 
        </tr>
     <%} %>
    
  </tbody>
  
</table>

<center>
  <br>
<button name="opcion" value="listo">Listo</button>

	</center>	

	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>