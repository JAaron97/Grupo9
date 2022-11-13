package Negocio;

import java.util.List;

import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.Usuario;

public interface UsuarioNeg {
	public boolean insert(Usuario usuario);
	public boolean delete(String DNI);
	public boolean update(Usuario usuario_a_modificar);
	public List<Usuario> readAll();
}
