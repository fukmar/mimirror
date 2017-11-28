package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SemiElaboradoDTO extends ProductoDTO implements Serializable{

	private UnidadDTO unidad;
			
	public SemiElaboradoDTO (){}
	
	
	public SemiElaboradoDTO(String tipo, String calidad, String descripcion, Integer cantidad, Date caducidad, UnidadDTO unidad) 
	{
		super(tipo, calidad, descripcion, cantidad, caducidad);
		this.unidad = unidad;
	
	}


	public UnidadDTO getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadDTO unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "SemiElaboradoDTO [descripcion=" + descripcion + ", unidad=" + unidad + "]";
	}
	
	
}
