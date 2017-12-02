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
<title>Vamos a Facturar una Mesa</title>

</head>
<body>


<%
if (request.getAttribute("mesas") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=facturarMesa");
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
      <th scope="col">Elegir</th>
      <th scope="col">Medio de Pago</th>
      </tr>
  </thead>
  <tbody>
   <% for(MesaDTO mesa :  mesas) {%>
	
    <tr>
      <td scope="row" data-label="Código"><%= mesa.getCodMesa() %></td>
       <td data-label="Elegir"><input type="radio" name="mesaelegida" value=<%= mesa.getCodMesa() %>>
         <td data-label="Elegir"><select name="mpago">
  <option value="contado">Contado</option>
  <option value="debito">Débito</option>
  <option value="credito">Crédito</option>

</select>
    
      <br></td>
      </tr>
     <%} %>
    
   
  </tbody>


</table>

  <center>
  <br>
   <button name="opcion" value="facturarMesaYa">Facturar Mesa $$$$</button>

	</center></form>

	<P>
	<p>
	 <a href="index.jsp" target="_self" class="link-btn">volver</a> 
  
  
</body>
</html>