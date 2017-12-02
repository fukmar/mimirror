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
<title>Ver Comisiones de los Mozos</title>

</head>
<body>


<%
if (request.getAttribute("comisiones") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=comisiones");
rd.forward(request, response);
}
ArrayList<String[]> comisiones = (ArrayList<String[]>)request.getAttribute("comisiones");
%>



	<table>
  <caption>Comisiones</caption>
  <thead>
    <tr>
      <th scope="col">DNI</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
       <th scope="col">$</th>
    </tr>
  </thead>
  <tbody>
  
 
   <% 
   
   
   for(String[] comision :  comisiones) {
	  
   %>
	
    <tr>
      <td scope="row" data-label="DNI"><%= comision[0] %></td>
      <td data-label="Nombre"><%= comision[1] %></td>
      <td data-label="Apellido"><%= comision[2] %></td>
      <td data-label="$"><%= truncateDecimal(Double.parseDouble(comision[3]),2) %></td>
   	    </tr>
     <%} %>
    
  </tbody>
</table>
	
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>