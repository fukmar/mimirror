package negocio;
import java.util.*;

import entities.AreaRestaurantEntity;
import entities.IngredienteEntity;
import entities.MateriaPrimaEntity;
import entities.SolicitudDiariaEntity;
import entities.SolicitudInsumoEntity;
public class SolicitudDiaria extends SolicitudInsumo {
	private static final long serialVersionUID = 1L;
	
	private List<Ingrediente> ingredientes;
	
	public SolicitudDiaria(){
		
	}
	
	public SolicitudDiaria(Integer codSolicitudInsumo,Integer cantidadAPedir, MateriaPrima materiaPrima, AreaRestaurant area, String responsable,
			Integer lote, Date fechaCompra, Date fechaVencimiento, String motivo, List<Ingrediente> ingredientes) {
		super(codSolicitudInsumo,cantidadAPedir, materiaPrima, area, responsable, lote, fechaCompra, fechaVencimiento, motivo);
		this.ingredientes=ingredientes;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public SolicitudInsumoEntity toEntity() {
		
		List<IngredienteEntity> ingrediens=new ArrayList<IngredienteEntity>();
		for(Ingrediente inEn:this.ingredientes) {
			ingrediens.add(inEn.toEntity());
		}
		SolicitudDiariaEntity solicitud = new SolicitudDiariaEntity(this.codSolicitudInsumo, this.cantidadAPedir, this.materiaPrima.toEntity(), this.area.toEntity(), this.responsable, this.lote, this.fechaCompra, this.fechaVencimiento, this.motivo, ingrediens);
		// TODO Auto-generated method stub
		return solicitud;
	}


	
}
