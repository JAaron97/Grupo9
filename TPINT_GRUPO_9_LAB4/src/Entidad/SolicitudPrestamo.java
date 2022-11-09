package Entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolicitudPrestamo {

	private int ID;
	private String DNICliente;
	private BigDecimal ImportePedido;
	private NumeroCuotas NumeroCuotas;
	private String CuentaDestinataria;
	private LocalDate Fecha;
	private int Estado;
	
	
	public SolicitudPrestamo(int id, String dnicliente,BigDecimal importepedido, NumeroCuotas numerocuotas,String numerocuenta,LocalDate fecha,int estado) {
		
		this.ID = id;
		this.DNICliente = dnicliente;
		this.ImportePedido = importepedido;
		this.NumeroCuotas = numerocuotas;
		this.CuentaDestinataria = numerocuenta;
		this.Fecha = fecha;
		this.Estado = estado;
		
		
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


	public BigDecimal getImportePedido() {
		return ImportePedido;
	}


	public void setImportePedido(BigDecimal importePedido) {
		ImportePedido = importePedido;
	}


	public NumeroCuotas getNumeroCuotas() {
		return NumeroCuotas;
	}


	public void setNumeroCuotas(NumeroCuotas numeroCuotas) {
		NumeroCuotas = numeroCuotas;
	}


	public String getCuentaDestinataria() {
		return CuentaDestinataria;
	}


	public void setCuentaDestinataria(String numeroCuenta) {
		CuentaDestinataria = numeroCuenta;
	}


	public LocalDate getFecha() {
		return Fecha;
	}


	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}


	public int getEstado() {
		return Estado;
	}


	public void setEstado(int estado) {
		Estado = estado;
	}


	@Override
	public String toString() {
		return ID + " - " + DNICliente + " - " + ImportePedido + " - " + NumeroCuotas + " - " + CuentaDestinataria + " - " + Fecha + " - " + Estado;
	}
	
	
	
	
	
	
	
}
