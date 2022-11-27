package NegocioImpl;

import DaoImpl.DaoTelefono;
import Entidad.Telefono;
import Negocio.TelefonosNeg;

public class TelefonosNegImpl implements TelefonosNeg{

	DaoTelefono dTel = new DaoTelefono();
	
	@Override
	public boolean Insert(Telefono telefono_add) 
	{
		if(ValidationTelefono(telefono_add)== true) 
		{
			return dTel.Insert(telefono_add);	
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean Update(Telefono telefono_update)
	{
		if(ValidationTelefono(telefono_update)== true) 
		{
			return dTel.Update(telefono_update);
		}
		else
		{
			return false;
		}
	}

	@Override
	public Telefono Read(int ID) 
	{
		return dTel.Read(ID);
	}
	
	
	private boolean ValidationTelefono(Telefono telefono)
	{
		try 
		{
			Integer.parseInt(telefono.getTelefono_1());
		}
		catch (Exception e) 
		{
			return false;
		}
		
		if(telefono.getTelefono_1().length() != 8 || telefono.getTelefono_1().length() != 10) {
			
			return false;
		}
			
			return true;	
	}
	
	
	
	
	private boolean TelefonoIsNumber(Telefono telefono) 
	{
		try 
		{
			Integer.parseInt(telefono.getTelefono_1());
		}
		catch (Exception e) 
		{
			return false;
		}
		try 
		{	
			if(telefono.getTelefono_2() != null) 
			{
			Integer.parseInt(telefono.getTelefono_2());
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		try 
		{	
			if(telefono.getTelefono_3() != null) 
			{
			Integer.parseInt(telefono.getTelefono_3());
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		try 
		{	
			if(telefono.getTelefono_4() != null) 
			{
			Integer.parseInt(telefono.getTelefono_4());
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
	
	private boolean TelefonoisCorrect(Telefono telefono) 
	{
		if(telefono.getTelefono_1().length() != 8 || telefono.getTelefono_1().length() != 10) 
		{
			
			return false;
		}
		
		if(telefono.getTelefono_2() != null) 
		{
		if(telefono.getTelefono_2().length() != 8 || telefono.getTelefono_2().length() != 10) 
		{
			
			return false;
		}
		}

		if(telefono.getTelefono_3() != null) 
		{
		if(telefono.getTelefono_3().length() != 8 || telefono.getTelefono_3().length() != 10) 
		{
			
			return false;
		}
		}
		
		if(telefono.getTelefono_4() != null) 
		{
		if(telefono.getTelefono_4().length() != 8 || telefono.getTelefono_4().length() != 10) 
		{
			
			return false;
		}
		}

		return true;
	}
	
	/*private boolean TelefonoDontRepeat(Telefono telefono)
	{
		if(telefono.getTelefono_2() !=null)
		
		
		return true;
	}
	*/
	
}
