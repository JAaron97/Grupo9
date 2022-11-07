package Entidad;

public class Provincia {
	
	private int ID_Provincia;
	private String Descripcion;
	
	public Provincia() {}
	
	public Provincia(int id, String Descipcion) {
		
		this.ID_Provincia = id;
		this.Descripcion = Descipcion;
		
	}


	public int getID_Provincia() {
		return ID_Provincia;
	}


	public void setID_Provincia(int id) {
		ID_Provincia = id;
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
		result = prime * result + ID_Provincia;
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
		Provincia other = (Provincia) obj;
		if (Descripcion == null) {
			if (other.Descripcion != null)
				return false;
		} else if (!Descripcion.equals(other.Descripcion))
			return false;
		if (ID_Provincia != other.ID_Provincia)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return ID_Provincia + "-" + Descripcion;
	}

}
