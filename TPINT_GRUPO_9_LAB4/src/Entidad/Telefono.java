package Entidad;

public class Telefono {
	
	private int ID_Telefono;
	private String Telefono_1;
	private String Telefono_2;
	private String Telefono_3;
	private String Telefono_4;
	
	public Telefono () {}
	
	public Telefono(int id, String t1,String t2,String t3,String t4) {
		
		this.ID_Telefono = id;
		this.Telefono_1 = t1;
		this.Telefono_2 = t2;
		this.Telefono_3 = t3;
		this.Telefono_4 = t4;
		
		
	}


	public int getID_Telefono() {
		return ID_Telefono;
	}


	public void setID_Telefono(int iD_Telefono) {
		ID_Telefono = iD_Telefono;
	}


	public String getTelefono_1() {
		return Telefono_1;
	}


	public void setTelefono_1(String telefono_1) {
		Telefono_1 = telefono_1;
	}


	public String getTelefono_2() {
		return Telefono_2;
	}


	public void setTelefono_2(String telefono_2) {
		Telefono_2 = telefono_2;
	}


	public String getTelefono_3() {
		return Telefono_3;
	}


	public void setTelefono_3(String telefono_3) {
		Telefono_3 = telefono_3;
	}


	public String getTelefono_4() {
		return Telefono_4;
	}


	public void setTelefono_4(String telefono_4) {
		Telefono_4 = telefono_4;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Telefono;
		result = prime * result + ((Telefono_1 == null) ? 0 : Telefono_1.hashCode());
		result = prime * result + ((Telefono_2 == null) ? 0 : Telefono_2.hashCode());
		result = prime * result + ((Telefono_3 == null) ? 0 : Telefono_3.hashCode());
		result = prime * result + ((Telefono_4 == null) ? 0 : Telefono_4.hashCode());
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
		Telefono other = (Telefono) obj;
		if (ID_Telefono != other.ID_Telefono)
			return false;
		if (Telefono_1 == null) {
			if (other.Telefono_1 != null)
				return false;
		} else if (!Telefono_1.equals(other.Telefono_1))
			return false;
		if (Telefono_2 == null) {
			if (other.Telefono_2 != null)
				return false;
		} else if (!Telefono_2.equals(other.Telefono_2))
			return false;
		if (Telefono_3 == null) {
			if (other.Telefono_3 != null)
				return false;
		} else if (!Telefono_3.equals(other.Telefono_3))
			return false;
		if (Telefono_4 == null) {
			if (other.Telefono_4 != null)
				return false;
		} else if (!Telefono_4.equals(other.Telefono_4))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return ID_Telefono + "-" + Telefono_1 + "-" + Telefono_2 + "-" + Telefono_3 + "-" + Telefono_4 ;
	}
	
	
	
	
	

}
