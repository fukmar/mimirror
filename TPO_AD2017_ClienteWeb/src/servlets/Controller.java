package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bd.BusinessDelegate;
import dto.CartaDTO;
import dto.ComandaDTO;
import dto.CombinadorDTO;
import dto.DepositoDTO;
import dto.FacturaDTO;
import dto.ItemComandaDTO;
import dto.ItemFacturaDTO;
import dto.ItemPlanProduccionDTO;
import dto.ItemRemitoDTO;
import dto.MateriaPrimaDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PlanDeProduccionDTO;
import dto.PlatoDTO;
import dto.RemitoDTO;
import dto.ReservaDTO;
import dto.SectorDTO;
import dto.SemiElaboradoDTO;
import dto.SolicitudIndividualDTO;
import enumns.AreaRest;
import enumns.CategoriaPlato;
import enumns.Estado;
import enumns.EstadoItemComanda;
import enumns.EstadoRemito;
import enumns.EstadoSolicitud;
import enumns.MedioDePago;
import exceptions.CajaException;
import exceptions.CartaException;
import exceptions.ComandaException;
import exceptions.FacturaException;
import exceptions.MateriaPrimaException;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.PlanDeProduccionException;
import exceptions.PlatoException;
import exceptions.RemitoException;
import exceptions.ReservaException;
import exceptions.SectorException;
import exceptions.SemiElaboradoException;
import exceptions.SolicitudException;
import exceptions.UsuarioException;
import exceptions.itemComandaException;
import exceptions.itemPlanDeProduccionException;
import exceptions.itemRemitoException;



/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
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

			 HttpSession session=request.getSession();  
				
			
				if(opcion.equals("login")){
				
					String usuario = request.getParameter("usuario");
					String clave = request.getParameter("clave");
					Boolean ok = false;
					try {
						ok = BusinessDelegate.getInstance().verificarPassword(usuario, clave); 
						
						
					} catch (UsuarioException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (ok) {
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
					
					session.invalidate();    
		            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
					}
				
				if(opcion.equals("cargarArchivo")){
					
					String descripcion = request.getParameter("descripcion"); 
				    Part filePart = request.getPart("archivo");
				    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				    InputStream fileContent = filePart.getInputStream();
				    int read = 0;
			        final byte[] bytes = new byte[1024];

			        while ((read = fileContent.read(bytes)) != -1) {
			            System.out.write(bytes, 0, read);
			        }
			        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
									}
			 	
			
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
			
	if(opcion.equals("sugerirPlatos")){
				
				List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
				try {
					String nombre = request.getParameter("nombre"); 
					String categoriaplato = request.getParameter("categoriaplato"); 
					  
					
					CategoriaPlato categoria = null;
					
					switch(categoriaplato){  
					case "Carnes": categoria = CategoriaPlato.Carnes;break;  
				    case "Bebida": categoria = CategoriaPlato.Bebida;break;  
				    case "Pollo": categoria = CategoriaPlato.Pollo;break;  
				    case "Pescado": categoria = CategoriaPlato.Pescado;break;  
				    case "Postres": categoria = CategoriaPlato.Postres;break;  
				    case "Vegetariano": categoria = CategoriaPlato.Vegetariano;break;  
				    case "EspecialdelDia": categoria = CategoriaPlato.EspecialdelDia;break;  
				    case "Vinos": categoria = CategoriaPlato.Vinos;break;  
				
				    default:categoria = CategoriaPlato.Carnes;
				    }  
					
					platos = BusinessDelegate.getInstance().BuscarPlatosparecidos(nombre, categoria);
					request.setAttribute("platos", platos);
					RequestDispatcher rd = request.getRequestDispatcher("/sugiero.jsp");
					rd.forward(request, response);
				} catch (PlatoException e) {
					System.out.println(e.getMessage());
				}

			}
			
	
	if(opcion.equals("verRemitos")){
		
		List<RemitoDTO> remitos = new ArrayList<RemitoDTO>();
		try {
			remitos = BusinessDelegate.getInstance().mostrarRemitos();
			request.setAttribute("remitos", remitos);
			RequestDispatcher rd = request.getRequestDispatcher("/verRemitos.jsp");
			rd.forward(request, response);
		} catch (RemitoException e) {
			System.out.println(e.getMessage());
		}

	}
	
			
	if(opcion.equals("verMP")){
		
		List<MateriaPrimaDTO> materiales = new ArrayList<MateriaPrimaDTO>();
		
			try {
				materiales = BusinessDelegate.getInstance().listarStock();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("materiales", materiales);
			RequestDispatcher rd = request.getRequestDispatcher("/verMP.jsp");
			rd.forward(request, response);
		
		

	}
	
	
if(opcion.equals("verMesas")){
				
				List<MesaDTO> mesas = new ArrayList<MesaDTO>();
				try {
					mesas = BusinessDelegate.getInstance().mostrarMesas();
					request.setAttribute("mesas", mesas);
					RequestDispatcher rd = request.getRequestDispatcher("/verMesas.jsp");
					rd.forward(request, response);
				
				} catch (MesaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

}


if(opcion.equals("verCartas")){
	
	List<CartaDTO> cartas = new ArrayList<CartaDTO>();
	try {
		cartas = BusinessDelegate.getInstance().mostrarCartas();
	} catch (CartaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("cartas", cartas);
	RequestDispatcher rd = request.getRequestDispatcher("/verCartas.jsp");
	rd.forward(request, response);

}

if(opcion.equals("verDetalleCarta")){
	
	String cartaelegida = request.getParameter("cartaelegida"); 
	List<PlatoDTO> items = new ArrayList<PlatoDTO>();

	try {
		items = BusinessDelegate.getInstance().obtenerPlatosByCodCarta(Integer.parseInt(cartaelegida));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (CartaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("items", items);
	RequestDispatcher rd = request.getRequestDispatcher("/verDetalleCarta.jsp");
	rd.forward(request, response);

}
			

if(opcion.equals("verPdPs")){
	
	List<PlanDeProduccionDTO> pdps = new ArrayList<PlanDeProduccionDTO>();
	
		try {
			pdps = BusinessDelegate.getInstance().mostrarPDPs();
		} catch (PlanDeProduccionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	request.setAttribute("pdps", pdps);
	RequestDispatcher rd = request.getRequestDispatcher("/verPdP.jsp");
	rd.forward(request, response);

}

if(opcion.equals("verDetallePdP")){
	
	String pdpelegido = request.getParameter("pdpelegido"); 
	PlanDeProduccionDTO pdp = null;
	try {
		 pdp = BusinessDelegate.getInstance().obtenerPDPByCodPDP(Integer.parseInt(pdpelegido));
	} catch (NumberFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (PlanDeProduccionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	List<ItemPlanProduccionDTO> items = new ArrayList<ItemPlanProduccionDTO>();
		try {
			items = BusinessDelegate.getInstance().obtenerItemPDPByCodPDP(Integer.parseInt(pdpelegido));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (itemPlanDeProduccionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	request.setAttribute("items", items);
	request.setAttribute("pdp", pdp);
	
	RequestDispatcher rd = request.getRequestDispatcher("/verDetallePdP.jsp");
	rd.forward(request, response);

}

			if(opcion.equals("mesas")){
				
				List<MesaDTO> mesas = new ArrayList<MesaDTO>();
				try {
					mesas = BusinessDelegate.getInstance().mostrarMesasLibres();
					request.setAttribute("mesas", mesas);
					RequestDispatcher rd = request.getRequestDispatcher("/mesas.jsp");
					rd.forward(request, response);
				
				} catch (MesaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
if(opcion.equals("ocuparMesa")){
	 
	String[] mesa = request.getParameterValues("mesaelegida[]");
	
	try {
		System.out.println(mesa[0]);
		BusinessDelegate.getInstance().ocuparMesaPorCod(Integer.parseInt(mesa[0]));
		
		RequestDispatcher rd = request.getRequestDispatcher("/decirMesa.jsp?nuevamesa="+Integer.parseInt(mesa[0]));
		rd.forward(request, response);
		
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MesaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
			}

if(opcion.equals("combinarMesas")){
	 
String[] mesa = request.getParameterValues("mesaelegida[]");
	Integer nuevamesa = 0;
	try {
		nuevamesa = BusinessDelegate.getInstance().combinarMesasPorCod(Integer.parseInt(mesa[0]),Integer.parseInt(mesa[1]));
		RequestDispatcher rd = request.getRequestDispatcher("/decirMesa.jsp?nuevamesa="+nuevamesa);
		rd.forward(request, response);
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MesaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
					
			}
			

if(opcion.equals("facturarMesa")){
	
	List<MesaDTO> mesas = new ArrayList<MesaDTO>();
	try {
		mesas = BusinessDelegate.getInstance().mostrarFacturables();
		request.setAttribute("mesas", mesas);
		RequestDispatcher rd = request.getRequestDispatcher("/facturarMesa.jsp");
		rd.forward(request, response);
	
	} catch (MesaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

if(opcion.equals("facturarMesaYa")){
	
	String mesa = request.getParameter("mesaelegida"); 
	String mpago = request.getParameter("mpago"); 
	MedioDePago medio = null;
	
	switch(mpago){  
    case "contado": medio = MedioDePago.Contado;break;  
    case "debito": medio = MedioDePago.Debito;break;  
    case "credito": medio = MedioDePago.Credito;break;  
    default:medio = MedioDePago.Contado;
    }  
	
	try {
		BusinessDelegate.getInstance().facturarMesa(Integer.parseInt(mesa),medio);
		RequestDispatcher rd = request.getRequestDispatcher("/verFacturas.jsp");
		rd.forward(request, response);
	
	} catch (FacturaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}


if(opcion.equals("verDetalleFactura")){
	
	String facturaelegida = request.getParameter("facturaelegida"); 
	List<ItemFacturaDTO> items = new ArrayList<ItemFacturaDTO>();

	
	try { 
		items = BusinessDelegate.getInstance().obtenerItemsFacturaByCodFactura(Integer.parseInt(facturaelegida));
		request.setAttribute("items", items);
		RequestDispatcher rd = request.getRequestDispatcher("/verDetalleFactura.jsp");
		rd.forward(request, response);
	
	} catch (FacturaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

if(opcion.equals("verComisiones")){
	
	 Date hoy = new Date();
	    Date fechadesde = new Date("01/01/1900");
	    Date fechahasta = new Date("01/01/3000");
	    
	ArrayList<String[]> comisiones = null;
	try {
		comisiones = (ArrayList<String[]>) BusinessDelegate.getInstance().mostrarResultadoComisionesMozo(fechadesde,fechahasta);
	} catch (MozoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		request.setAttribute("comisiones", comisiones);
		RequestDispatcher rd = request.getRequestDispatcher("/verComisiones.jsp");
		rd.forward(request, response);
	
}


if(opcion.equals("cerrarCaja")){
	 double valortotal = 0;
	  Date hoy = new Date();
	  double valorcomi = 0;
	   
	
		try {
			valortotal = BusinessDelegate.getInstance().mostrarTotalFacturadoCaja(hoy, hoy);
		} catch (CajaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("valortotal", truncateDecimal(valortotal,2));
		try {
			valorcomi = BusinessDelegate.getInstance().mostrarComisionesAPagar(hoy, hoy);
		} catch (MozoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("valorcomi", truncateDecimal(valorcomi, 2));
		request.setAttribute("valorfinal", truncateDecimal(valortotal - valorcomi,2));
		RequestDispatcher rd = request.getRequestDispatcher("/cierreCaja.jsp");
		rd.forward(request, response);
	
}

if(opcion.equals("verDetalleComanda")){
	
	String comandaelegida = request.getParameter("comandaelegida"); 
	List<ItemComandaDTO> items = new ArrayList<ItemComandaDTO>();
	ComandaDTO comanda = new ComandaDTO();
	//FALTA EXCEPTIONS
	try {
		comanda = BusinessDelegate.getInstance().BuscarComandasPorCod(Integer.parseInt(comandaelegida));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ComandaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		items = BusinessDelegate.getInstance().obtenerItemsComandaByCodComanda(Integer.parseInt(comandaelegida));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (itemComandaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("items", items);
	request.setAttribute("comanda", comanda);
	
	RequestDispatcher rd = request.getRequestDispatcher("/verDetalleComanda.jsp");
	rd.forward(request, response);

}



if(opcion.equals("listoitemcomanda")){
	
	String itemcomandaelegida = request.getParameter("itemcomandaelegida"); 
	try {
		BusinessDelegate.getInstance().itemComandaLista(Integer.parseInt(itemcomandaelegida));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (itemComandaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	RequestDispatcher rd = request.getRequestDispatcher("Controller?opcion=verComandas");
	rd.forward(request, response);

}

if(opcion.equals("verMozos")){
				
				List<MozoDTO> mozos = new ArrayList<MozoDTO>();
				try {
					mozos = BusinessDelegate.getInstance().mostrarMozos();
					request.setAttribute("mozos", mozos);
					RequestDispatcher rd = request.getRequestDispatcher("/verMozos.jsp");
					rd.forward(request, response);
				} catch (MozoException e) {
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
		
		
		
		if(opcion.equals("solicitudIndividual")){
			List<MateriaPrimaDTO> mps = null;
			try {
				mps = BusinessDelegate.getInstance().listarStock();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("mps", mps);
			RequestDispatcher rd = request.getRequestDispatcher("/solicitudIndividual.jsp");
			rd.forward(request, response);
			
		}
		
		if(opcion.equals("solicitudDiaria")){
			List<SolicitudIndividualDTO> solicitudesIndividuales = null;
			
			try {
				solicitudesIndividuales = BusinessDelegate.getInstance().mostrarSolicitudesIndividuales();
			} catch (SolicitudException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			request.setAttribute("solicitudesIndividuales", solicitudesIndividuales);
			RequestDispatcher rd = request.getRequestDispatcher("/crearSolicitudDiaria.jsp");
			rd.forward(request, response);
			
		}
		
		if(opcion.equals("agregarSolicitudIndividual")){
			String cantidad = request.getParameter("cantidad");
			String responsable = request.getParameter("responsable");
			String motivo = request.getParameter("motivo");
			String codMP = request.getParameter("codMP");
			
				MateriaPrimaDTO mp = null;
			try {
				 mp = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(codMP));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SolicitudIndividualDTO si = null;
			if (session.getAttribute("usuario").equals("admin"))
				si = new SolicitudIndividualDTO(AreaRest.Administracion,responsable,motivo,mp,Float.parseFloat(cantidad),EstadoSolicitud.Recibida);
			if (session.getAttribute("usuario").equals("bar"))
				si = new SolicitudIndividualDTO(AreaRest.Barra,responsable,motivo,mp,Float.parseFloat(cantidad),EstadoSolicitud.Recibida);
			if (session.getAttribute("usuario").equals("cocina"))
				si = new SolicitudIndividualDTO(AreaRest.Cocina,responsable,motivo,mp,Float.parseFloat(cantidad),EstadoSolicitud.Recibida);
				
			try {
				BusinessDelegate.getInstance().grabarSolicitudIndividual(si);
			} catch (SolicitudException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
			rd.forward(request, response);
			
			}
			
		if(opcion.equals("combinarSolicitudesIndividuales")){
			 
			String[] solicitudesIndividuales = request.getParameterValues("solicitudesElegidas[]");
			List<CombinadorDTO> mandar = new ArrayList<CombinadorDTO>();
			for(int i=0;i < solicitudesIndividuales.length;i++) {
				CombinadorDTO comb = new CombinadorDTO(solicitudesIndividuales[i]);
				mandar.add(comb);
			
			}
			
				try {
					BusinessDelegate.getInstance().unirSolicitudesIndividuales(mandar);
				} catch (SolicitudException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
				rd.forward(request, response);
			}
					
									
		if(opcion.equals("cargarRemito")){
			String codigoProveedor = request.getParameter("codigoProveedor");
			String fecha = request.getParameter("fecha");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//surround below line with try catch block as below code throws checked exception
			Date startDate = null;
			try {
				startDate = sdf.parse(fecha);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			request.setAttribute("codigoProveedor", codigoProveedor);
			request.setAttribute("fecha", fecha);
			DepositoDTO deposito = new DepositoDTO(1);
			RemitoDTO remito = new RemitoDTO(Integer.parseInt(codigoProveedor),startDate,deposito,EstadoRemito.EnProceso);
			
			List<RemitoDTO> remitos = new ArrayList<RemitoDTO>();
			
			try {
				BusinessDelegate.getInstance().grabarRemito(remito);
			} catch (RemitoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				remitos = BusinessDelegate.getInstance().mostrarRemitos();
			} catch (RemitoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("remito", remitos.get(remitos.size()-1));
			
			List<MateriaPrimaDTO> mps = null;
			try {
				mps = BusinessDelegate.getInstance().listarStock();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("mps", mps);
			RequestDispatcher rd = request.getRequestDispatcher("/agregarItemARemito.jsp");
			rd.forward(request, response);
		}
		
		
		if(opcion.equals("agregarItemARemito")){
			String cantidad = request.getParameter("cantidad");
			String codMP = request.getParameter("codMP");
			String codRemito = request.getParameter("codRemito");
			String accion2 = request.getParameter("boton");
			
			if (accion2.equals("Aceptar")) {
				MateriaPrimaDTO mp = null;
			try {
				 mp = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(codMP));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			RemitoDTO remito = null;
			
				 try {
					remito = BusinessDelegate.getInstance().getRemitoByCod(Integer.parseInt(codRemito));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemitoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				ItemRemitoDTO itemRem = new ItemRemitoDTO(Float.parseFloat(cantidad),remito,mp);
				
				try {
					BusinessDelegate.getInstance().grabarItemRemito(itemRem);
				} catch (itemRemitoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
				rd.forward(request, response);
				}
				if (accion2.equals("Otro")) {
					
			MateriaPrimaDTO mp = null;
			try {
				mp = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(codMP));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			RemitoDTO remito = null;
			
			 try {
				remito = BusinessDelegate.getInstance().getRemitoByCod(Integer.parseInt(codRemito));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemitoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 
			ItemRemitoDTO itemRem = new ItemRemitoDTO(Float.parseFloat(cantidad),remito,mp);
			try {
				BusinessDelegate.getInstance().grabarItemRemito(itemRem);
			} catch (itemRemitoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<RemitoDTO> remitos = null;
			try {
				remitos = BusinessDelegate.getInstance().mostrarRemitos();
			} catch (RemitoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("remito", remitos.get(remitos.size()-1));
			List<MateriaPrimaDTO> mps = null;
			try {
				mps = BusinessDelegate.getInstance().listarStock();
			} catch (MateriaPrimaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("mps", mps);
			RequestDispatcher rd = request.getRequestDispatcher("/agregarItemARemito.jsp");
			rd.forward(request, response);
		}}
		
		
		
		
		if(opcion.equals("cargarPdP")){
			String estado = request.getParameter("estado");
			String fecha = request.getParameter("fecha");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//surround below line with try catch block as below code throws checked exception
			Date startDate = null;
			try {
				startDate = sdf.parse(fecha);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			DepositoDTO deposito = new DepositoDTO(1);
			List<ItemPlanProduccionDTO> semi = new ArrayList<ItemPlanProduccionDTO>();
			PlanDeProduccionDTO pdp = new PlanDeProduccionDTO(Estado.EnProceso,semi,startDate);
			
			List<PlanDeProduccionDTO> pdps = new ArrayList<PlanDeProduccionDTO>();
			
			
				try {
					BusinessDelegate.getInstance().grabarPdP(pdp);
				} catch (PlanDeProduccionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			try {
				pdps = BusinessDelegate.getInstance().mostrarPDPs();
			} catch (PlanDeProduccionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("pdp", pdps.get(pdps.size()-1));
			
			List<SemiElaboradoDTO> semis = null;
			
			try {
				semis = BusinessDelegate.getInstance().mostrarSemiElaborados();
			} catch (SemiElaboradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("semis", semis);
			RequestDispatcher rd = request.getRequestDispatcher("/agregarItemAPdP.jsp");
			rd.forward(request, response);
		}
		
		
		if(opcion.equals("agregarItemAPdP")){
			String cantidad = request.getParameter("cantidad");
			String codSemi = request.getParameter("codSemi");
			String codPdP = request.getParameter("codPdP");
			String accion2 = request.getParameter("boton");
			
			if (accion2.equals("Aceptar")) {
				SemiElaboradoDTO semi = null;
			
				try {
					semi = BusinessDelegate.getInstance().getSemiElaboradoByCod(Integer.parseInt(codSemi));
				} catch (NumberFormatException | SemiElaboradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				PlanDeProduccionDTO pdp = null;
			
				try {
					pdp = BusinessDelegate.getInstance().obtenerPDPByCodPDP(Integer.parseInt(codPdP));
				} catch (NumberFormatException | PlanDeProduccionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ItemPlanProduccionDTO itemPdP = new ItemPlanProduccionDTO(semi,Integer.parseInt(cantidad),0);
				itemPdP.setPlandeProduccion(pdp);
			
					try {
						BusinessDelegate.getInstance().grabarItemPdP(itemPdP);
					} catch (itemPlanDeProduccionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
				rd.forward(request, response);
				}
				if (accion2.equals("Otro")) {
					
					SemiElaboradoDTO semi = null;
			
					try {
						semi = BusinessDelegate.getInstance().getSemiElaboradoByCod(Integer.parseInt(codSemi));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SemiElaboradoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					PlanDeProduccionDTO pdp = null;
					
					try {
						pdp = BusinessDelegate.getInstance().obtenerPDPByCodPDP(Integer.parseInt(codPdP));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PlanDeProduccionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			 
			 
					ItemPlanProduccionDTO itemPdP = new ItemPlanProduccionDTO(semi,Integer.parseInt(cantidad),0);
					itemPdP.setPlandeProduccion(pdp);
					try {
						BusinessDelegate.getInstance().grabarItemPdP(itemPdP);
					} catch (itemPlanDeProduccionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			List<PlanDeProduccionDTO> pdps = null;
			
				try {
					pdps = BusinessDelegate.getInstance().mostrarPDPs();
				} catch (PlanDeProduccionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			request.setAttribute("pdp", pdps.get(pdps.size()-1));
			List<SemiElaboradoDTO> semis = null;
		
				try {
					semis = BusinessDelegate.getInstance().mostrarSemiElaborados();
				} catch (SemiElaboradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			request.setAttribute("semis", semis);
			RequestDispatcher rd = request.getRequestDispatcher("/agregarItemAPdP.jsp");
			rd.forward(request, response);
		}}
		
		
		
		
		
		
		if(opcion.equals("verComandas")){
			
			 if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("admin"))
			  { 
			
			List<ComandaDTO> comandas = new ArrayList<ComandaDTO>();
			try {
				comandas = BusinessDelegate.getInstance().mostrarComandas();
				
				request.setAttribute("comandas", comandas);
				RequestDispatcher rd = request.getRequestDispatcher("/verComandas.jsp");
				rd.forward(request, response);
			} catch (ComandaException e) {
				System.out.println(e.getMessage());
			}

		}else if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("cocina")) {
			
			List<ItemComandaDTO> items = new ArrayList<ItemComandaDTO>();
		
				try {
					items = BusinessDelegate.getInstance().getItemsPendientesxArea(AreaRest.Cocina);
				} catch (itemComandaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("items", items);
				RequestDispatcher rd = request.getRequestDispatcher("/verMisItems.jsp");
				rd.forward(request, response);
			
				
				
		}else if ((session.getAttribute("usuario") != null) & session.getAttribute("usuario").equals("bar")) {
			
			List<ItemComandaDTO> items = new ArrayList<ItemComandaDTO>();
			
				try {
					items = BusinessDelegate.getInstance().getItemsPendientesxArea(AreaRest.Barra);
				} catch (itemComandaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("items", items);
				RequestDispatcher rd = request.getRequestDispatcher("/verMisItems.jsp");
				rd.forward(request, response);
			
				
		}
		}
		
		if(opcion.equals("verDatosParaCargarComanda")){
			
				List<MesaDTO> mesas = new ArrayList<MesaDTO>();
			
			
			try {
				mesas = BusinessDelegate.getInstance().mostrarMesasOcupadas();
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
			List<ComandaDTO> comandas = new ArrayList<ComandaDTO>();
			
			try {
			  BusinessDelegate.getInstance().grabarComanda(comanda);
			  
			 
				try {
					comandas = BusinessDelegate.getInstance().mostrarComandas();
					request.setAttribute("comandas", comandas);
					
				} catch (ComandaException e) {
					System.out.println(e.getMessage());
				}
			  
			
			} catch (ComandaException e) {
				System.out.println(e.getMessage());
			}
			
			request.setAttribute("comanda", comandas.get(comandas.size()-1));
			
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
			
			boolean ok = true;
			ItemComandaDTO itemComanda = new ItemComandaDTO(cantidad,plato,EstadoItemComanda.Pendiente, comanda);
			itemComanda.setComanda(comanda);
			try {
			 ok = BusinessDelegate.getInstance().grabarItemComanda(itemComanda);
			
			if (!ok) {
				RequestDispatcher rd = request.getRequestDispatcher("/noPodemos.jsp");
				rd.forward(request, response);
				
			}
			
			} catch (itemComandaException e) {
				System.out.println(e.getMessage());
			}
			
			if (accion.equals("Aceptar")) {
			if (ok)
				{RequestDispatcher rd = request.getRequestDispatcher("/verComandas.jsp");
			rd.forward(request, response);}}
			if (accion.equals("Otro")) {
				
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
				rd.forward(request, response);}
				
			
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
