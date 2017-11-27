<%@page import="interfazRemota.*"%>
<%@page import="bd.*"%>
<%@page import="dto.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cargar una Comanda</title>
</head>

<body>
<form action="/TPO_AD2017_ClienteWeb/Controller">

<table border="1">

    <tr><td>Elija Mesa</td><td>
    
    <%
if (request.getAttribute("datosParaComanda") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verDatosParaCargarComanda");
rd.forward(request, response);
}
List<MesaDTO> mesas = (List<MesaDTO>)request.getAttribute("mesas");
%>

<Select name = "Mesas">
<% for(MesaDTO mesa :  mesas) {%>
	<option value= <%= mesa.getCodMesa() %>><%=mesa.toString() %></option> 
<%} %>
</select> 
    
    </table>
    
    </td></tr>
    
    
  
   
    <%
if (request.getAttribute("datosParaComanda") ==null){
RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verDatosParaCargarComanda");
rd.forward(request, response);
}
List<PlatoDTO> platos = (List<PlatoDTO>)request.getAttribute("platos");
%>

<Select name = "Platos">
<% for(PlatoDTO plato :  platos) {%>
	<option value= <%= plato.getCodigo() %>><%=plato.toString()%></option> 
<%} %>
</select> 
   
    <tr><td>Cantidad</td><td><input name="cantidad", size="20"/></td></tr>
    
   

    
    
    <tr><td>Elija Plato</td><td>
    
   
<tr><td colspan="2" align="right"><input name="boton" type="submit" value="Aceptar"  /></td></tr>
<input type="hidden" name="opcion" value="cargarComanda">
</form>
</body>
</html>
