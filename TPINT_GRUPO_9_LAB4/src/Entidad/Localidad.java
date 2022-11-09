package Entidad;

public class Localidad {
	
	private int IDLocalidad;
	private Provincia Provincia;
	private String Descripcion;
	
	public Localidad() {}
	
	public Localidad(int id, Provincia provincia, String descripcion) {
		
		this.IDLocalidad = id;
		this.Provincia = provincia;
		this.Descripcion = descripcion;
		
	}


	public int getIDLocalidad() {
		return IDLocalidad;
	}


	public void setIDLocalidad(int iD_Localidad) {
		IDLocalidad = iD_Localidad;
	}


	public Provincia getProvincia() {
		return Provincia;
	}


	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Descripcion == null) ? 0 : Descripcion.hashCode());
		result = prime * result + IDLocalidad;
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
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
		Localidad other = (Localidad) obj;
		if (Descripcion == null) {
			if (other.Descripcion != null)
				return false;
		} else if (!Descripcion.equals(other.Descripcion))
			return false;
		if (IDLocalidad != other.IDLocalidad)
			return false;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return IDLocalidad + "-" +Provincia.getDescripcion() + "-" + Descripcion;
	}
	
	
	
	

}
