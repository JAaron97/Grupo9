package NegocioImpl;

import java.util.List;

import DaoImpl.DaoUsuario;
import Entidad.Usuario;
import Negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	
	DaoUsuario daoUser = new DaoUsuario();
	
	@Override
	public boolean insert(Usuario usuario) {
		
		if(UserValidation(usuario)) {
			return daoUser.Insert(usuario);	
		}
	return false;
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

	
	private boolean UserValidation(Usuario user) {
		
		if(DniVerification(user) && NombreVerification(user)) 
		{
			return true;
		}
		
		return false;
	}
	
	private boolean DniVerification(Usuario user) 
	{
		try 
		{
			Integer.parseInt(user.getDNI());
		}
		catch (Exception e) {
			return false;
		}
		
		if(!daoUser.DniExist(user.getDNI())) {
			return true;
		}
		return false;
	}
	
	
	private boolean NombreVerification (Usuario user) 
	{
		String nombrecomple =  user.getApellido() + user.getNombre(); 
		char[] cadena = nombrecomple.toCharArray();
		
		 for (char c : cadena) {
		        if(!Character.isLetter(c)) {
		            return false;
		        }
		    }
		
		return true;
	}
		
	
	
	
	
}
