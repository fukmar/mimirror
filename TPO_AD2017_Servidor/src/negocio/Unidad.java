package negocio;

import dao.UnidadDAO;
import dto.UnidadDTO;
import entities.UnidadEntity;

public class Unidad 
{
	private Integer codigoUni;
	private String descripcion;
	
	public Unidad() {}
	
	public Unidad(String descripcion) {
		super();
	
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigoUni;
	}
	public void setCodigo(Integer codigo) {
		this.codigoUni = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public UnidadDTO toDTO() 
	{
		UnidadDTO u=new UnidadDTO();
		u.setCodigo(codigoUni);
		u.setDescripcion(descripcion);
		return u;
	}
	
	public UnidadEntity toEntity() {
		UnidadEntity uni=new UnidadEntity(this.descripcion);
		return uni;
	}
	
	public Unidad obtenerUniPorCod(Integer codigo) {
		Unidad uni=UnidadDAO.getInstance().getUnidadByCod(codigo);
		return uni;
	}

}
