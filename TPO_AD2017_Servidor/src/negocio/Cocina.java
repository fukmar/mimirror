package negocio;

import java.util.*;

import enumns.AreaRest;


public class Cocina extends AreaRestaurant {

	private List<Plato> platos;
	private Date horasPrepInternas;
	private List<SemiElaborado> semiElaborados;
	private List<Producto> estimadoDiario;
	
	
	public Cocina(Integer codArea, AreaRest area, List<Plato> platos,
			Date horasPrepInternas, List<SemiElaborado> semiElaborados,
			List<Producto> estimadoDiario) {
		super(area);
		this.platos = platos;
		this.horasPrepInternas = horasPrepInternas;
		this.semiElaborados = semiElaborados;
		this.estimadoDiario = estimadoDiario;
	}
	
	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public Date getHorasPrepInternas() {
		return horasPrepInternas;
	}

	public void setHorasPrepInternas(Date horasPrepInternas) {
		this.horasPrepInternas = horasPrepInternas;
	}

	public List<SemiElaborado> getSemiElaborados() {
		return semiElaborados;
	}

	public void setSemiElaborados(List<SemiElaborado> semiElaborados) {
		this.semiElaborados = semiElaborados;
	}

	public List<Producto> getEstimadoDiario() {
		return estimadoDiario;
	}

	public void setEstimadoDiario(List<Producto> estimadoDiario) {
		this.estimadoDiario = estimadoDiario;
	}

	public Cocina(){
	}
	
	
	
	
}
