package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RemitoDTO implements Serializable
{
	private List<itemRemitoDTO> itemsRemito;
	private Integer codigoProveedor;
	private OrdenDeCompraDTO ordenesDeCompra;
	private Date fecha;
	
}
