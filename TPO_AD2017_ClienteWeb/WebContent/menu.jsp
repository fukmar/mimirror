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
   
 %>
 <nav id="primary_nav_wrap">
    <ul id="menu">
    
 <li><a href="index.jsp">Inicio</a></li>
        
 <%          

		  if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("admin"))
		  { 
 			out.print("<a>Hola "+session.getAttribute("usuario")+"</a>");    
 		
 		 submmenus = new HashMap<String,String>();
 		 submmenus.put("Ver Platos", "/TPO_AD2017_ClienteWeb/Controller?opcion=verPlatos");
 		 submmenus.put("Sugerir Platos", "/TPO_AD2017_ClienteWeb/pedirDatosSugerir.jsp");
			 menus.put("Platos", submmenus);
			 
			 submmenus = new HashMap<String,String>();
			 submmenus.put("Ver Mozos", "/TPO_AD2017_ClienteWeb/Controller?opcion=verMozos");
			 submmenus.put("Ver Comisiones", "/TPO_AD2017_ClienteWeb/Controller?opcion=verComisiones");
				
			 menus.put("Mozos", submmenus);
			 
		submmenus = new HashMap<String,String>();		
			
		submmenus.put("Ver Comandas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verComandas");
			 submmenus.put("Cargar Comandas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verDatosParaCargarComanda");
				
			 menus.put("Comandas", submmenus);
            
			 
			 submmenus = new HashMap<String,String>();		
				
				submmenus.put("Asignar y Combinar Mesas", "/TPO_AD2017_ClienteWeb/Controller?opcion=mesas");
				submmenus.put("Ver todas las Mesas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verMesas");
				
					 menus.put("Mesas", submmenus);
		      
			 submmenus = new HashMap<String,String>();
		
			 submmenus.put("Ver Facturas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verFacturas");
			 submmenus.put("Facturar Mesa", "/TPO_AD2017_ClienteWeb/Controller?opcion=facturarMesa");				
			 menus.put("Facturas", submmenus);
			 
			 
			 submmenus = new HashMap<String,String>();
				
			 submmenus.put("Comisiones", "/TPO_AD2017_ClienteWeb/Controller?opcion=comisiones");
			 submmenus.put("Cerrar", "/TPO_AD2017_ClienteWeb/Controller?opcion=cerrarCaja");				
			 menus.put("Caja", submmenus);
            
			 submmenus = new HashMap<String,String>();
		
			 
			 submmenus.put("Ver Reservas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verReservas");
			 submmenus.put("Cargar Reservas", "/TPO_AD2017_ClienteWeb/cargarReserva.jsp");
			 menus.put("Reservas", submmenus);   
			 
			 submmenus = new HashMap<String,String>();
				
			 submmenus.put("Ver Carta", "/TPO_AD2017_ClienteWeb/Controller?opcion=verCartas");
			 
			 menus.put("Carta", submmenus);   
			 
			 submmenus = new HashMap<String,String>();
				
			 submmenus.put("Ver PdPs", "/TPO_AD2017_ClienteWeb/Controller?opcion=verPdPs");
				 
			 menus.put("PdP", submmenus);   
			
			 submmenus = new HashMap<String,String>();
				
			 submmenus.put("Ver Materia Prima", "/TPO_AD2017_ClienteWeb/Controller?opcion=verMP");
				 
			 menus.put("Stock", submmenus);   
			
			 submmenus = new HashMap<String,String>();
				
			 submmenus.put("Solicitud Diaria", "/TPO_AD2017_ClienteWeb/Controller?opcion=solicitudDiaria");
			 submmenus.put("Solicitud Individual", "/TPO_AD2017_ClienteWeb/Controller?opcion=solicitudIndividual");
			 
			 menus.put("Insumos", submmenus);   
			
			 
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
		  else if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("cocina")){
			  out.print("<a>Hola "+session.getAttribute("usuario")+"!</a>");
			  submmenus = new HashMap<String,String>();		
				
				submmenus.put("Ver Comandas de la Cocina", "/TPO_AD2017_ClienteWeb/Controller?opcion=verComandas");
					 menus.put("Comandas", submmenus);
					 
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
		  
		  else if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("bar")){
			  out.print("<a>Hola "+session.getAttribute("usuario")+"!</a>");
			  submmenus = new HashMap<String,String>();		
				
				submmenus.put("Ver Comandas del Bar", "/TPO_AD2017_ClienteWeb/Controller?opcion=verComandas");
					 menus.put("Comandas", submmenus);
					 
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
		  
		  else if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("mozo")){
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
					
					submmenus.put("Asignar y Combinar Mesas", "/TPO_AD2017_ClienteWeb/Controller?opcion=mesas");
					submmenus.put("Ver todas las Mesas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verMesas");
					
						 menus.put("Mesas", submmenus);
			      
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
        	 else if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("caja")){
   			  out.print("<a>Hola "+session.getAttribute("usuario")+"!</a>");
   			  submmenus = new HashMap<String,String>();
  			
   			 submmenus.put("Ver Facturas", "/TPO_AD2017_ClienteWeb/Controller?opcion=verFacturas");
			 submmenus.put("Facturar Mesa", "/TPO_AD2017_ClienteWeb/Controller?opcion=facturarMesa");
					
			 menus.put("Facturas", submmenus);
   					 
			 
			 submmenus = new HashMap<String,String>();
				
			 submmenus.put("Comisiones", "/TPO_AD2017_ClienteWeb/Controller?opcion=comisiones");
			 submmenus.put("Cerrar", "/TPO_AD2017_ClienteWeb/Controller?opcion=cerrarCaja");				
			 menus.put("Caja", submmenus);
			 
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
		  else {
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?mensaje=Afuera");
    		rd.forward(request, response);
        	
        }
        
 %>
       

 <li><a href="/TPO_AD2017_ClienteWeb/Controller?opcion=logout">Salir</a></li>


    </ul>
    </nav>
</body>
</html>
                