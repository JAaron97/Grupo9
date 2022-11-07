package Dao;

import java.util.List;

import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.Usuario;

public interface IDaoUsuario {
	public boolean insert(Usuario usuario, Nacionalidad nacionalidad, Telefono telefono, Localidad localidad);
	public boolean delete(Usuario usuario_a_eliminar);
	public boolean update(Usuario usuario_a_modificar);
	public List<Usuario> readAll();
}
