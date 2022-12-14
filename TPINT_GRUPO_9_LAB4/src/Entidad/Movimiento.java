package Entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimiento {
	
		private String ID;
		private LocalDate Fecha;
		private TipoMovimiento TipoMovimiento;
		private BigDecimal Importe;
		private String NumeroCuentaOrigen;
		private String NumeroCuentaDestino;
		
		public Movimiento() {}
		
		public Movimiento(String id, LocalDate fecha, TipoMovimiento tipomovimiento, BigDecimal importe, String numerocuentaorigen, String numerocuentadestino) {
			
			this.ID = id;
			this.Fecha = fecha;
			this.TipoMovimiento = tipomovimiento;
			this.Importe = importe;
			this.NumeroCuentaOrigen = numerocuentaorigen;
			this.NumeroCuentaDestino = numerocuentadestino;
			
		}


		public String getID() {
			return ID;
		}


		public void setID(String iD) {
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Fecha == null) ? 0 : Fecha.hashCode());
			result = prime * result + ((ID == null) ? 0 : ID.hashCode());
			result = prime * result + ((Importe == null) ? 0 : Importe.hashCode());
			result = prime * result + ((NumeroCuentaDestino == null) ? 0 : NumeroCuentaDestino.hashCode());
			result = prime * result + ((NumeroCuentaOrigen == null) ? 0 : NumeroCuentaOrigen.hashCode());
			result = prime * result + ((TipoMovimiento == null) ? 0 : TipoMovimiento.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Movimiento other = (Movimiento) obj;
			if (Fecha == null) {
				if (other.Fecha != null)
					return false;
			} else if (!Fecha.equals(other.Fecha))
				return false;
			if (ID == null) {
				if (other.ID != null)
					return false;
			} else if (!ID.equals(other.ID))
				return false;
			if (Importe == null) {
				if (other.Importe != null)
					return false;
			} else if (!Importe.equals(other.Importe))
				return false;
			if (NumeroCuentaDestino == null) {
				if (other.NumeroCuentaDestino != null)
					return false;
			} else if (!NumeroCuentaDestino.equals(other.NumeroCuentaDestino))
				return false;
			if (NumeroCuentaOrigen == null) {
				if (other.NumeroCuentaOrigen != null)
					return false;
			} else if (!NumeroCuentaOrigen.equals(other.NumeroCuentaOrigen))
				return false;
			if (TipoMovimiento == null) {
				if (other.TipoMovimiento != null)
					return false;
			} else if (!TipoMovimiento.equals(other.TipoMovimiento))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return ID + " - " + Fecha + " - " + TipoMovimiento + " - " + Importe + " - " + NumeroCuentaOrigen + " - " + NumeroCuentaDestino;
		}	

}
