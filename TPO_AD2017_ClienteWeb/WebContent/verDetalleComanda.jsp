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
<title>Detalle de Comanda</title>

</head>
<body>


<%
if (request.getAttribute("items") ==null){
RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response);
}
List<ItemComandaDTO> items = (List<ItemComandaDTO>)request.getAttribute("items");
%>


	<table>
  <caption>Detalle de Comanda N* <%=items.get(0).getComanda().getCodComanda() %></caption>
  <br>Atendió: <%=items.get(0).getComanda().getMesa().getMozo().getApellido() %>
  </caption>
  
  <thead>
    <tr>
  
      <th scope="col">Nombre</th>
	   <th scope="col">Cantidad a Preparar</th>
	
      
    </tr>
  </thead>
  <tbody>
   <% for(ItemComandaDTO item :  items) {%>
	
    <tr>
     <td data-label="Nombre del Plato"><%= item.getPlato().getNombre() %></td>
     <td data-label="Cantidad"><%= item.getCantidad() %></td>
     
        </tr>
     <%} %>
   
  </tbody>
</table>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>