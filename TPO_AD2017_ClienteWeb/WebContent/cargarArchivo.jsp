<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Subir un Archivo</title>
</head>
<body>

<form action="/TPO_AD2017_ClienteWeb/Controller" method="post" enctype="multipart/form-data">
    <a>Descripción</a><input type="text" name="descripcion" />
    <input type="file" name="archivo" />
    <input type="hidden" name="opcion" value="cargarArchivo">
    <input type="submit" />
</form>

</body>
</html>