package NegocioImpl;

import java.util.List;

import DaoImpl.DaoUsuario;
import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.Usuario;
import Negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	
	DaoUsuario daoUser = new DaoUsuario();
	
	@Override
	public boolean insert(Usuario usuario, Nacionalidad nacionalidad, Telefono telefono, Localidad localidad) {
		return daoUser.in(usuario, nacionalidad, telefono, localidad);
	}

	@Override
	public boolean delete(Usuario usuario_a_eliminar) {
		return daoUser.delete(usuario_a_eliminar);
	}

	@Override
	public boolean update(Usuario usuario_a_modificar) {
		return daoUser.update(usuario_a_modificar);
	}

	@Override
	public List<Usuario> readAll() {
		return daoUser.readAll();
	}

}
