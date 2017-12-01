<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css">
<%@include file="./menu.jsp"%> <br><br>
<title>Cargar una Reserva</title>
</head>

<body>
<form action="/TPO_AD2017_ClienteWeb/Controller">
<div class="form">
    
      <input type="text" placeholder="nombre" name="nombre"/>
      <input type="text" placeholder="fecha (AAAA-MM-DD HH:MM:SS)" name="fecha"/>
      <input type="text" placeholder="cantidad" name="cantidad"/>
      <input type="hidden" name="opcion" value="cargarReserva">
      
       <button>Cargar Reserva</button>
     
</form>
</body>
</html>
