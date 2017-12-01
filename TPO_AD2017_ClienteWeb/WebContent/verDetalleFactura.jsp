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
<title>Detalle de Factura</title>

</head>
<body>


<%
if (request.getAttribute("items") ==null){
RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response);
}
List<ItemFacturaDTO> items = (List<ItemFacturaDTO>)request.getAttribute("items");
%>


	<table>
  <caption>Detalle de Factura N* <%=items.get(0).getFactura().getCodFactura() %></caption>
  <caption>Fecha <%=items.get(0).getFactura().getFecha() %>
  <br>Medio de Pago: <%=items.get(0).getFactura().getMedioPago() %>
  <br>Atendió: <%=items.get(0).getFactura().getMesa().getMozo().getApellido() %>
  </caption>
  
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Nombre</th>
	   <th scope="col">Valor</th>
	
      
    </tr>
  </thead>
  <tbody>
   <% for(ItemFacturaDTO item :  items) {%>
	
    <tr>
     <td data-label="Cantidad"><%= item.getItemcomanda().getCantidad() %></td>
     <td data-label="Nombre del Plato"><%= item.getItemcomanda().getPlato().getNombre() %></td>
     <td data-label="Subtotal"><%= item.getSubtotal() %></td>
     
        </tr>
     <%} %>
   
  </tbody>
</table>
<center><br>
<a>Total son ARS <%=items.get(0).getFactura().getImporte() %></a>
</center>

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>