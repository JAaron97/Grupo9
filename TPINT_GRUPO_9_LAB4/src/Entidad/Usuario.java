package Entidad;


import java.time.LocalDate;

public class Usuario {
		
		private String DNI;
		private String Nombre;
		private String Apellido;
		private Nacionalidad Nacionalidad;
		private Localidad Localidad;
		private String CUIL;
		private String Sexo;
		private LocalDate Nacimiento;
		private String Direccion;
		private String Mail;
		private Telefono Telefono;
		private String Password;
		private int Estado;
		private int TipoUsuario;
		
	public Usuario() {}
		
	public Usuario(String dni, String nombre, String apellido,
			Nacionalidad nacionalidad, Localidad localidad, String cuil,
			String sexo, LocalDate nacimiento, String direccion, String mail,
			Telefono telefono,String password, int estado, int tipo_usuario) {
			
		
		this.DNI = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Nacionalidad = nacionalidad;
		this.Localidad = localidad;
		this.CUIL = cuil;
		this.Sexo = sexo;
		this.Nacimiento = nacimiento;
		this.Direccion = direccion;
		this.Mail = mail;
		this.Telefono = telefono;
		this.Password = password;
		this.TipoUsuario = tipo_usuario;
		this.Estado = estado;
			
	}
	
	
	
	public String getDNI() {
		return DNI;
	}
	
	
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	
	
	public String getNombre() {
		return Nombre;
	}
	
	
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	
	public String getApellido() {
		return Apellido;
	}
	
	
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
	
	public Nacionalidad getNacionalidad() {
		return Nacionalidad;
	}
	
	
	
	public void setNacionalidad(Nacionalidad nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	
	
	
	public Localidad getLocalidad() {
		return Localidad;
	}
	
	
	
	public void setLocalidad(Localidad localidad) {
		Localidad = localidad;
	}
	
	
	
	public String getCUIL() {
		return CUIL;
	}
	
	
	
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	
	
	
	public String getSexo() {
		return Sexo;
	}
	
	
	
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	
	
	
	public LocalDate getNacimiento() {
		return Nacimiento;
	}
	
	
	
	public void setNacimiento(LocalDate nacimiento) {
		Nacimiento = nacimiento;
	}
	
	
	
	public String getDireccion() {
		return Direccion;
	}
	
	
	
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	
	
	public String getMail() {
		return Mail;
	}
	
	
	
	public void setMail(String mail) {
		Mail = mail;
	}
	
	
	
	public Telefono getTelefono() {
		return Telefono;
	}
	
	
	
	public void setTelefono(Telefono telefono) {
		Telefono = telefono;
	}
	
	
	
	public String getPassword() {
		return Password;
	}
	
	
	
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	public int getTipoUsuario() {
		return TipoUsuario;
	}
	
	
	
	public void setTipoUsuario(int tipo_Usuario) {
		TipoUsuario = tipo_Usuario;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
		result = prime * result + ((CUIL == null) ? 0 : CUIL.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + Estado;
		result = prime * result + ((Localidad == null) ? 0 : Localidad.hashCode());
		result = prime * result + ((Mail == null) ? 0 : Mail.hashCode());
		result = prime * result + ((Nacimiento == null) ? 0 : Nacimiento.hashCode());
		result = prime * result + ((Nacionalidad == null) ? 0 : Nacionalidad.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Sexo == null) ? 0 : Sexo.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + TipoUsuario;
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
		Usuario other = (Usuario) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
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
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (Estado != other.Estado)
			return false;
		if (Localidad == null) {
			if (other.Localidad != null)
				return false;
		} else if (!Localidad.equals(other.Localidad))
			return false;
		if (Mail == null) {
			if (other.Mail != null)
				return false;
		} else if (!Mail.equals(other.Mail))
			return false;
		if (Nacimiento == null) {
			if (other.Nacimiento != null)
				return false;
		} else if (!Nacimiento.equals(other.Nacimiento))
			return false;
		if (Nacionalidad == null) {
			if (other.Nacionalidad != null)
				return false;
		} else if (!Nacionalidad.equals(other.Nacionalidad))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Sexo == null) {
			if (other.Sexo != null)
				return false;
		} else if (!Sexo.equals(other.Sexo))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		if (TipoUsuario != other.TipoUsuario)
			return false;
		return true;
	}
}
