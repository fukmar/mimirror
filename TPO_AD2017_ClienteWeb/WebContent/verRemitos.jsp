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
<title>Remitos</title>

</head>
<body>


<%
if (request.getAttribute("remitos") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verRemitos");
rd.forward(request, response);
}
List<RemitoDTO> remitos = (List<RemitoDTO>)request.getAttribute("remitos");
%>



	<table>
  <caption>Remitos</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Código Proveedor</th>
      <th scope="col">Fecha</th>
      <th scope="col">Estado</th>
    </tr>
  </thead>
  <tbody>
   <% for(RemitoDTO remito :  remitos) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= remito.getCodRemito() %></td>
      <td data-label="Código Proveedor"><%= remito.getCodigoProveedor() %></td>
      <td data-label="Fecha"><%= remito.getFecha() %></td>
      <td data-label="Estado"><%= remito.getEstado() %></td>
     </tr>
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>