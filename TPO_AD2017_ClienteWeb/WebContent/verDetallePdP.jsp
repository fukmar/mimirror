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
<title>Detalle de PdP</title>

</head>
<body>


<%
if (request.getAttribute("items") ==null){
RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response);
}
List<ItemPlanProduccionDTO> items = (List<ItemPlanProduccionDTO>)request.getAttribute("items");
PlanDeProduccionDTO pdp = (PlanDeProduccionDTO)request.getAttribute("pdp");
%>


	<table>
  <caption>Detalle de PdP N* <%=pdp.getCodigoPDP() %></caption><br>
   <caption>Fecha: <%=pdp.getFechaplan() %></caption>
 
  
  <thead>
    <tr>
  
      <th scope="col">Cantidad</th>
	   <th scope="col">Nombre del SemiElaborado</th>
	 <th scope="col">Avance</th>

    </tr>
  </thead>
  <tbody>
   <% for(ItemPlanProduccionDTO item :  items) {%>
	
    <tr>
     <td data-label="Cantidad"><%= item.getCantidad() %></td>
     <td data-label="Nombre del SemiElaborado"><%= item.getSemielaborado().getDescripcion() %></td>
     <td data-label="Avance"><%= item.getPorcientoavance() %></td>
     
        </tr>
     <%} %>
   
  </tbody>
</table>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>