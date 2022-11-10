package Entidad;

public class Nacionalidad {
	
	private int ID_Nacionalidad;
	private String pais;
	private String gentilicio;
	private String iso;
	
	public Nacionalidad() {}

	public Nacionalidad(int iD_Nacionalidad, String pais, String gentilicio, String iso) {
		ID_Nacionalidad = iD_Nacionalidad;
		this.pais = pais;
		this.gentilicio = gentilicio;
		this.iso = iso;
	}

	public int getID_Nacionalidad() {
		return ID_Nacionalidad;
	}

	public void setID_Nacionalidad(int iD_Nacionalidad) {
		ID_Nacionalidad = iD_Nacionalidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
		result = prime * result + ID_Nacionalidad;
		result = prime * result + ((gentilicio == null) ? 0 : gentilicio.hashCode());
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		if (ID_Nacionalidad != other.ID_Nacionalidad)
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
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nacionalidad [ID_Nacionalidad=" + ID_Nacionalidad + ", pais=" + pais + ", gentilicio=" + gentilicio
				+ ", iso=" + iso + "]";
	}
	
	
}
