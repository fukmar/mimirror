<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Resto</title>
<link rel="stylesheet" href="css/style.css">


<script language="Javascript">

            function IsEmpty(){ 
            	
                if(document.getElementById("usuario").value == "" || document.getElementById("clave").value == "")
                {
                    alert("Debe completar usuario y clave");
                }
                return;
            }


        </script>

</head>

<body>
  <div class="login-page">

  <form action="/TPO_AD2017_ClienteWeb/Controller?opcion=login" method="post">
  
  <div class="form">
  <center>
  <img src="img/logo.jpg" alt="logo" width="240"></center>
  <br><br>
    <form class="login-form">
    
    		<a><% if (request.getParameter("mensaje") != null) out.print(request.getParameter("mensaje"));%></a>
      <input type="text" id="usuario" placeholder="usuario" name="usuario"/>
      <input type="password" id="clave" placeholder="clave" name="clave"/>
      
      <button onclick="IsEmpty();">Ingresar</button>
     
</form>
  </div>
</div>
 
 
</body>
</html>