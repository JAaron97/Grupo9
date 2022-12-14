package Dao;

import java.util.List;

import Entidad.Usuario;

public interface IDaoUsuario {
	
	public boolean Insert(Usuario usuario_add);
	
	public boolean Delete(Usuario Usuario);
	
	public boolean Update(Usuario usuario_update);
	
	public List<Usuario> ReadAll();
	
	public Usuario Read(String DNI);
	
	public boolean DniExist(String dni);
	
	public boolean CuilExist(String cuil);
}
