package negocio;

import java.util.Date;

import entities.*;

public class SolicitudPlato extends SolicitudInsumo {

	private static final long serialVersionUID = 1L;
	
	private Ingrediente ingrediente;
	
	public SolicitudPlato(){
		
	}
	
	public SolicitudPlato(Integer codSolicitudInsumo,Integer cantidadAPedir, MateriaPrima materiaPrima, AreaRestaurant area, String responsable,
			Integer lote, Date fechaCompra, Date fechaVencimiento, String motivo,Ingrediente ingrediente) {
		super(codSolicitudInsumo,cantidadAPedir, materiaPrima, area, responsable, lote, fechaCompra, fechaVencimiento, motivo);
		this.ingrediente=ingrediente;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public SolicitudInsumoEntity toEntity() {
		
		SolicitudPlatoEntity solp= new SolicitudPlatoEntity(this.codSolicitudInsumo, this.cantidadAPedir, this.materiaPrima.toEntity(), this.area.toEntity(), this.responsable, this.lote, this.fechaCompra, this.fechaVencimiento, this.motivo, this.ingrediente.toEntity());
		
		// TODO Auto-generated method stub
		return solp;
	}
	
	
	
}
