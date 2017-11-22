package entities;

import java.util.Date;

import javax.persistence.*;

import negocio.AreaRestaurant;
import negocio.Ingrediente;
import negocio.MateriaPrima;
import negocio.SolicitudInsumo;
import negocio.SolicitudPlato;

@Entity
@Table(name="solicitudesPlato")
public class SolicitudPlatoEntity extends SolicitudInsumoEntity {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="codIngrediente")
	private IngredienteEntity ingrediente;
	
	
	public SolicitudPlatoEntity(){
		
	}
	
	public SolicitudPlatoEntity(Integer codSolicitudInsumo,Integer cantidadAPedir, MateriaPrimaEntity materiaPrima, AreaRestaurantEntity area,
			String responsable, Integer lote, Date fechaCompra, Date fechaVencimiento, String motivo,IngredienteEntity ingrediente) {
		super(codSolicitudInsumo,cantidadAPedir, materiaPrima, area, responsable, lote, fechaCompra, fechaVencimiento, motivo);
		this.ingrediente=ingrediente;
	
	}

	
	public IngredienteEntity getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteEntity ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public SolicitudInsumo toNegocio() {
		
		SolicitudPlato solp=new SolicitudPlato(this.codSolicitudInsumo, this.cantidadAPedir, this.materiaPrima.toNegocio(), this.area.toNegocio(), this.responsable, this.lote, this.fechaCompra, this.fechaVencimiento, this.motivo, this.ingrediente.toNegocio());
		// TODO Auto-generated method stub
		return solp;
	}
	
	
}
