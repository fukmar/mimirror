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
<title>Mesas Libres</title>

</head>
<body>


<%
if (request.getAttribute("mesas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=mesas");
rd.forward(request, response);
}
List<MesaDTO> mesas = (List<MesaDTO>)request.getAttribute("mesas");
%>

<form action="/TPO_AD2017_ClienteWeb/Controller">

	<table>
  <caption>Mesas</caption>
  <thead>
    <tr>
      <th scope="col">Código</th>
      <th scope="col">Capacidad de la Mesa</th>
      <th scope="col">Sector de la Mesa</th>
      <th scope="col">Elegir</th>
      </tr>
  </thead>
  <tbody>
   <% for(MesaDTO mesa :  mesas) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= mesa.getCodMesa() %></td>
      <td data-label="Capacidad de la Mesa"><%= mesa.getCapacidad() %></td>
      <td data-label="Sector de la Mesa"><%= mesa.getSector().getDescripcion() %></td>
      <td data-label="Elegir"><input type="checkbox" name="mesaelegida[]" value=<%= mesa.getCodMesa() %>>
      
      <br></td>
      </tr>
     <%} %>
    
   
  </tbody>


</table>

  <center>
  <br>
   <button>Abrir Mesa</button>
<button>Combinar Dos Mesas</button>
<input type="hidden" name="opcion" value="ocuparMesa">
	</center></form>

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>