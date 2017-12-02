<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css">

<title>Buscar Platos Alternativos</title>
</head>

<body>
<form action="/TPO_AD2017_ClienteWeb/Controller">
<div class="form">
    
      <input type="text" placeholder="nombre" name="nombre"/>
      <select name="mpago">
  <option value="contado">Bebida</option>
  <option value="debito">Carnes</option>
  <option value="credito">Pollo</option>
  <option value="debito">Pescado</option>
  <option value="credito">Postres</option>
  <option value="contado">Vegetariano</option>
  <option value="debito">EspecialdelDia</option>
  <option value="credito">Vinos</option>

</select>
<br>
       <input type="hidden" name="opcion" value="sugerirPlatos">
      
       <button>Sugerir Alternativa</button>
     
</form>
</body>
</html>
