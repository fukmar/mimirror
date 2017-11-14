package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BusinessDelegate;

import dto.PlatoDTO;
import exceptions.PlatoException;


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
			RequestDispatcher rd = request.getRequestDispatcher("/Menu.jsp");
			rd.forward(request, response);
		}
		else
			if(opcion.equals("platos")){
				
				List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
				try {
					platos = BusinessDelegate.getInstance().listarPlatos();
					request.setAttribute("platos", platos);
					RequestDispatcher rd = request.getRequestDispatcher("/Form_PanelPlatos.jsp");
					rd.forward(request, response);
				} catch (PlatoException e) {
					System.out.println(e.getMessage());
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
