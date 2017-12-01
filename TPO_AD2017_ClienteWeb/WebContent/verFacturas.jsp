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
<title>Ver Facturas</title>

</head>
<body>


<%
if (request.getAttribute("facturas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verFacturas");
rd.forward(request, response);
}
List<FacturaDTO> facturas = (List<FacturaDTO>)request.getAttribute("facturas");
%>


<form action="/TPO_AD2017_ClienteWeb/Controller">
	<table>
  <caption>Facturas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Fecha</th>
      <th scope="col">Importe</th>
      <th scope="col">Medio de Pago</th>
      <th scope="col">Mesa</th>
      <th scope="col">Apellido del Mozo</th>
      <th scope="col">Ver Detalle</th>
    </tr>
  </thead>
  <tbody>
   <% for(FacturaDTO factura :  facturas) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= factura.getCodFactura() %></td>
      <td data-label="Fecha"><%= factura.getFecha() %></td>
      <td data-label="Importe"><%= factura.getImporte() %></td>
      <td data-label="Medio de Pago"><%= factura.getMedioPago().toString() %></td>
   	<td data-label="Mesa"><%= factura.getMesa().getCodMesa() %></td>
      <td data-label="Medio de Pago"><%= factura.getMesa().getMozo().getApellido() %></td>
      <td data-label="Ver Detalles"><input type="radio" name="facturaelegida" value=<%= factura.getCodFactura() %>>
      
      </tr>
     <%} %>
    
  </tbody>
</table>
	<center>
  <br>
<button name="opcion" value="verDetalleFactura">Mostrar Detalles</button>

	</center>

	</form>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>