package Entidad;

public class NumeroCuotas {
	
	private int ID;
	private String Descripcion;
	
	public NumeroCuotas() {}
	
	public NumeroCuotas(int id, String descripcion) {
		
		this.ID = id;
		this.Descripcion = descripcion;
		
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return ID + " - " + Descripcion;
	}
	
	
	
	

}
