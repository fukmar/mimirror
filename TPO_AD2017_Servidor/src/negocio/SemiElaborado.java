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
	private List<MateriaPrima> materiales;
	private Unidad unidad;
		
	public SemiElaborado (){}
	
	
	public SemiElaborado(String tipo, String calidad, String descripcion, Integer cantidad, Date caducidad, List<MateriaPrima> materiales,Unidad unidad) 
	{
		super(tipo, calidad, descripcion, cantidad, caducidad);
		this.materiales = materiales;
		this.unidad = unidad;
	
	}


	public void setMateriales(List<MateriaPrima> materiales) {
		this.materiales = materiales;
	}

	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	public List<MateriaPrima> getMateriales() {
		return materiales;
	}
	public void setMateriales(ArrayList<MateriaPrima> materiales) {
		this.materiales = materiales;
	}
	
	/* ya que tambien puede existir un toEntity heredado del padre ,
	 * a la funcion que viene le pongo otro nombre*/
	 
	public SemiElaboradoEntity toEntitySemi() {
		SemiElaboradoEntity semi=new SemiElaboradoEntity(this.tipo, this.calidad, this.descripcion, this.cantidad, this.caducidad, this.unidad.toEntity());
		return semi;
	}
	public SemiElaboradoDTO toDTO() {
		SemiElaboradoDTO semi=new SemiElaboradoDTO();
		semi.setCaducidad(caducidad);
		semi.setCalidad(calidad);
		semi.setCantidad(cantidad);
		semi.setDescripcion(descripcion);
		semi.setTipo(tipo);
		List<MateriaPrimaDTO> materialesdto=new ArrayList <MateriaPrimaDTO>();
		for(MateriaPrima material:materiales)
		{
			materialesdto.add(material.toDTO());
		}
		semi.setMateriales(materialesdto);
		semi.setUnidad(unidad.toDTO());
		return semi;
	}

}
