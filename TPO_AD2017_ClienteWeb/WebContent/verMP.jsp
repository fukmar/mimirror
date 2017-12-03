<%@page import="interfazRemota.*"%>
<%@page import="bd.*"%>
<%@page import="dto.*"%>
<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%!
  private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
	}
  %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<%@include file="./menu.jsp"%> <br><br>
<title>Ver Stock de Materia Prima</title>

</head>
<body>


<%
if (request.getAttribute("materiales") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verMP");
rd.forward(request, response);
}
List<MateriaPrimaDTO> materiales = (List<MateriaPrimaDTO>)request.getAttribute("materiales");
%>



	<table>
  <caption>Materia Prima</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Descrición</th>
      <th scope="col">Unidad</th>
      <th scope="col">Cantidad</th>
      
    </tr>
  </thead>
  <tbody>
   <% for(MateriaPrimaDTO material : materiales) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= material.getCodigo() %></td>
      <td data-label="Descrición"><%= material.getDescripcion() %></td>
      <td data-label="Unidad"><%= material.getUnidadUso().getDescripcion() %></td>
      <td data-label="Cantidad"><%= material.getCantidad() %></td>
      </tr>
     <%} %>
    
  </tbody>
</table>
	
</form>
	
	
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>