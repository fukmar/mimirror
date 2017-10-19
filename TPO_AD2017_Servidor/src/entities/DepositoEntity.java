package entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="deposito")
public class DepositoEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDeposito;
	@OneToMany
	@JoinColumn(name="codProducto")
	private List<ProductoEntity> productos;
	@OneToMany
	@JoinColumn(name="codSolicitud")
	private List<SolicitudInsumoEntity> solicitudes;
	@OneToMany
	@JoinColumn(name="codRemito")
	private List<RemitoEntity> remitos;
	
	public DepositoEntity(){}
	
	public DepositoEntity(List<ProductoEntity> productos, List<SolicitudInsumoEntity> solicitudes,
			List<RemitoEntity> remitos) {
		super();
		this.productos = productos;
		this.solicitudes = solicitudes;
		this.remitos = remitos;
	}

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}

	public List<SolicitudInsumoEntity> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudInsumoEntity> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public List<RemitoEntity> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<RemitoEntity> remitos) {
		this.remitos = remitos;
	}

	public Integer getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(Integer codDeposito) {
		this.codDeposito = codDeposito;
	}
	
	
	
	
}
