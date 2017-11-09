package entities;

import javax.persistence.*;

import negocio.Plato;
import negocio.Producto;
import negocio.SemiElaborado;
import enumns.AreaRest;

import java.util.*;


@Entity
@Table(name="cocinas")
public class CocinaEntity extends AreaRestaurantEntity{
	
	
	@OneToMany
	@JoinColumn(name="codPlato")
	private List<PlatoEntity> platos;
	
	
	private Date horasPrepInternas;
	
	@OneToMany
	@JoinColumn(name="codSemiElaborado")
	private List<SemiElaboradoEntity> semiElaborados;
	
	@OneToMany
	@JoinColumn(name="codEstimadoDiario")
	private List<ProductoEntity> estimadoDiario;
	
	
	public CocinaEntity(Integer codArea, AreaRest area, List<PlatoEntity> platos,
			Date horasPrepInternas, List<SemiElaboradoEntity> semiElaborados,
			List<ProductoEntity> estimadoDiario,LocalEntity local) {
		super(codArea, area,local);
		this.platos = platos;
		this.horasPrepInternas = horasPrepInternas;
		this.semiElaborados = semiElaborados;
		this.estimadoDiario = estimadoDiario;
	}
	
	public List<PlatoEntity> getPlatos() {
		return platos;
	}

	public void setPlatos(List<PlatoEntity> platos) {
		this.platos = platos;
	}

	public Date getHorasPrepInternas() {
		return horasPrepInternas;
	}

	public void setHorasPrepInternas(Date horasPrepInternas) {
		this.horasPrepInternas = horasPrepInternas;
	}

	public List<SemiElaboradoEntity> getSemiElaborados() {
		return semiElaborados;
	}

	public void setSemiElaborados(List<SemiElaboradoEntity> semiElaborados) {
		this.semiElaborados = semiElaborados;
	}

	public List<ProductoEntity> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<ProductoEntity> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}

	public CocinaEntity(){
	}
	
	
	
}
