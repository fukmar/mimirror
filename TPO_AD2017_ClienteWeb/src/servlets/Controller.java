package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bd.BusinessDelegate;
import dto.ComandaDTO;
import dto.FacturaDTO;
import dto.ItemComandaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SectorDTO;
import enumns.Estado;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlatoException;
import exceptions.ReservaException;
import exceptions.SectorException;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if(opcion == null){
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		else {
<<<<<<< HEAD
			
			
				if(opcion.equals("login")){
				
					String usuario = request.getParameter("usuario");
					String clave = request.getParameter("clave");
					Boolean ok = false;
					//try {
						//ok = BusinessDelegate.getInstance().verificarPassword(usuario, clave); ESTO NO ANDA AUN
						ok = true;
						
					//} catch (UsuarioException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					//}
					if (ok) {
						 HttpSession session=request.getSession();  
					     session.setAttribute("usuario",usuario);  
						 RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
						 rd.forward(request, response);
					} else
					{
						 RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?mensaje=Usuario o Clave Incorrectos");
						 rd.forward(request, response);
						
					}
				}
				
				if(opcion.equals("logout")){
					
					HttpSession session=request.getSession();  
		            session.invalidate();    
		            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
					}
				
				
				
			
			
=======
>>>>>>> a7b9622a85516367a79c8ab3f0e3bcfb15dd8e7b
			if(opcion.equals("verPlatos")){
				
				List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
				try {
					platos = BusinessDelegate.getInstance().listarPlatos();
					request.setAttribute("platos", platos);
					RequestDispatcher rd = request.getRequestDispatcher("/verPlatos.jsp");
					rd.forward(request, response);
				} catch (PlatoException e) {
					System.out.println(e.getMessage());
				}

			}
		
		if(opcion.equals("verReservas")){
			
			List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
			try {
				reservas = BusinessDelegate.getInstance().mostrarReservas();
				request.setAttribute("reservas", reservas);
				RequestDispatcher rd = request.getRequestDispatcher("/verReservas.jsp");
				rd.forward(request, response);
			} catch (ReservaException e) {
				System.out.println(e.getMessage());
			}

		}
		
		
		if(opcion.equals("verFacturas")){
			
			List<FacturaDTO> facturas = new ArrayList<FacturaDTO>();
			try {
				facturas = BusinessDelegate.getInstance().mostrarFacturas();
				request.setAttribute("facturas", facturas);
				RequestDispatcher rd = request.getRequestDispatcher("/verFacturas.jsp");
				rd.forward(request, response);
			} catch (FacturaException e) {
				System.out.println(e.getMessage());
			}

		}
		

		if(opcion.equals("cargarReserva")){
			String nombre = request.getParameter("nombre");
			String startDateStr = request.getParameter("fecha");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//surround below line with try catch block as below code throws checked exception
			Date startDate = null;
			try {
				startDate = sdf.parse(startDateStr);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
			ReservaDTO reserva = new ReservaDTO(nombre,startDate,cantidad);
			try {
			
				BusinessDelegate.getInstance().grabarReserva(reserva);
				
			} catch (ReservaException e) {
				System.out.println(e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verReservas");
			rd.forward(request, response);
		}
		
		if(opcion.equals("verComandas")){
			
			List<ComandaDTO> comandas = new ArrayList<ComandaDTO>();
			try {
				comandas = BusinessDelegate.getInstance().mostrarComandas();
				
				request.setAttribute("comandas", comandas);
				RequestDispatcher rd = request.getRequestDispatcher("/verComandas.jsp");
				rd.forward(request, response);
			} catch (ComandaException e) {
				System.out.println(e.getMessage());
			}

		}
		
		if(opcion.equals("verDatosParaCargarComanda")){
			
				List<MesaDTO> mesas = new ArrayList<MesaDTO>();
			
			
			try {
				mesas = BusinessDelegate.getInstance().mostrarMesas();
				request.setAttribute("mesas", mesas);
			} catch (MesaException e) {
				System.out.println(e.getMessage());
			}
			
			request.setAttribute("datosParaComanda", "listos");
			RequestDispatcher rd = request.getRequestDispatcher("/cargarComanda.jsp");
			rd.forward(request, response);

		}
		
		if(opcion.equals("agregarItemsComanda")){
			
			Integer id_mesa = Integer.parseInt(request.getParameter("mesa"));
			
			MesaDTO mesa = new MesaDTO();
			
			try {
				mesa = BusinessDelegate.getInstance().BuscarMesaPorCod(id_mesa);
			} catch (MesaException e) {
				System.out.println(e.getMessage());
			}
			
			ComandaDTO comanda = new ComandaDTO(mesa.getMozo(),mesa,Estado.EnProceso);
			
			try {
			  BusinessDelegate.getInstance().grabarComanda(comanda);
			
			} catch (ComandaException e) {
				System.out.println(e.getMessage());
			}
			
			request.setAttribute("comanda", comanda);
			
			List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
			try {
				platos = BusinessDelegate.getInstance().listarPlatos();
				
			} catch (PlatoException e) {
				System.out.println(e.getMessage());
			}
			
			request.setAttribute("platos", platos);
			request.setAttribute("vamosACargarItems", "listos");
			RequestDispatcher rd = request.getRequestDispatcher("/agregarItemAComanda.jsp");
			rd.forward(request, response);
	}
		
if(opcion.equals("agregarItemsComanda_2step")){
			
	Integer codComanda = Integer.parseInt(request.getParameter("codComanda"));
	Integer codPlato = Integer.parseInt(request.getParameter("codPlato"));
		Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
			
		String accion = request.getParameter("boton");
			
		ComandaDTO comanda = new ComandaDTO();
			PlatoDTO plato = new PlatoDTO();
			
			
			try {
				comanda = BusinessDelegate.getInstance().BuscarComandasPorCod(codComanda);
			} catch (ComandaException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				plato = BusinessDelegate.getInstance().BuscarPlatoPorCod(codPlato);
				
			} catch (PlatoException e) {
				System.out.println(e.getMessage());
			}
			
			//ItemComandaDTO itemComanda = new ItemComandaDTO(cantidad,plato,comanda);
			
		/*	try {
				comanda = BusinessDelegate.getInstance().grabarItemComanda(comanda, itemComanda);
			} catch (ComandaException e) {
				System.out.println(e.getMessage());
			}
		*/	
			if (accion == "Aceptar") {
			RequestDispatcher rd = request.getRequestDispatcher("/verComandas.jsp");
			rd.forward(request, response);}
			if (accion == "Otro") {
				
				List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
				try {
					platos = BusinessDelegate.getInstance().listarPlatos();
					
				} catch (PlatoException e) {
					System.out.println(e.getMessage());
				}
				
				request.setAttribute("platos", platos);
				request.setAttribute("comanda", comanda);
				request.setAttribute("vamosACargarItems", "listos");
				RequestDispatcher rd = request.getRequestDispatcher("/agregarItemAComanda.jsp");
				rd.forward(request, response);rd.forward(request, response);}
				
			
	}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
