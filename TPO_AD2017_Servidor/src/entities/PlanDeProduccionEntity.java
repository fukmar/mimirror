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
	
	public PlanDeProduccionEntity(){}
	
	public PlanDeProduccionEntity(Integer codigoPDP, Estado estado) {
		super();
		this.codigoPDP = codigoPDP;
		this.estado = estado;
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
