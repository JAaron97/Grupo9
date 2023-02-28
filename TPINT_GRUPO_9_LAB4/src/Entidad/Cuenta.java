package Entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cuenta {
	
	private String NumeroCuenta;
	private String DNICliente;
	private LocalDate FechaCreacion;
	private TipoCuenta TipoCuenta;
	private String CBU;
	private BigDecimal Saldo;
	private int Estado;
	
	public Cuenta() {}
	
	public Cuenta(String numerocuenta ,String dnicliente ,LocalDate fechacreacion, TipoCuenta tipocuenta, String cbu , BigDecimal saldo, int estado) {
		
		this.NumeroCuenta = numerocuenta;
		this.DNICliente = dnicliente;
		this.FechaCreacion = fechacreacion;
		this.TipoCuenta = tipocuenta;
		this.CBU = cbu;
		this.Saldo = saldo;
		this.Estado = estado;
	}

	public String getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(String numero_Cuenta) {
		NumeroCuenta = numero_Cuenta;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public void setDNICliente(String dNI_Cliente) {
		DNICliente = dNI_Cliente;
	}

	public LocalDate getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(LocalDate fecha_Creacion) {
		FechaCreacion = fecha_Creacion;
	}

	public TipoCuenta getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public BigDecimal getSaldo() {
		return Saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		Saldo = saldo;
	}

	@Override
	public String toString() {
		return NumeroCuenta + " - " + DNICliente + " - " + FechaCreacion + " - " + TipoCuenta + " - " + CBU + " - " + Saldo;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
}
