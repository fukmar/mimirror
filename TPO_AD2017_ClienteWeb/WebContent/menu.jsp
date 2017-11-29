 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Menu Principal</title>

</head>
<body>
 
 
<%@ page import=" java.util.*" %>
<%      
    HashMap<String,HashMap<String,String>> menus = new HashMap<String,HashMap<String,String>>();
    HashMap<String,String> submmenus;
    HashMap<String,String> submmenus2;
 %>
 <nav id="primary_nav_wrap">
    <ul id="menu">
    
 <li><a href="index.jsp">Inicio</a></li>
        
 <%          

		  if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("admin"))
		  { 
 			out.print("<a>Hola "+session.getAttribute("usuario")+"!</a>");    
 		
 		 submmenus = new HashMap<String,String>();
			 submmenus.put("Ver Platos", "/TPO_AD2017_ClienteWeb/Controller?opcion=verPlatos");
			 menus.put("Platos", submmenus);
			 
			 submmenus = new HashMap<String,String>();
			 submmenus.put("Ver Mozos", "/TPO_AD2017_ClienteWeb/Controller?opcion=verMozos");
			 menus.put("Mozos", submmenus);
			 
		submmenus = new HashMap<String,String>();		
			
		submmenus.put("Ver Comandas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verComandas");
			 submmenus.put("Cargar Comandas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verDatosParaCargarComanda");
				
			 menus.put("Comandas", submmenus);
            
			 submmenus = new HashMap<String,String>();
		
			 
			 submmenus.put("Ver Facturas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verFacturas");
				
			 menus.put("Facturas", submmenus);
            
			 submmenus = new HashMap<String,String>();
		
			 
			 submmenus.put("Ver Reservas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verReservas");
			 submmenus.put("Cargar Reservas", "/TPO_AD2017_ClienteWeb/cargarReserva.jsp");
			 menus.put("Reservas", submmenus);   
			 
			 
        for( Iterator itMenu = menus.keySet().iterator(); itMenu.hasNext();) { 
            String menuName = (String)itMenu.next();
            HashMap sub = (HashMap)menus.get(menuName);            
%>            
        <li><a href=?#?><%=menuName%></a>
            <ul>
            
 <%     
            for(Iterator itSub = sub.keySet().iterator(); itSub.hasNext();) {
                 String subMenuName = (String)itSub.next();
                 String subMenuAction = (String)sub.get(subMenuName);
 %>
                <li><a href="<%=subMenuAction%>" ><%=subMenuName%></a></li>
 <%
            }
 %>
            </ul>
        </li>
         
 <%        
        }}
		  else{ //no hay sesion o no es admin
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?mensaje=Usuario o Clave Incorrectos");
		rd.forward(request, response);
        }
        
 %>
       

 <li><a href="/TPO_AD2017_ClienteWeb/Controller?opcion=logout">Salir</a></li>


    </ul>
    </nav>
</body>
</html>
                