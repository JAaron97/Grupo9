package Entidad;

import java.sql.Date;

public class Cliente {
	String DNI;
	String nombre;
	String apellido;
	int idNacionalidad;
	int idLocalidad;
	String CUIL;
	String sexo;
	Date fechaNac;
	String direccion;
	String mail;
	int idTelefonos;
	String contraseña;
	int tipoUsuario;
	
	public Cliente() {};
	
	public Cliente(String dNI, String nombre, String apellido, int idNacionalidad, int idLocalidad, String cUIL,
			String sexo, Date fechaNac, String direccion, String mail, int idTelefonos, String contraseña,
			int tipoUsuario) {
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.idNacionalidad = idNacionalidad;
		this.idLocalidad = idLocalidad;
		CUIL = cUIL;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.mail = mail;
		this.idTelefonos = idTelefonos;
		this.contraseña = contraseña;
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getIdNacionalidad() {
		return idNacionalidad;
	}
	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getIdTelefonos() {
		return idTelefonos;
	}
	public void setIdTelefonos(int idTelefonos) {
		this.idTelefonos = idTelefonos;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CUIL == null) ? 0 : CUIL.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((fechaNac == null) ? 0 : fechaNac.hashCode());
		result = prime * result + idLocalidad;
		result = prime * result + idNacionalidad;
		result = prime * result + idTelefonos;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + tipoUsuario;
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
		Cliente other = (Cliente) obj;
		if (CUIL == null) {
			if (other.CUIL != null)
				return false;
		} else if (!CUIL.equals(other.CUIL))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (fechaNac == null) {
			if (other.fechaNac != null)
				return false;
		} else if (!fechaNac.equals(other.fechaNac))
			return false;
		if (idLocalidad != other.idLocalidad)
			return false;
		if (idNacionalidad != other.idNacionalidad)
			return false;
		if (idTelefonos != other.idTelefonos)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", idNacionalidad="
				+ idNacionalidad + ", idLocalidad=" + idLocalidad + ", CUIL=" + CUIL + ", sexo=" + sexo + ", fechaNac="
				+ fechaNac + ", direccion=" + direccion + ", mail=" + mail + ", idTelefonos=" + idTelefonos
				+ ", contraseña=" + contraseña + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
}
