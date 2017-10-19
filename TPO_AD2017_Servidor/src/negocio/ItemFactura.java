package negocio;

public class ItemFactura {

		private Integer codItemFactura;
		private Comanda comanda;
		
		public ItemFactura(Integer codItemFactura, Comanda comanda) {
			super();
			this.codItemFactura = codItemFactura;
			this.comanda = comanda;
		}

		public Integer getCodItemFactura() {
			return codItemFactura;
		}

		public void setCodItemFactura(Integer codItemFactura) {
			this.codItemFactura = codItemFactura;
		}

		public Comanda getComanda() {
			return comanda;
		}

		public void setComanda(Comanda comanda) {
			this.comanda = comanda;
		}
		
		
		
}
