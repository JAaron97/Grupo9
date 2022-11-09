package Entidad;

public class Nacionalidad {
	
	private int ID;
	private String Pais;
	private String gentilicio;
	private String iso;
	
	
	public Nacionalidad() {}


	public Nacionalidad(int iD, String pais, String gentilicio, String iso) {
		ID = iD;
		Pais = pais;
		this.gentilicio = gentilicio;
		this.iso = iso;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getPais() {
		return Pais;
	}


	public void setPais(String pais) {
		Pais = pais;
	}


	public String getGentilicio() {
		return gentilicio;
	}


	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}


	public String getIso() {
		return iso;
	}


	public void setIso(String iso) {
		this.iso = iso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Pais == null) ? 0 : Pais.hashCode());
		result = prime * result + ((gentilicio == null) ? 0 : gentilicio.hashCode());
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
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
		Nacionalidad other = (Nacionalidad) obj;
		if (ID != other.ID)
			return false;
		if (Pais == null) {
			if (other.Pais != null)
				return false;
		} else if (!Pais.equals(other.Pais))
			return false;
		if (gentilicio == null) {
			if (other.gentilicio != null)
				return false;
		} else if (!gentilicio.equals(other.gentilicio))
			return false;
		if (iso == null) {
			if (other.iso != null)
				return false;
		} else if (!iso.equals(other.iso))
			return false;
		return true;
	}

	
}
