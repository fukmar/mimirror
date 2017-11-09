package entities;

import enumns.Estado;
import javax.persistence.*;

@Entity
@Table(name="PlanesDeProduccion")
public class PlanDeProduccionEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoPDP;
	private Estado estado;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codAdministracion",nullable=false)
	private AdministracionEntity administracion;
	
	
	public PlanDeProduccionEntity(){}
	
	public PlanDeProduccionEntity(Estado estado) {
		super();
		this.estado = estado;
	}
	
	public void setAdministracion(AdministracionEntity ad) {
		this.administracion=ad;
	}
	
	public Integer getCodigoPDP() {
		return codigoPDP;
	}
	public void setCodigoPDP(Integer codigoPDP) {
		this.codigoPDP = codigoPDP;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
