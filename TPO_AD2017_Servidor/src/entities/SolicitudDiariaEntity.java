package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.*;

import negocio.AreaRestaurant;
import negocio.Ingrediente;
import negocio.MateriaPrima;
import negocio.SolicitudDiaria;
import negocio.SolicitudInsumo;
@Entity
@Table(name="solicitudesDiarias")
public class SolicitudDiariaEntity extends SolicitudInsumoEntity {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="solicitud",cascade=CascadeType.ALL)
	private List<IngredienteEntity> ingredientes;
	
	public SolicitudDiariaEntity() {
		// TODO Auto-generated constructor stub
	}

	public SolicitudDiariaEntity(Integer codSolicitudInsumo,Integer cantidadAPedir, MateriaPrimaEntity materiaPrima, AreaRestaurantEntity area,
			String responsable, Integer lote, Date fechaCompra, Date fechaVencimiento, String motivo,List<IngredienteEntity> ingredientes) {
		super(codSolicitudInsumo,cantidadAPedir, materiaPrima, area, responsable, lote, fechaCompra, fechaVencimiento, motivo);
		this.ingredientes=ingredientes;
		// TODO Auto-generated constructor stub
	}

	public List<IngredienteEntity> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredienteEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	@Override
	public SolicitudInsumo toNegocio() {
		
		List<Ingrediente> ingrediens=new ArrayList<Ingrediente>();
		for(IngredienteEntity inEn:this.ingredientes) {
			ingrediens.add(inEn.toNegocio());
		}
		
		SolicitudDiaria solicitud=new SolicitudDiaria(this.codSolicitudInsumo
		, this.cantidadAPedir, this.materiaPrima.toNegocio(), this.area.toNegocio()
		, this.responsable, this.lote, this.fechaCompra, this.fechaVencimiento, this.motivo, ingrediens);
		return solicitud;
	}
	
	
}
