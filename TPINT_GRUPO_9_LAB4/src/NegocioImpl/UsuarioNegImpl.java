package NegocioImpl;

import java.time.LocalDate;
import java.time.Period;
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
	
	private boolean CuilVerification(Usuario user)
	{
		try 
		{
			Integer.parseInt(user.getCUIL());
		}
		catch (Exception e) {
			return false;
		}
		
		if(!daoUser.CuilExist(user.getCUIL())) {
			return true;
		}
		return false;
	}
		
	private boolean GeneroVerification(Usuario user) 
	{
		if(user.getSexo().equals("M") || user.getSexo().equals("F")) 
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean NacimientoVerification(Usuario user) 
	{
		
	LocalDate hoy = LocalDate.now();
	
	Period p = Period.between(user.getNacimiento(), hoy);
	
	if(p.getYears() >= 18) {
		return true;
	}
	
	return false;
	
	}
	
	private boolean DireccionVerification(Usuario user) 
	{
		
		if(!user.getDireccion().trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	private boolean MailVerification(Usuario user) 
	{
		 String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(user.getMail());
         return m.matches();	
	}
		
	
}
