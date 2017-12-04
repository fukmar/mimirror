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
<title>Solicitudes Diarias</title>

</head>
<body>


<%
if (request.getAttribute("sols") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verSolicitudesDiarias");
rd.forward(request, response);
}
List<SolicitudDiariaDTO> sols = (List<SolicitudDiariaDTO>)request.getAttribute("sols");
%>



	<table>
  <caption>Solicitudes Diarias</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Deposito</th>
     
    </tr>
  </thead>
  <tbody>
   <% for(SolicitudDiariaDTO sol :  sols) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= sol.getCodsolicitudDiaria() %></td>
      <td data-label="Deposito"><%= sol.getDeposito().getCodDeposito() %></td>
      
     </tr>
     <%} %>
    
  </tbody>
</table>
	

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>