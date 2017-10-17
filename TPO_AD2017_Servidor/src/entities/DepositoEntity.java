package entities;

import java.io.Serializable;
import java.util.List;

import dto.ProductoDTO;

public class DepositoEntity implements Serializable
{
	private List<ProductoDTO> productos;
	private List<SolicitudInsumoEntity> solicitudes;
	private List<RemitoEntity> remitos;
	
}
