
<%@ page import=" java.util.*" %>
<%      
    HashMap<String,HashMap<String,String>> menus = new HashMap<String,HashMap<String,String>>();
    HashMap<String,String> submmenus;
    HashMap<String,String> submmenus2;
 %>
    <ul id="menu">
 <%

 %>
        <li><a href="index.jsp">Inicio</a></li>
 <%          
        
 		 submmenus = new HashMap<String,String>();
			 submmenus.put("Ver Platos", "/TPO_AD2017_ClienteWeb/Controller?opcion=verPlatos");
			 menus.put("Platos", submmenus);
            
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
                <li><a href="<%=subMenuAction%>"><%=subMenuName%></a></li>
 <%
            }
 %>
            </ul>
        </li>
 <%        
        }
 %>
       
 
    </ul>

                