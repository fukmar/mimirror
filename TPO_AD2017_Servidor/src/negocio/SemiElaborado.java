package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.MateriaPrimaDTO;
import dto.SemiElaboradoDTO;
import entities.*;


public class SemiElaborado extends Producto
{
	private Unidad unidad;
		
	public SemiElaborado (){}
	
	
	public SemiElaborado(String tipo, String calidad, String descripcion, Integer cantidad, Date caducidad,Unidad unidad) 
	{
		super(tipo, calidad, descripcion, cantidad, caducidad);
		this.unidad = unidad;
	
	}



	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	/* ya que tambien puede existir un toEntity heredado del padre ,
	 * a la funcion que viene le pongo otro nombre*/
	 
	public SemiElaboradoEntity toEntitySemi() {
		SemiElaboradoEntity semi=new SemiElaboradoEntity();
		semi.setCaducidad(caducidad);
		semi.setCalidad(calidad);
		semi.setCantidad(cantidad);
		semi.setDescripcion(descripcion);
		semi.setTipo(tipo);
		semi.setUnidad(unidad.toEntity());
		return semi;
	}
	public SemiElaboradoDTO toDTO() {
		SemiElaboradoDTO semi=new SemiElaboradoDTO();
		semi.setCaducidad(caducidad);
		semi.setCalidad(calidad);
		semi.setCantidad(cantidad);
		semi.setDescripcion(descripcion);
		semi.setTipo(tipo);
		semi.setUnidad(unidad.toDTO());
		return semi;
	}

}
