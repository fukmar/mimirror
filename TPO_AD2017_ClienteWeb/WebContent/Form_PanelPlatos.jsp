<%@page import="interfazRemota.*"%>
<%@page import="dto.*"%>
<%@page import="bd.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Platos a preparar</title>

</head>
<body>


<% //	List<DTO.Producto> productos=  BusinessDelegate.getInstancia().getProductos();%>
<% //	List<DTO.Semielaborado> semis=  BusinessDelegate.getInstancia().getSemielaborados();%>
<% // List<DTO.Item_Pedido> losItemsPedidoPendientesDTO = BusinessDelegate.getInstancia().getItemPedidosPendientesDTO(1,1);%>

<table border="1">
<thead>
<tr bgcolor="yellow">
	<td>Plato</td>
	<td>Cant</td>
	<td>Accion</td>
	</tr>
</thead>
</table>	
	<P>
	<p>
	 <a href="index.jsp" target="_self">volver</a> 
  
  
</body>
</html>