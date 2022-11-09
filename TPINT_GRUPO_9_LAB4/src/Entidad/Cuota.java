package Entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cuota {
	
	private int ID;
	private int IDPrestamo;
	private BigDecimal Importe;
	private int EstadoPago;
	private LocalDate Fecha;
	
	
	public Cuota(int id, int idprestamo, BigDecimal importe, int estadopago,LocalDate fecha) {
		
		this.ID = id;
		this.IDPrestamo = idprestamo;
		this.Importe = importe;
		this.EstadoPago = estadopago;
		this.Fecha = fecha;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getIDPrestamo() {
		return IDPrestamo;
	}


	public void setIDPrestamo(int iDPrestamo) {
		IDPrestamo = iDPrestamo;
	}


	public BigDecimal getImporte() {
		return Importe;
	}


	public void setImporte(BigDecimal importe) {
		Importe = importe;
	}


	public int getEstadoPago() {
		return EstadoPago;
	}


	public void setEstadoPago(int estadoPago) {
		EstadoPago = estadoPago;
	}


	public LocalDate getFecha() {
		return Fecha;
	}


	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}


	@Override
	public String toString() {
		return ID + " - " + IDPrestamo + " - " + Importe + " - " + EstadoPago + " - " + Fecha;
	}
	
	
	
	
	

}
