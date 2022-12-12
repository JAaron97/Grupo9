package Entidad;

import java.time.LocalDate;

public class SolicitudCuenta {
	private int ID;
	private String DNI_Cliente;
	private LocalDate FechaSolicitud;
	private int estadoSolicitud;
	
	public SolicitudCuenta(){}

	public SolicitudCuenta(int iD, String dNI_Cliente, LocalDate fechaSolicitud, int estadoSolicitud) {
		super();
		ID = iD;
		DNI_Cliente = dNI_Cliente;
		FechaSolicitud = fechaSolicitud;
		this.estadoSolicitud = estadoSolicitud;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDNI_Cliente() {
		return DNI_Cliente;
	}

	public void setDNI_Cliente(String dNI_Cliente) {
		DNI_Cliente = dNI_Cliente;
	}

	public LocalDate getFechaSolicitud() {
		return FechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		FechaSolicitud = fechaSolicitud;
	}

	public int getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(int estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI_Cliente == null) ? 0 : DNI_Cliente.hashCode());
		result = prime * result + ((FechaSolicitud == null) ? 0 : FechaSolicitud.hashCode());
		result = prime * result + ID;
		result = prime * result + estadoSolicitud;
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
		SolicitudCuenta other = (SolicitudCuenta) obj;
		if (DNI_Cliente == null) {
			if (other.DNI_Cliente != null)
				return false;
		} else if (!DNI_Cliente.equals(other.DNI_Cliente))
			return false;
		if (FechaSolicitud == null) {
			if (other.FechaSolicitud != null)
				return false;
		} else if (!FechaSolicitud.equals(other.FechaSolicitud))
			return false;
		if (ID != other.ID)
			return false;
		if (estadoSolicitud != other.estadoSolicitud)
			return false;
		return true;
	}
	
}
