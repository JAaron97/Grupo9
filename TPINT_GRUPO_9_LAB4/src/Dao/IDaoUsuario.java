package Dao;

import java.util.List;

import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.Usuario;

public interface IDaoUsuario {
	
	public boolean Insert(Usuario usuario_add);
	
	public boolean Delete(Usuario usuario_delete);
	
	public boolean Update(Usuario usuario_update);
	
	public List<Usuario> ReadAll();
	
	public Usuario Read(String DNI);
}
