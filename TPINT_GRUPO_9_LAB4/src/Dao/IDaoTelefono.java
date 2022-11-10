package Dao;


import Entidad.Telefono;

public interface IDaoTelefono {
	public boolean insert(Telefono telefono);
	public boolean delete(Telefono telefono_a_eliminar);
	public boolean update(Telefono telefono_a_modificar);
	public Telefono Read(int ID);
}
