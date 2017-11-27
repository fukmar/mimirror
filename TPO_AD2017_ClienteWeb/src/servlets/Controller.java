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

import bd.BusinessDelegate;
import dto.ComandaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlatoDTO;
import dto.ReservaDTO;
import dto.SectorDTO;
import exceptions.ComandaException;
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
			RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
			rd.forward(request, response);
		}
		else {
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
			
			List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
			List<MozoDTO> mozos = new ArrayList<MozoDTO>();
			List<SectorDTO> sectores = new ArrayList<SectorDTO>();
			List<MesaDTO> mesas = new ArrayList<MesaDTO>();
			
			
			try {
				platos = BusinessDelegate.getInstance().listarPlatos();
				request.setAttribute("platos", platos);
			} catch (PlatoException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				mozos = BusinessDelegate.getInstance().mostrarMozos();
				request.setAttribute("mozos", mozos);
			} catch (MozoException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				sectores = BusinessDelegate.getInstance().mostrarSectores();
				request.setAttribute("sectores", sectores);
			} catch (SectorException e) {
				System.out.println(e.getMessage());
			}
			
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
