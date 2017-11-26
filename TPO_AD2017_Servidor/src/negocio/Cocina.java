package negocio;

import java.util.*;

import dto.AreaRestaurantDTO;
import entities.AreaRestaurantEntity;
import entities.LocalEntity;
import entities.PlatoEntity;
import entities.ProductoEntity;
import entities.SemiElaboradoEntity;
import enumns.AreaRest;


public class Cocina extends AreaRestaurant {

	private List<Plato> platos;
	private Date horasPrepInternas;
	private List<SemiElaborado> semiElaborados;
	private List<Producto> estimadoDiario;
	
	public Cocina(){
	}
	
	
	public Cocina(Integer codArea, AreaRest area, List<Plato> platos,
			Date horasPrepInternas, List<SemiElaborado> semiElaborados,
			List<Producto> estimadoDiario,Local local) {
		super(codArea, area,local);
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


	@Override
	public AreaRestaurantEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AreaRestaurantDTO toDTO() {
		// TODO Auto-generated method stub
		return null;
	}

		
}
