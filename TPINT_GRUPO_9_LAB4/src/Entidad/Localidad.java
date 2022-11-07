package Entidad;

public class Localidad {
	
	private int ID_Localidad;
	private Provincia Provincia;
	private String Descripcion;
	
	public Localidad() {}
	
	public Localidad(int id, Provincia provincia, String descripcion) {
		
		this.ID_Localidad = id;
		this.Provincia = provincia;
		this.Descripcion = descripcion;
		
	}


	public int getID_Localidad() {
		return ID_Localidad;
	}


	public void setID_Localidad(int iD_Localidad) {
		ID_Localidad = iD_Localidad;
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
		result = prime * result + ID_Localidad;
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
		if (ID_Localidad != other.ID_Localidad)
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
		return ID_Localidad + "-" +Provincia.getDescripcion() + "-" + Descripcion;
	}
	
	
	
	

}
