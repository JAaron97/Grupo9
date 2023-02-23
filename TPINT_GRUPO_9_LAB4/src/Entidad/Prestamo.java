package Entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Prestamo {

	private int ID;
	private String DNICliente;
	private SolicitudPrestamo SolicitudPrestamo;
	private String CuentaDestinataria;
	private LocalDate Fecha;
	private BigDecimal ImporteInteres;
	private NumeroCuotas NumeroCuotas;
	
	public Prestamo() {}
	
	public Prestamo(int id,String dnicliente, NumeroCuotas NumeroCuotas, SolicitudPrestamo solicitudprestamo, String cuentadestinataria,LocalDate fecha, BigDecimal importeinteres) {
		
		
		this.ID = id;
		this.DNICliente = dnicliente;
		this.SolicitudPrestamo = solicitudprestamo;
		this.NumeroCuotas = NumeroCuotas;
		this.CuentaDestinataria = cuentadestinataria;
		this.Fecha = fecha;
		this.ImporteInteres = importeinteres;
		
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getDNICliente() {
		return DNICliente;
	}



	public void setDNICliente(String dNICliente) {
		DNICliente = dNICliente;
	}



	public SolicitudPrestamo getSolicitudPrestamo() {
		return SolicitudPrestamo;
	}



	public void setSolicitudPrestamo(SolicitudPrestamo solicitudPrestamo) {
		SolicitudPrestamo = solicitudPrestamo;
	}



	public String getCuentaDestinataria() {
		return CuentaDestinataria;
	}



	public void setCuentaDestinataria(String cuentaDestinataria) {
		CuentaDestinataria = cuentaDestinataria;
	}



	public LocalDate getFecha() {
		return Fecha;
	}



	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}



	public BigDecimal getImporteInteres() {
		return ImporteInteres;
	}



	public void setImporteInteres(BigDecimal importeInteres) {
		ImporteInteres = importeInteres;
	}

	public NumeroCuotas getNumeroCuotas() {
		return NumeroCuotas;
	}

	public void setNumeroCuotas(NumeroCuotas numeroCuotas) {
		NumeroCuotas = numeroCuotas;
	}

	@Override
	public String toString() {
		return ID + " - " + DNICliente + " - " + SolicitudPrestamo + " - " + CuentaDestinataria + " - " + Fecha + " - " + ImporteInteres;
	}
	
	
	
	
	
	
	
}
