package Dao;


import Entidad.Telefono;

public interface IDaoTelefono {
	
	public boolean Insert(Telefono telefono_add);
	
	public boolean Delete(int id);
	
	public boolean Update(Telefono telefono_update);
	
	public Telefono Read(int ID);
}
