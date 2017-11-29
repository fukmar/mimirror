<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Resto</title>
<link rel="stylesheet" href="css/style.css">

</head>

<body>
  <div class="login-page">
<<<<<<< HEAD
  <form action="/TPO_AD2017_ClienteWeb/Controller?opcion=login" method="post">
=======
  <form action="/TPO_AD2017_ClienteWeb/menu.jsp" method="get">
>>>>>>> a7b9622a85516367a79c8ab3f0e3bcfb15dd8e7b
  <div class="form">
    <form class="login-form">
    		<a><% if (request.getParameter("mensaje") != null) out.print(request.getParameter("mensaje"));%></a>
      <input type="text" placeholder="usuario" name="usuario"/>
      <input type="password" placeholder="clave" name="clave"/>
      
      <button>Ingresar</button>
     
</form>
  </div>
</div>
 
 
</body>
</html>