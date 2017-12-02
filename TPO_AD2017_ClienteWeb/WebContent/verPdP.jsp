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
<title>Ver Planes de Producción</title>

</head>
<body>

<form action="/TPO_AD2017_ClienteWeb/Controller">
<%
if (request.getAttribute("pdps") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verPdPs");
rd.forward(request, response);
}
List<PlanDeProduccionDTO> pdps = (List<PlanDeProduccionDTO>)request.getAttribute("pdps");
%>



	<table>
  <caption>Planes</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Fecha</th>
      <th scope="col">Elegir</th>
      
    </tr>
  </thead>
  <tbody>
   <% for(PlanDeProduccionDTO pdp :  pdps) {%>
	
     <tr>
      <td scope="row" data-label="Código"><%= pdp.getCodigoPDP() %></td>
      <td data-label="Fecha"><%= pdp.getFechaplan() %></td>
 	 <td data-label="Elegir"><input type="radio" name="pdpelegido" value=<%= pdp.getCodigoPDP() %>>
     </tr>
     <%} %>
    </tbody>
</table>
	<center>
  <br>
<button name="opcion" value="verDetallePdP">Mostrar Detalles</button>

	</center>
	
</form>
	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>