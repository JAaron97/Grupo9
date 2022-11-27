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
	public boolean insert(Usuario usuario) {
		return daoUser.Insert(usuario);
	}

	

	@Override
	public boolean update(Usuario usuario_a_modificar) {
		return daoUser.Update(usuario_a_modificar);
	}

	@Override
	public List<Usuario> readAll() {
		return daoUser.ReadAll();
	}



	@Override
	public boolean Delete(Usuario Usuario) {
		// TODO Auto-generated method stub
		return daoUser.Delete(Usuario);
	}

}
