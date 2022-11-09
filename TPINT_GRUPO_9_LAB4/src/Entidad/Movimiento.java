package Entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimiento {
	
		private int ID;
		private LocalDate Fecha;
		private TipoMovimiento TipoMovimiento;
		private BigDecimal Importe;
		private String NumeroCuentaOrigen;
		private String NumeroCuentaDestino;
		
		
		public Movimiento(int id, LocalDate fecha, TipoMovimiento tipomovimiento, BigDecimal importe, String numerocuentaorigen, String numerocuentadestino) {
			
			this.ID = id;
			this.Fecha = fecha;
			this.TipoMovimiento = tipomovimiento;
			this.Importe = importe;
			this.NumeroCuentaOrigen = numerocuentaorigen;
			this.NumeroCuentaDestino = numerocuentadestino;
			
		}


		public int getID() {
			return ID;
		}


		public void setID(int iD) {
			ID = iD;
		}


		public LocalDate getFecha() {
			return Fecha;
		}


		public void setFecha(LocalDate fecha) {
			Fecha = fecha;
		}


		public TipoMovimiento getTipoMovimiento() {
			return TipoMovimiento;
		}


		public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
			TipoMovimiento = tipoMovimiento;
		}


		public BigDecimal getImporte() {
			return Importe;
		}


		public void setImporte(BigDecimal importe) {
			Importe = importe;
		}


		public String getNumeroCuentaOrigen() {
			return NumeroCuentaOrigen;
		}


		public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
			NumeroCuentaOrigen = numeroCuentaOrigen;
		}


		public String getNumeroCuentaDestino() {
			return NumeroCuentaDestino;
		}


		public void setNumeroCuentaDestino(String numeroCuentaDestino) {
			NumeroCuentaDestino = numeroCuentaDestino;
		}


		@Override
		public String toString() {
			return ID + " - " + Fecha + " - " + TipoMovimiento + " - " + Importe + " - " + NumeroCuentaOrigen + " - " + NumeroCuentaDestino;
		}
		
		
		

}
